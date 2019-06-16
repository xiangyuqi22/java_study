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
public interface DrawApi {
	
	/**
	 * DrawCircle:(绘制一个不带颜色的圆形)
	 * @author xiangning
	 *
	 * @param x
	 * @param y
	 * @param radius
	 */
	public void DrawCircle(int x , int y , int radius);
	
	/**
	 * DrawSquare:(绘制一个不带颜色的方形)
	 * @author xiangning
	 *
	 * @param x
	 * @param y
	 */
	public void DrawSquare(int x , int y );
	

}
