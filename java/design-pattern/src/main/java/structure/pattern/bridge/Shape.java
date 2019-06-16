package structure.pattern.bridge;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年4月26日
 * @author xiangning
 * @since JDK1.8
 */
public abstract class Shape {
	
	protected int x , y , radius;
	
	protected  DrawApi drawApi;
	
	public Shape(DrawApi drawApi , int x , int y ) {
		this.drawApi = drawApi;
		this.x = x;
		this.y = y;
	}
	
	public abstract void draw();

}
