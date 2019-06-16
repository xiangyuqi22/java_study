package create.pattern.prototypepattern;

import java.io.Serializable;

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
public class Size implements Serializable{
	
	private int x;
	
	private int y;
	
	private int w;
	
	private int h;

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getW() {
		return w;
	}

	public void setW(int w) {
		this.w = w;
	}

	public int getH() {
		return h;
	}

	public void setH(int h) {
		this.h = h;
	}

	@Override
	public String toString() {
		return "Size [x=" + x + ", y=" + y + ", w=" + w + ", h=" + h + "]";
	}
	
}
