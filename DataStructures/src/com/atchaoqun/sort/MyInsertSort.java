package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyInsertSort {

	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1, -1, 89};
		// 创建要给80000个的随机的数组
//		int[] arr = new int[80000];
//		for (int i = 0; i < 80000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
//		}

		System.out.println("插入排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		insertSort(arr); //调用插入排序算法

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

		System.out.println(Arrays.toString(arr));




	}

	//插入排序
	public static void insertSort(int[] arr) {
		for (int i=1;i<arr.length;i++){
		//定义一个待插入的数
		int insetVal=arr[i];
		//即前面这个数的下标
		int insetIndex=i-1;
		//给insetVal 找到插入的位置
		while (insetIndex>=0 && insetVal<arr[insetIndex] ){
				//把前面那一位数赋值给当前这个位置
				arr[insetIndex+1]=arr[insetIndex];
				//下标向前挪一位直到找到合适位置
				insetIndex--;
		}
		//当前一位不再小于当前位的值的时候，将一开始的值赋值给当前这个位置
		arr[insetIndex+1]=insetVal;
	}
}}
