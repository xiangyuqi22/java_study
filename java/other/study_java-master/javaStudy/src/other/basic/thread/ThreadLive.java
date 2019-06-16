package other.basic.thread;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import jdk.nashorn.internal.objects.Global;


/**
 * <PRE>
 * 添加类描述
 * </PRE>
 *
 * 项目名称：javaStudy</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年3月8日
 * @author xiangning
 * @since JDK1.8
 */
public class ThreadLive {
	
	private List<Thread> threadList = new ArrayList<Thread>();
	
	Map<String , Thread> map  =  new HashMap<>();
	
	public static void main(String[] args) throws InterruptedException {
		
		ThreadLive threadLive = new ThreadLive();
		
		threadLive.createThread();
		
		Thread.sleep(1000L);
		
		Map<String, Thread> map2 = threadLive.map;
		
		map2.forEach((k,v) -> System.out.println("k = " + k + ";v = " + (v == null)));
		
		map2.forEach((k,v) -> System.out.println("k = " + k + ";v = " + (v == null)));
		
		
		outWhile : while (true) {
			boolean result = true;
			innerFor : for (Thread t : threadLive.threadList) {
				if(t.isAlive()) {
					System.out.println("线程还在运行中");
					result = false;
					break innerFor;
				}
			}
			Thread.sleep(1000L);
			if(result) {
				break outWhile;
			}
		}
		
		System.out.println("运行结束 ");
		
	}
	
	public void createThread() {
		for (int i = 0; i < 10; i++) {
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Thread t = Thread.currentThread();
					System.out.println("创建了线程" + t.getName());
					map.put(t.getName(), t);
					System.out.println("线程运行结束 " + t.getName());
					threadList.add(Thread.currentThread());
					try {
						Thread.sleep(20000L);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}).start();
		}
	}
	
}
