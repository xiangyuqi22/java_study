package other.basic.java.datastructure;

import java.util.BitSet;

/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年5月30日
 * @author xiangning
 * @since JDK1.8
 */
public class BitSetDemo {
	
	public static void main(String[] args) {
		BitSet bitSet1 = new BitSet(20);
		BitSet bitSet2 = new BitSet(20);
		for( int i = 0 ; i < 20 ; i++ ) {
			if( i%2 == 0 ) {
				bitSet1.set(i);
			}else {
				bitSet2.set(i);
			}
		}
		
		for ( int i = 0 ; i < bitSet1.size() ; i++ ) {
			System.out.println(bitSet1.get(i));
		}
		
		System.out.println(" ------------------ ");
		for ( int i = 0 ; i < bitSet2.size() ; i++ ) {
			System.out.println(bitSet2.get(i));
		}
		
	}

}
