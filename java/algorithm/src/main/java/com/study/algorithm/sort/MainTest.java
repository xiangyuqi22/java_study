package com.study.algorithm.sort;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import com.study.algorithm.sort.bubble.BubbleSort;
import com.study.algorithm.sort.insertion.InsertionSort;
import com.study.algorithm.sort.merge.MergeSort;
import com.study.algorithm.sort.quick.QuickSort;
import com.study.algorithm.sort.radix.RadixSort;
import com.study.algorithm.sort.selection.SelectionSort;
import com.study.algorithm.sort.shell.ShellSort;




/**
 * <PRE>
 *  * ѧϰ��ַ<a href="https://www.cnblogs.com/guoyaohua/p/8600214.html"/>https://www.cnblogs.com/guoyaohua/p/8600214.html</a>
 * 
 * �������� ʹ��jmh��׼����
 * </PRE>
 *
 * ��Ŀ���ƣ�algorithm</BR>
 * ����֧�֣��㶫��ͨ�Ƽ��ɷ����޹�˾ (c) 2017</BR>
 * 
 * @version 1.0 2019��12��5��
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
	}
	

	
	@Benchmark
	public void bubbleSortTest() {
		BubbleSort bubbleSort = new BubbleSort();
		bubbleSort.bubbleSortEfficiencyTest();
	}
	
	
	@Benchmark
	public void selectionSortTest() {
		SelectionSort selectionSort = new SelectionSort();
		selectionSort.selectionSortEfficiencyTest();
	}
	
	@Benchmark
	public void insertionSortTest() {
		InsertionSort insertionSort = new InsertionSort();
		insertionSort.insertionSortEfficiencyTest();
	}
	
	@Benchmark
	public void shellSortTest() {
		ShellSort shellSort = new ShellSort();
		shellSort.shellSortEfficiencyTest();
	}
	
	@Benchmark
	public void quickSortTest() {
		QuickSort quickSort = new QuickSort();
		quickSort.quickSortEfficiencyTest();
	}
	
	@Benchmark
	public void mergeSortTest() {
		MergeSort mergeSort = new MergeSort();
		mergeSort.mergeSortEfficiencyTest();
	}
	
	@Benchmark
	public void radixSortTest() {
		RadixSort radixSort = new RadixSort();
		radixSort.radixSortEfficiencyTest();
	}
	
	
	

}
