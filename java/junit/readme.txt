ѧϰ�ʼǣ�
	
	���ԣ�com.study.junit.demo1.MathDemoTest
		1������junit���ַ�ʽ
			1��ʹ��@Testע��  junit4Ĭ��ʹ��ע��  Ŀǰ��Ҫѧϰʹ��Junit4
			2������������  �̳�TestCase ��Ҫ���Եķ����� �ԡ�test����ͷ junit3 Ĭ��ʹ�÷���
			
		2��Ϊ����ٴ�����������
			�������Ҽ� �� ѡ�� new �� junit test case �� ѡ�������λ�� �����Է�������
		
		3������assertEquals(expected, actual)
				expected������ֵ
				actual�����е�ʵ�ʻ�ȡ��ֵ
		
	���ԣ�com.study.junit.demo1.MathDemoTest2
		1���Զ����ɵĵ�Ԫ���Զ����̳�ѡ�еĲ��Զ���
		2��@Before @After ����ִ��ÿ�����Է���ǰ��ִ�У����ڴ������в��������зǳ��õ��Ż�����
		3:���Է���ʹ���˾�̬���룺import static org.junit.Assert.*;

		
	���ԣ�com.study.junit.demo1.TestCaseWithAnnotationTest
		ע�⣺Annotation
			@Test public void method()	
				����һ��Ҫ���Եķ���
			@Before public void method()	
				��ÿһ������֮ǰ���ᱻִ�еķ������������������������һЩ���Ի�����׼��������˵�����������ݣ���ʼ����
			@After public void method()	
				��@Before���ж�Ӧ����һ��������
			@BeforeClass public void method()	
				�����еĲ��Կ�ʼ֮ǰִ�У���������������е�ʱ�����У�����ֻ������һ�Σ����Գ���������һЩ���еķ�����Ҫ����������������˵�����ݿ�����ӡ�
			@AfterClass public void method()	
				��@BeforeClass���ж�Ӧ����һЩ�༶���������
			@Ignore	
				���������Ǳ����Եģ���������ǳ�ʵ�ã�������ķ����Ѿ��޸ģ����Ƕ�Ӧ�Ĳ��Է�����û�еõ�һ�µ��޸ĵ�ʱ�򣬿��Ժ��Ե�������Է����ȡ�
			@Test(expected=IllegalArgumentException.class)	
				�����Է����ǲ����׳��˶�Ӧ���쳣
			@Test(timeout=100)	
				���������ִ�в������ķѵĺ�����>100MS����ô����ʧ�ܡ�
		
	failure �� error ������
	failure���Ƕ���Ԥ��ֵ �� ����ֵ ��� ��һ�µ��µ�ʧ��
	error ���ǻ�ûִ�е����Է����ͳ��������벻���Ĵ���
	
	
	
	����ʹ��easyMock
		������com.study.junit.easymock.CalcMethodTest
	
	
	����httpunit
		������com.study.junit.httpunit.HttpunitTest1
	
	
	
	
	
	