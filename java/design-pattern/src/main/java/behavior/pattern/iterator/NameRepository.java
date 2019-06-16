package behavior.pattern.iterator;
/**
 * <PRE>
 * ���������
 * </PRE>
 *
 * ��Ŀ���ƣ�design_pattern</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��5��7��
 * @author xiangning
 * @since JDK1.8
 */
public class NameRepository implements Container<String> {
	
	private String[] names = new String[] {"�ν�","����","����","ʯ��"};

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
