package com.cattsoft.eomsteam.cmpt.ws.stbinter.exception;

import javax.servlet.http.HttpServletRequest;

import org.jboss.logging.Logger;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.cattsoft.eomsteam.cmpt.ws.stbinter.api.data.FlagData;
import com.cattsoft.eomsteam.cmpt.ws.stbinter.api.data.MessageData;


/**
 * <PRE>
 * 统一异常处理类
 * 只要是服务抛出的异常，都可以在这里接收并处理
 * </PRE>
 *
 * 项目名称：stbinter</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年11月30日
 * @author xiangning
 * @since JDK1.8
 */
@ControllerAdvice
public class DefaultExceptionHandler {
	private static Logger logger = Logger.getLogger(DefaultExceptionHandler.class);
	/**
	 * defaulErrorHandler:(统一粗粒度异常处理，细粒度的需要根据需求另外再写)
	 * @author xiangning
	 *
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
    public MessageData<FlagData> defaulErrorHandler(HttpServletRequest req,Exception e) throws Exception{
		StackTraceElement stackTraceElement= e.getStackTrace()[0];
		logger.error("{className:" + stackTraceElement.getClassName()
				+ ",methodName:" + stackTraceElement.getMethodName() 
				+ ",fileName:" + stackTraceElement.getFileName() 
				+ ",lineNumber:" + stackTraceElement.getLineNumber()
				+ ",message:" + e.getMessage()
				+ ",request-path:" + req.getRequestURI()
				+ "}");
		/**
		 * 用于异常调试，项目完成后需要删除掉
		 */
		if (e instanceof NoHandlerFoundException) {
			return MessageData.isNoService("请求有误，当前服务不存在。地址 = " + req.getRequestURI());
		}
		e.printStackTrace();
		if (e instanceof ServiceDealException) {
			ServiceDealException serviceDealException = (ServiceDealException)e;
			return serviceDealException.getMessageData();
		}else if (e instanceof ClassCastException) {
			return MessageData.isError("找不到可操作的类=" + e.getMessage());
		} else if (e instanceof NullPointerException) {
			return MessageData.isError("传入参数不全=" + e.getMessage());
		}else if (e instanceof NumberFormatException) {
			return MessageData.isError("传入参数有误=" + e.getMessage());
		}
        return MessageData.isError();
    }
}
