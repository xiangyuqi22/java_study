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
     * isOK:(操作成功，无数据返回)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isOK() {
    	String message = "操作成功";
    	return MessageData.getThisObj(MessageData.SUCCESS, message);
	}
    
    /**
     * isOK:(操作成功，可添加返回message)
     * @author xiangning
     *
     * @param message
     * @return
     */
    public static <T> MessageData isOK(String message) {
    	return MessageData.getThisObj(MessageData.SUCCESS, message);
	}
    
    /**
     * isOK:(操作成功，可添加返回数据 data)
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isOK(T t) {
    	String message = "操作成功";
    	return MessageData.getThisObj(MessageData.SUCCESS, t,message);
	}
    
    /**
     * isOK:(操作成功，返回数据 data，可修改message)
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
     * isClientError:(客户端请求有错)
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
     * isClientError:(客户端 请求出错，默认message)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isClientError() {
    	String message = "对不起，操作有误";
    	return MessageData.getThisObj(MessageData.CLIENT_ERROR,message);
	}
    
    /**
     * isOK:(操作失败，不返回数据 )
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isError() {
    	String message = "操作失败，请稍候再试";
    	return MessageData.getThisObj(MessageData.ERROR, message);
	}
    
    /**
     * isOK:(操作失败，不返回数据，可传入错误信息 )
     * @author xiangning
     *
     * @param t
     * @return
     */
    public static <T> MessageData isError(String message) {
    	return MessageData.getThisObj(MessageData.ERROR, message);
	}
    
    /**
     * isNoPower:(用户没有操作权限 )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoPower() {
    	String message = "对不起，您没有操作权限";
    	return MessageData.getThisObj(MessageData.NO_POWER, message);
	}
    
    /**
     * isNoPower:(用户没有操作权限，可传入错误信息 )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoPower(String message) {
    	return MessageData.getThisObj(MessageData.NO_POWER, message);
	}
    
    /**
     * isRefuse:(服务器拒绝操作)
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isRefuse() {
    	String message = "对不起，服务器拒绝了您的操作";
    	return MessageData.getThisObj(MessageData.REFUSE, message);
	}
    
    /**
     * isRefuse:(服务器拒绝操作)
     * @author xiangning
     *
     * @param message
     * @return
     */
    public static <T> MessageData isRefuse(String message) {
    	return MessageData.getThisObj(MessageData.REFUSE, message);
	}

    /**
     * isRefuse:(404 当前服务不存在，默认返回数据 )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoService() {
    	return MessageData.getThisObj(MessageData.NO_SERVICE,"对不起，当前服务不存在");
	}
    
    /**
     * isRefuse:(404 当前服务不存在，自定义返回数据 )
     * @author xiangning
     *
     * @return
     */
    public static <T> MessageData isNoService(String message) {
    	return MessageData.getThisObj(MessageData.NO_SERVICE,message);
	}
    
    /**
     * getThisObj:(获取当前类的对象)
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
     * getThisObj:(获取当前类的对象，一般用于错误信息，不传入data数据)
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
