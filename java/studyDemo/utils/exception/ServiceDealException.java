package com.cattsoft.eomsteam.cmpt.ws.stbinter.exception;

import org.apache.commons.lang3.StringUtils;

import com.cattsoft.eomsteam.cmpt.ws.stbinter.api.data.MessageData;

/**
 * <PRE>
 * 统一抛出异常。
 * 	主要用来抛出用户处理请求出错，并非程序异常
 * 抛出的异常会被com.cattsoft.eomsteam.cmpt.ws.stbinter.exception.DefaultExceptionHandler接收
 * 然后发送到客户端 
 * </PRE>
 *
 * 项目名称：stbinter</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2018年12月1日
 * @author xiangning
 * @since JDK1.8
 */
public class ServiceDealException extends RuntimeException {
	
	private MessageData messageData = new MessageData();
	
	public ServiceDealException() {
		this.initMessageData(null,null);
	}
	
	public ServiceDealException(String message) {
		super(message);
		this.initMessageData(message,null);
	}
	
	/**
	 * 构造方法重载
	 * @param message 返回到前端的message信息，存储在MessageData对象中
	 * @param errorCode 返回到前端的code码，存储在MessageData对象中
	 */
	public ServiceDealException(String message,String errorCode) {
		super(message);
		this.initMessageData(message,errorCode);
	}
	
	/**
	 * 构造方法重载
	 * @param messageData 返回到前端的信息
	 */
	public ServiceDealException(MessageData messageData) {
		this.messageData = messageData;
	}
	
	public void initMessageData(String message,String errorCode) {
		if (StringUtils.isEmpty(message)) {
			message = "操作失败";
		}
		if (StringUtils.isEmpty(errorCode)) {
			errorCode = MessageData.CLIENT_ERROR;
		}
		this.messageData.setCode(errorCode);
		this.messageData.setMessage(message);
	}

	public MessageData getMessageData() {
		return this.messageData;
	}
	
	

}
