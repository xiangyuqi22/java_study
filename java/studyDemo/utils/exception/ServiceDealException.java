package com.cattsoft.eomsteam.cmpt.ws.stbinter.exception;

import org.apache.commons.lang3.StringUtils;

import com.cattsoft.eomsteam.cmpt.ws.stbinter.api.data.MessageData;

/**
 * <PRE>
 * ͳһ�׳��쳣��
 * 	��Ҫ�����׳��û���������������ǳ����쳣
 * �׳����쳣�ᱻcom.cattsoft.eomsteam.cmpt.ws.stbinter.exception.DefaultExceptionHandler����
 * Ȼ���͵��ͻ��� 
 * </PRE>
 *
 * ��Ŀ���ƣ�stbinter</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2018��12��1��
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
	 * ���췽������
	 * @param message ���ص�ǰ�˵�message��Ϣ���洢��MessageData������
	 * @param errorCode ���ص�ǰ�˵�code�룬�洢��MessageData������
	 */
	public ServiceDealException(String message,String errorCode) {
		super(message);
		this.initMessageData(message,errorCode);
	}
	
	/**
	 * ���췽������
	 * @param messageData ���ص�ǰ�˵���Ϣ
	 */
	public ServiceDealException(MessageData messageData) {
		this.messageData = messageData;
	}
	
	public void initMessageData(String message,String errorCode) {
		if (StringUtils.isEmpty(message)) {
			message = "����ʧ��";
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
