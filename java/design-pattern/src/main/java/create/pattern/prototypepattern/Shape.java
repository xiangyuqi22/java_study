package create.pattern.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.designpattern.GlobalUtils;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月24日
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Shape implements Serializable,Cloneable{
	
	protected long id;
	
	protected String type;
	
	protected Size size;
	
	public abstract void draw();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}
	
	/**
	 * 简单的浅克隆
	 */
	public Shape clone() {
		try {
			return (Shape)super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return null;
	}

	public Size getSize() {
		return size;
	}

	public void setSize(Size size) {
		this.size = size;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	/**
	 * deepClone:(深克隆 )
	 * @author xiangning
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Shape deepClone() throws CloneNotSupportedException {
		// 将对象写到流里
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			System.out.println(this);
			oo.writeObject(this);
			// 从流里读出来
			bi = new ByteArrayInputStream(bo.toByteArray());
			oi = new ObjectInputStream(bi);
			return (Shape)(oi.readObject());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("克隆异常");
		}finally {
			GlobalUtils.closeStream(bo,oo,bi,oi);
		}
		return null;
	}
	

}
