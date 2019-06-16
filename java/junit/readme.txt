学习笔记：
	
	测试：com.study.junit.demo1.MathDemoTest
		1：运行junit两种方式
			1：使用@Test注解  junit4默认使用注解  目前主要学习使用Junit4
			2：测试用例类  继承TestCase 需要测试的方法名 以《test》开头 junit3 默认使用反射
			
		2：为类快速创建测试用例
			在类名右键 》 选择 new 》 junit test case 》 选择测试类位置 及测试方法即可
		
		3：断言assertEquals(expected, actual)
				expected：期望值
				actual：运行的实际获取的值
		
	测试：com.study.junit.demo1.MathDemoTest2
		1：自动生成的单元测试对象会继承选中的测试对象
		2：@Before @After 会在执行每个测试方法前后执行，对于大量运行测试用例有非常好的优化作用
		3:断言方法使用了静态导入：import static org.junit.Assert.*;

		
	测试：com.study.junit.demo1.TestCaseWithAnnotationTest
		注解：Annotation
			@Test public void method()	
				定义一个要测试的方法
			@Before public void method()	
				在每一个测试之前都会被执行的方法，这个方法常常用来进行一些测试环境的准备，比喻说读入输入数据，初始化类
			@After public void method()	
				与@Before进行对应，做一个清理工作
			@BeforeClass public void method()	
				在所有的测试开始之前执行，这个方法在类运行的时候运行，而且只会运行一次，所以常常用来做一些所有的方法都要依赖到工作，比喻说，数据库的链接。
			@AfterClass public void method()	
				与@BeforeClass进行对应，做一些类级别的清理工作
			@Ignore	
				表明方法是被忽略的，这个方法非常实用，比喻你的方法已经修改，但是对应的测试方法还没有得到一致的修改的时候，可以忽略掉这个测试方法先。
			@Test(expected=IllegalArgumentException.class)	
				检查测试方法是不是抛出了对应的异常
			@Test(timeout=100)	
				如果方法的执行操作所耗费的毫秒数>100MS，那么方法失败。
		
	failure 与 error 的区别
	failure：是断言预想值 与 运行值 结果 不一致导致的失败
	error ：是还没执行到断言方法就出现了意想不到的错误。
	
	
	
	二：使用easyMock
		案例：com.study.junit.easymock.CalcMethodTest
	
	
	三：httpunit
		案例：com.study.junit.httpunit.HttpunitTest1
	
	
	
	
	
	