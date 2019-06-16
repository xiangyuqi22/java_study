package behavior.pattern.iterator;
/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：design_pattern</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月7日
 * @author xiangning
 * @since JDK1.8
 */
public class NameRepository implements Container<String> {
	
	private String[] names = new String[] {"宋江","武松","李逵","石秀"};

	@Override
	public Iterator<String> getIterator() {
		return new NameIterator();
	}
	
	private class NameIterator implements Iterator<String>{
		
		private int index;

		@Override
		public boolean hasNext() {
			if(index >= names.length) {
				return false;
			}
			return true;
		}

		@Override
		public String next() {
			return names[index++];
		}
		
	}
	
	

}
