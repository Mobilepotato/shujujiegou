package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyShellSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

		// 创建要给80000个的随机的数组
		int[] arr = new int[800000];
		for (int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 800000); // 生成一个[0, 8000000) 数
		}

		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

//		shellSort(arr); //交换式
		shellSort2(arr);//移位方式

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

//		System.out.println(Arrays.toString(arr));
	}

	// 使用逐步推导的方式来编写希尔排序
	// 希尔排序时， 对有序序列在插入时采用交换法,
	// 思路(算法) ===> 代码
	public static void shellSort(int[] arr) {
		int temp=0;
		for (int k=arr.length /2 ; k>0; k/=2){
		//希尔排序的第一轮排序
		//因为第一轮排序，是将10个数据分成了5组
		//步长为多少i就为多少，步长为5，i就需要循环5次
		for (int i=k;i<arr.length;i++){
			//j-=5就是将第1，5，10，15，20，25这些元素绑起来为一组，称为步长，将i=10带入便可以理解
			for (int j=i-k;j>=0;j-=k){
				if (arr[j]>arr[j+k]){
					temp=arr[j];
					arr[j]=arr[j+k];
					arr[j+k]=temp;
				}
			}
		}
		}
	}

	//对交换式的希尔排序进行优化->移位法
	public static void shellSort2(int[] arr) {

		// 增量gap, 并逐步的缩小增量
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// 从第gap个元素，逐个对其所在的组进行直接插入排序
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						//移动
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//当退出while后，就给temp找到插入的位置
					arr[j] = temp;
				}

			}
		}
	}

}
