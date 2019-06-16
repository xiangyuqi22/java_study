package create.pattern.prototypepattern;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import com.designpattern.GlobalUtils;

/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��4��24��
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
	 * �򵥵�ǳ��¡
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
	 * deepClone:(���¡ )
	 * @author xiangning
	 *
	 * @return
	 * @throws CloneNotSupportedException
	 */
	public Shape deepClone() throws CloneNotSupportedException {
		// ������д������
		ByteArrayOutputStream bo = null;
		ObjectOutputStream oo = null;
		ByteArrayInputStream bi = null;
		ObjectInputStream oi = null;
		try {
			bo = new ByteArrayOutputStream();
			oo = new ObjectOutputStream(bo);
			System.out.println(this);
			oo.writeObject(this);
			// �����������
			bi = new ByteArrayInputStream(bo.toByteArray());
			oi = new ObjectInputStream(bi);
			return (Shape)(oi.readObject());
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("��¡�쳣");
		}finally {
			GlobalUtils.closeStream(bo,oo,bi,oi);
		}
		return null;
	}
	

}
