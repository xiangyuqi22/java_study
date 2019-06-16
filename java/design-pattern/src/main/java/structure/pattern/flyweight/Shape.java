package structure.pattern.flyweight;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月2日
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Shape {
	
	protected int x,y,radius;
	
	protected String color;
	
	protected String type;
	
	public abstract void draw() ;
	
	public Shape( int x , int y , int radius , String color ) {
		this.x = x;
		this.y = y;
		this.radius = radius;
		this.color = color;
		setType();
	}
	
	protected abstract void setType();

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

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	

}
