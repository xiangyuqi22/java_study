package com.study.algorithm.sort;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.study.algorithm.sort.bubble.BubbleSort;
import com.study.algorithm.sort.insertion.InsertionSort;
import com.study.algorithm.sort.selection.SelectionSort;
import com.study.algorithm.sort.shell.ShellSort;




/**
 * <PRE>
 *  * 学习地址<a href="https://www.cnblogs.com/guoyaohua/p/8600214.html"/>https://www.cnblogs.com/guoyaohua/p/8600214.html</a>
 * 
 * 测试主类 使用jmh基准测试
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2019年12月5日
 * @author xiangning
 * @since JDK1.8
 */
public class MainTest {
	
	
	public static void main(String[] args) throws RunnerException {
		Options options = new OptionsBuilder()
				.include(MainTest.class.getName())
				.warmupIterations(5)
				.measurementIterations(10)
				.forks(1)
				.build();
		new Runner(options).run();
		System.out.println("------------");
		
	}
	

	
	@Benchmark
	public void bubbleSortTest() {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.test1();
	}
	
	
	@Benchmark
	public void selectionSortTest() {
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.test1();
	}
	
	@Benchmark
	public void insertionSortTest() {
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.test1();
	}
	
	@Benchmark
	public void shellSortTest() {
		ShellSort shellSort = new ShellSort();
		shellSort.test1();
	}
	
	

}
