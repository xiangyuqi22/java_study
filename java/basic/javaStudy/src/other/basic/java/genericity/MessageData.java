package other.basic.java.genericity;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�javaStudy</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��23��
 * @author xiangning
 * @since JDK1.8
 */
public class MessageData<T,E,F> {
	
	private T data;
	
	private E dataE;
	
	private F dataF;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public E getDataE() {
		return dataE;
	}

	public void setDataE(E dataE) {
		this.dataE = dataE;
	}

	public F getDataF() {
		return dataF;
	}

	public void setDataF(F dataF) {
		this.dataF = dataF;
	}

	@Override
	public String toString() {
		return "MessageData [data=" + data + ", dataE=" + dataE + ", dataF=" + dataF + "]";
	}
	
	

}
