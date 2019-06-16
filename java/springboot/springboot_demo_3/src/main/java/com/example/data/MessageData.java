package com.example.data;


import java.io.Serializable;


@SuppressWarnings("all")
public class MessageData<T> implements Serializable {
	
    private String message;

    private T data;

    private String code = MessageData.SUCCESS;
    
    public static final String SUCCESS = "200";
    public static final String CLIENT_ERROR = "400";
    public static final String NO_POWER = "401";
    public static final String REFUSE = "403";
    public static final String NO_SERVICE = "404";
    public static final String ERROR = "500";
    
    /**
     * isOK:(�����ɹ��������ݷ���)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isOK() {
    	String message = "�����ɹ�";
    	return MessageData.getThisObj(MessageData.SUCCESS, message);
	}
    
    /**
     * isOK:(�����ɹ�������ӷ���message)
     * @author xiangning
     *
     * @param message
     * @return
     */
    public static <T> MessageData isOK(String message) {
    	return MessageData.getThisObj(MessageData.SUCCESS, message);
	}
    
    /**
     * isOK:(�����ɹ�������ӷ������� data)
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isOK(T t) {
    	String message = "�����ɹ�";
    	return MessageData.getThisObj(MessageData.SUCCESS, t,message);
	}
    
    /**
     * isOK:(�����ɹ����������� data�����޸�message)
     * @author xiangning
     *
     * @param t
     * @param message
     * @return
     */
    public static <T> MessageData isOK(T t,String message) {
    	return MessageData.getThisObj(MessageData.SUCCESS, t,message);
	}
    
    /**
     * isClientError:(�ͻ��������д�)
     * @author xiangning
     *
     * @param t
     * @param message
     * @return
     */
    public static <T> MessageData isClientError(String message) {
    	return MessageData.getThisObj(MessageData.CLIENT_ERROR,message);
	}
    
    /**
     * isClientError:(�ͻ��� �������Ĭ��message)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isClientError() {
    	String message = "�Բ��𣬲�������";
    	return MessageData.getThisObj(MessageData.CLIENT_ERROR,message);
	}
    
    /**
     * isOK:(����ʧ�ܣ����������� )
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isError() {
    	String message = "����ʧ�ܣ����Ժ�����";
    	return MessageData.getThisObj(MessageData.ERROR, message);
	}
    
    /**
     * isOK:(����ʧ�ܣ����������ݣ��ɴ��������Ϣ )
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isError(String message) {
    	return MessageData.getThisObj(MessageData.ERROR, message);
	}
    
    /**
     * isNoPower:(�û�û�в���Ȩ�� )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoPower() {
    	String message = "�Բ�����û�в���Ȩ��";
    	return MessageData.getThisObj(MessageData.NO_POWER, message);
	}
    
    /**
     * isNoPower:(�û�û�в���Ȩ�ޣ��ɴ��������Ϣ )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoPower(String message) {
    	return MessageData.getThisObj(MessageData.NO_POWER, message);
	}
    
    /**
     * isRefuse:(�������ܾ�����)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isRefuse() {
    	String message = "�Բ��𣬷������ܾ������Ĳ���";
    	return MessageData.getThisObj(MessageData.REFUSE, message);
	}
    
    /**
     * isRefuse:(�������ܾ�����)
     * @author xiangning
     *
     * @param message
     * @return
     */
    public static <T> MessageData isRefuse(String message) {
    	return MessageData.getThisObj(MessageData.REFUSE, message);
	}

    /**
     * isRefuse:(404 ��ǰ���񲻴��ڣ�Ĭ�Ϸ������� )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoService() {
    	return MessageData.getThisObj(MessageData.NO_SERVICE,"�Բ��𣬵�ǰ���񲻴���");
	}
    
    /**
     * isRefuse:(404 ��ǰ���񲻴��ڣ��Զ��巵������ )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoService(String message) {
    	return MessageData.getThisObj(MessageData.NO_SERVICE,message);
	}
    
    /**
     * getThisObj:(��ȡ��ǰ��Ķ���)
     * @author xiangning
     *
     * @param code
     * @param data
     * @param message
     * @return
     */
    public static <T> MessageData getThisObj(String code,T data,String message) {
    	MessageData<T> messageData = new MessageData<T>();
    	messageData.setCode(code);
    	messageData.setMessage(message);
    	messageData.setData(data);
    	return messageData;
    }
      
    
    /**
     * getThisObj:(��ȡ��ǰ��Ķ���һ�����ڴ�����Ϣ��������data����)
     * @author xiangning
     *
     * @param code
     * @param message
     * @return
     */
    public static <T> MessageData getThisObj(String code,String message) {
    	MessageData<T> messageData = new MessageData<T>();
    	messageData.setCode(code);
    	messageData.setMessage(message);
    	return messageData;
    }

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

    
}
