package other.basic.java.genericity;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月23日
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
