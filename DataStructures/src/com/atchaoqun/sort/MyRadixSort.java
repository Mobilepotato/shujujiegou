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
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}
		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		radixSort(arr);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);

//		System.out.println("��������� " + Arrays.toString(arr));

	}

	//�������򷽷�
	public static void radixSort(int[] arr) {

		//1.�õ���������������λ��
		int max=arr[0];
		for (int i : arr) {
			if (i>max){
				max=i;
			}
		}
		int maxLength=(max+"").length();
		for (int i=0,n=1;i<maxLength;i++,n*=10){

			//��ά�������10��һά����
			//Ϊ�˷�ֹ�ڷ�������ʱ�������Ƴ�����ÿһ��һά���顣��С��λarr.lenth
			int[][] bucket=new int [10][arr.length];

			//����һ����������¼ÿ��Ͱ�����ݵĸ���
			int[] bucketElementCounts=new int[10];
			//��һ��
			for (int j=0;j<arr.length;j++){
				int digitOfElement=arr[j]/n %10;
				//�����Ӧ��Ͱ�У���ֵ����ά����
				bucket[digitOfElement][bucketElementCounts[digitOfElement]]=arr[j];
				//�ö�Ӧ��Ͱ�еĸ�����1
				bucketElementCounts[digitOfElement]++;
			}
			int index=0;
			//����ÿһ��Ͱ������Ͱ�е����ݣ����뵽ԭ��������
			for (int k=0;k<bucketElementCounts.length;k++){
				//���Ͱ�ĸ�����Ϊ0������
				if (bucketElementCounts[k]!=0){
					//����Ͱ
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
