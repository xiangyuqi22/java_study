package com.study.algorithm.sort.quick;

import java.util.Arrays;

import org.junit.Test;

import com.study.algorithm.sort.SortUtils;

/**
 * <PRE>
 * 快速排序算法 - 冒泡排序升级版
 * </PRE>
 *
 * 项目名称：algorithm</BR>
 * 技术支持：广东凯通科技股份有限公司 (c) 2017</BR>
 * 
 * @version 1.0 2020年2月7日
 * @author xiangning
 * @since JDK1.8
 */
public class QuickSort {

	
	
	@Test
	public void quickSortTest() {
		int[] arrs = new int[] { -9, 78, 99, 23,0, 23,23,23,23 -567, -70, -22, 18,23};
//		 arrs = new int[] {-9,78,0,23,-567,70};
		 arrs = new int[] {-9,78,23,0,23,-567,70,23};
		// arrs = SortUtils.createArray(80000);
//		 arrs = SortUtils.createArray(100);
//		arrs = new int[] {-567, -70};
//		arrs = new int[] {-70, -567};
		int left = 0;
		int right = arrs.length - 1;
		System.out.println("原始数组 = " + Arrays.toString(arrs));
		quickSort(arrs, left, right);
//		quickSort(left,right,arrs);
	}

	private void quickSort(int[] arrs, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arrs[(left+right)/2];
		System.out.println("基准数 = " + pivot);
		int temp;
		while(l < r) {
			//从左边开始找到大于或等于基准值的数
			while(arrs[l] < pivot) {
				l++;
			}
			//从右边开始，找到小于或等于基准值的数
			while(arrs[r] > pivot ) {
				r--;
			}
			if(l >= r) {
				//如果左边的指针超过了右边的指针，表示所有数据都找好了，可以结束循环
				break;
			}
			//找到了可替换的数据，可以进行交换了
			temp = arrs[l];
			arrs[l] = arrs[r];
			arrs[r] = temp;
			
			//如果刚刚右边找到的数据跟基准值是一样的，为了防止死循环，那么右边的指针需要向左移动一下
			if(arrs[r] == pivot) {
				//上面数据交换时，已经将右边的数据替换到了左边
				l++;
			}
			if(arrs[l] == pivot) {
				r--;
			}
		}
		
		if(l == r) {
			l++;
			r--;
		}
		if( r > left) {
			quickSort(arrs, left, r);
		}
		if(l < right) {
			quickSort(arrs, l, right);
		}
		System.out.println("处理后的数组 = " + Arrays.toString(arrs));
	}
	
	
	/**
	 * quickSortEfficiencyTest:(快速排序效率测试)
	 * @author xiangning
	 *
	 */
	@Test
	public void quickSortEfficiencyTest() {
		int[] arrs = SortUtils.createArray(80000);
		quickSort1(arrs, 0, arrs.length-1);
	}
	
	/**
	 * quickSortEfficiency8000000Test:(快速排序测试8百万个数据)
	 * @author xiangning
	 *
	 */
	@Test
	public void quickSortEfficiency8000000Test() {
		int[] arrs = SortUtils.createArray(8000000);
		quickSort1(arrs, 0, arrs.length-1);
	}
	
	
	private void quickSort1(int[] arrs, int left, int right) {
		int l = left;
		int r = right;
		int pivot = arrs[(left+right)/2];
		int temp;
		while(l < r) {
			//从左边开始找到大于或等于基准值的数
			while(arrs[l] < pivot) {
				l++;
			}
			//从右边开始，找到小于或等于基准值的数
			while(arrs[r] > pivot ) {
				r--;
			}
			if(l >= r) {
				//如果左边的指针超过了右边的指针，表示所有数据都找好了，可以结束循环
				break;
			}
			//找到了可替换的数据，可以进行交换了
			temp = arrs[l];
			arrs[l] = arrs[r];
			arrs[r] = temp;
			
			//如果刚刚右边找到的数据跟基准值是一样的，为了防止死循环，那么右边的指针需要向左移动一下
			if(arrs[r] == pivot) {
				//上面数据交换时，已经将右边的数据替换到了左边
				l++;
			}
			if(arrs[l] == pivot) {
				r--;
			}
		}
		
		if(l == r) {
			l++;
			r--;
		}
		if( r > left) {
			quickSort1(arrs, left, r);
		}
		if(l < right) {
			quickSort1(arrs, l, right);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
