package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyRadixSort {

	public static void main(String[] args) {
//		int arr[] = { 53, 3, 542, 748, 14, 214};

//		 80000000 * 11 * 4 / 1024 / 1024 / 1024 =3.3G
		int[] arr = new int[8000000];
		for (int i = 0; i < 8000000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // 生成一个[0, 8000000) 数
		}
		System.out.println("排序前");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("排序前的时间是=" + date1Str);

		radixSort(arr);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("排序前的时间是=" + date2Str);

//		System.out.println("基数排序后 " + Arrays.toString(arr));

	}

	//基数排序方法
	public static void radixSort(int[] arr) {

		//1.得到数组中最大的数的位数
		int max=arr[0];
		for (int i : arr) {
			if (i>max){
				max=i;
			}
		}
		int maxLength=(max+"").length();
		for (int i=0,n=1;i<maxLength;i++,n*=10){

			//二维数组包含10个一维数组
			//为了防止在放入数的时候，数据移除，则每一个一维数组。大小定位arr.lenth
			int[][] bucket=new int [10][arr.length];

			//创建一个数组来记录每个桶中数据的个数
			int[] bucketElementCounts=new int[10];
			//第一轮
			for (int j=0;j<arr.length;j++){
				int digitOfElement=arr[j]/n %10;
				//放入对应的桶中，赋值给二维数组
				bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
				//让对应的桶中的个数加1
				bucketElementCounts[digitOfElement]++;
			}
			int index=0;
			//遍历每一个桶，并将桶中的数据，放入到原来的数组
			for (int k=0;k<bucketElementCounts.length;k++){
				//如果桶的个数不为0，遍历
				if (bucketElementCounts[k]!=0){
					//遍历桶
					for (int m=0;m<bucketElementCounts[k];m++){
						arr[index]=bucket[k][m];
						index++;
					}
				}
				bucketElementCounts[k]=0;
			}
		}




	}

}
