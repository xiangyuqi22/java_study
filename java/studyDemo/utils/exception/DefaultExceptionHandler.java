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
 * ͳһ�쳣������
 * ֻҪ�Ƿ����׳����쳣����������������ղ�����
 * </PRE>
 *
 * ��Ŀ���ƣ�stbinter</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��11��30��
 * @author xiangning
 * @since JDK1.8
 */
@ControllerAdvice
public class DefaultExceptionHandler {
	private static Logger logger = Logger.getLogger(DefaultExceptionHandler.class);
	/**
	 * defaulErrorHandler:(ͳһ�������쳣����ϸ���ȵ���Ҫ��������������д)
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
		 * �����쳣���ԣ���Ŀ��ɺ���Ҫɾ����
		 */
		if (e instanceof NoHandlerFoundException) {
			return MessageData.isNoService("�������󣬵�ǰ���񲻴��ڡ���ַ = " + req.getRequestURI());
		}
		e.printStackTrace();
		if (e instanceof ServiceDealException) {
			ServiceDealException serviceDealException = (ServiceDealException)e;
			return serviceDealException.getMessageData();
		}else if (e instanceof ClassCastException) {
			return MessageData.isError("�Ҳ����ɲ�������=" + e.getMessage());
		} else if (e instanceof NullPointerException) {
			return MessageData.isError("���������ȫ=" + e.getMessage());
		}else if (e instanceof NumberFormatException) {
			return MessageData.isError("�����������=" + e.getMessage());
		}
        return MessageData.isError();
    }
}
