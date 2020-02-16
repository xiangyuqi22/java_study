# 查找算法

[参考地址1：https://blog.csdn.net/fafawf/article/details/81457650](https://blog.csdn.net/fafawf/article/details/81457650)

## 1、简述

```
查找是在大量的信息中寻找一个特定的信息元素，在计算机应用中，查找是常用的基本运算，例如编译程序中符号表的查找。本文简单概括性的介绍了常见的七种查找算法，说是七种，其实二分查找、插值查找以及斐波那契查找都可以归为一类——插值查找。插值查找和斐波那契查找是在二分查找的基础上的优化查找算法。树表查找和哈希查找会在后续的博文中进行详细介绍。

查找定义：
	根据给定的某个值，在查找表中确定一个其关键字等于给定值的数据元素（或记录）。

查找算法分类：
　　1）静态查找和动态查找；
　　　　注：静态或者动态都是针对查找表而言的。动态表指查找表中有删除和插入操作的表。
　　2）无序查找和有序查找。
　　　　无序查找：被查找数列有序无序均可；
　　　　有序查找：被查找数列必须为有序数列。

平均查找长度（Average Search Length，ASL）：
	需和指定key进行比较的关键字的个数的期望值，称为查找算法在查找成功时的平均查找长度。
　　对于含有n个数据元素的查找表，查找成功的平均查找长度为：ASL = Pi*Ci的和。
      Pi：查找表中第i个数据元素的概率。
      Ci：找到第i个数据元素时已经比较过的次数。
　　
```

## 2、有序查找

### 1、二分查找

**说明：元素必须是有序的，如果是无序的则要先进行排序操作。**

**基本思想：**

​		也称为是折半查找，属于有序查找算法。用给定值k先与中间结点的关键字比较，中间结点把线形表分成两个子表，若相等则查找成功；若不相等，再根据k与该中间结点关键字的比较结果确定下一步查找哪个子表，这样递归进行，直到查找到或查找结束发现表中没有这样的结点。

**复杂度分析：**

​		最坏情况下，关键词比较次数为log2(n+1)，且**期望时间复杂度为O(log2n)**；

注：**折半查找的前提条件是需要有序表顺序存储，对于静态查找表，一次排序后不再变化，折半查找能得到不错的效率。但对于需要频繁执行插入或删除操作的数据集来说，维护有序的排序会带来不小的工作量，那就不建议使用。**

```java
//非递归实现
public int binarySearch(int[] arrs,int key) {
		int left = 0;
		int right = arrs.length -1;
		int mid = -1;
		while(left <= right) {
			mid = (right + left)/2;
			if(arrs[mid] > key) {
				right = mid - 1;
			}else if(arrs[mid] < key) {
				left = mid + 1;
			}else {
				return mid;
			}
		}
		return -1;
	}
```



```java
//递归实现
private int binarySearch(int[] arrs, int data,int left,int right) {
		int index = -1;
		if(left < right) {
			int mid = (right + 1 + left)/2;
			if(arrs[mid] > data) {
				return binarySearch1(arrs, data, left, mid-1);
			}else if (arrs[mid] < data) {
				return binarySearch1(arrs, data, mid+1, right);
			}else {
				index = mid;
			}
		}
		return index;
	}
```



### 2、插值查找

在介绍插值查找之前，首先考虑一个新问题，为什么上述算法一定要是折半，而不是折四分之一或者折更多呢？

　　打个比方，在英文字典里面查“apple”，你下意识翻开字典是翻前面的书页还是后面的书页呢？如果再让你查“zoo”，你又怎么查？很显然，这里你绝对不会是从中间开始查起，而是有一定目的的往前或往后翻。

　　同样的，比如要在取值范围1 ~ 10000 之间 100 个元素从小到大均匀分布的数组中查找5， 我们自然会考虑从数组下标较小的开始查找。

　　经过以上分析，折半查找这种查找方式，不是自适应的（也就是说是傻瓜式的）。二分查找中查找点计算如下：

　　mid=(low+high)/2, 即mid=low+1/2*(high-low);

　　通过类比，我们可以将查找的点改进为如下：

　　**mid=low+(key-a[low])/(a[high]-a[low])*(high-low)**，

　　也就是将上述的比例参数1/2改进为自适应的，根据关键字在整个有序表中所处的位置，让mid值的变化更靠近关键字key，这样也就间接地减少了比较次数。

　　**基本思想：**基于二分查找算法，将查找点的选择改进为自适应选择，可以提高查找效率。当然，差值查找也属于有序查找。

　　注：**对于表长较大，而关键字分布又比较均匀的查找表来说，插值查找算法的平均性能比折半查找要好的多。反之，数组中如果分布非常不均匀，那么插值查找未必是很合适的选择。**

　　**复杂度分析：查找成功或者失败的时间复杂度均为O(log2(log2n))。**

```java
private int insertSearch(int[] arrs, int data,int left,int right) {
		count++;
		int index = -1;
		if(left < right) {
			int mid = left + (data - arrs[left])/(arrs[right] - arrs[left])*(right - left);
			if(arrs[mid] > data) {
				//如果找到的值大于查找的数据则向左继续查找
				return insertSearch(arrs, data, left, mid-1);
			}else if (arrs[mid] < data) {
				//如果找到的值要小于目标值，则需要向右查找
				return insertSearch(arrs, data, mid+1, right);
			}else {
				index = mid;
			}
		}
		return index;
	}
```

### 3、斐波那契查找

​		在介绍斐波那契查找算法之前，我们先介绍一下很它紧密相连并且大家都熟知的一个概念——黄金分割。

　　黄金比例又称黄金分割，是指事物各部分间一定的数学比例关系，即将整体一分为二，较大部分与较小部分之比等于整体与较大部分之比，其比值约为1:0.618或1.618:1。

　　0.618被公认为最具有审美意义的比例数字，这个数值的作用不仅仅体现在诸如绘画、雕塑、音乐、建筑等艺术领域，而且在管理、工程设计等方面也有着不可忽视的作用。因此被称为黄金分割。

　　大家记不记得斐波那契数列：1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89…….（从第三个数开始，后边每一个数都是前两个数的和）。然后我们会发现，随着斐波那契数列的递增，前后两个数的比值会越来越接近0.618，利用这个特性，我们就可以将黄金比例运用到查找技术中。

![img](20150323100632467.jfif)

**基本思想：**斐波那契也是二分查找的一种提升算法，通过运用黄金比例的概念在数列中选择查找点进行查找，提高查找效率。同样地，斐波那契查找也属于一种有序查找算法。

　　相对于折半查找，一般将待比较的key值与第mid=（low+high）/2位置的元素比较，比较结果分三种情况：

　　1）相等，mid位置的元素即为所求

　　2）>，low=mid+1;

   3）<，high=mid-1。

　　斐波那契查找与折半查找很相似，他是根据斐波那契序列的特点对有序表进行分割的。他要求开始表中记录的个数为某个斐波那契数小1，及n=F(k)-1;

 开始将k值与第F(k-1)位置的记录进行比较(及mid=low+F(k-1)-1),比较结果也分为三种

　　1）相等，mid位置的元素即为所求

　　2）>，low=mid+1,k-=2;

　　说明：low=mid+1说明待查找的元素在[mid+1,high]范围内，k-=2 说明范围[mid+1,high]内的元素个数为n-(F(k-1))= Fk-1-F(k-1)=Fk-F(k-1)-1=F(k-2)-1个，所以可以递归的应用斐波那契查找。

　　3）<，high=mid-1,k-=1。

　　说明：low=mid+1说明待查找的元素在[low,mid-1]范围内，k-=1 说明范围[low,mid-1]内的元素个数为F(k-1)-1个，所以可以递归 的应用斐波那契查找。

　　**复杂度分析：最坏情况下，时间复杂度为O(log2n)，且其期望复杂度也为O(log2n)。**

```java
private int fibonacciSearch1(int[] arrs, int key) {
		//1、创建一个斐波那契数列，数列逻辑如：{1,1,2,3,5,8,13,21,34}
		int[] fibArrs = new int[20];
		fibArrs[0] = 1;
		fibArrs[1] = 1;
		for (int i = 2; i < fibArrs.length; i++) {
			fibArrs[i] = fibArrs[i-1] + fibArrs[i-2];
		}
		System.out.println("获取到的斐波那契数列  = " + Arrays.toString(fibArrs));
		int low = 0;
		int high = arrs.length - 1;
		int mid = 0;
		int k = 0;
		while(arrs.length >= fibArrs[k]) {
			k++;
		}
		System.out.println("数组长度 = " + fibArrs[k]);
		//创建一个适合斐波那契长度的数列
		int[] tempArrs = Arrays.copyOf(arrs, fibArrs[k]);
		//将新扩充的数组后面的数据以原始数据的最后一个数据进行填充
		for (int i = arrs.length; i < tempArrs.length; i++) {
			tempArrs[i] = arrs[high];
		}
		System.out.println("优化后的临时数组 = " + Arrays.toString(tempArrs));
		
		//循环求索引
		int temp;
		while(low <= high) {
			System.out.println("查询次数 = "+ ++count);
			mid = low + fibArrs[k - 1] - 1; //
			temp = tempArrs[mid];
			if(temp > key) {
				//如果当前值比目标值要大，则需要向左寻找，左边即为斐波那契数组的前一个数的区域
				high = mid -1;
				k--;
			}else if(temp < key) {
				//如果当前值比目标值要小，则需要向右寻找，
				low = mid + 1;
				k -= 2;
			}else {
				if(mid > arrs.length-1) {
					return arrs.length-1;
				}else {
					return mid;
				}
			}
		}
		return -1;
	}
```



## 3、无序查找

### 1、顺序查找

**说明：顺序查找适合于存储结构为顺序存储或链接存储的线性表。**

**基本思想：**

​		顺序查找也称为线形查找，属于无序查找算法。从数据结构线形表的一端开始，顺序扫描，依次将扫描到的结点关键字与给定值k相比较，若相等则表示查找成功；若扫描结束仍没有找到关键字等于k的结点，表示查找失败。

**复杂度分析：**　

​		查找成功时的平均查找长度为：（假设每个数据元素的概率相等） ASL = 1/n(1+2+3+…+n) = (n+1)/2 ;
​		当查找不成功时，需要n+1次比较，时间复杂度为O(n);

所以，**顺序查找的时间复杂度为O(n)。**

```java
public int sequenceSearch1(int[] arrs,int key) {
		for (int i = 0; i < arrs.length; i++) {
			if(arrs[i] == key) {
				return i;
			}
		}
		return -1;
	}
```

