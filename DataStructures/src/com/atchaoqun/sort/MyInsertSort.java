package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyInsertSort {

	public static void main(String[] args) {
		int[] arr = {101, 34, 119, 1, -1, 89};
		// ����Ҫ��80000�������������
//		int[] arr = new int[80000];
//		for (int i = 0; i < 80000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//		}

		System.out.println("��������ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		insertSort(arr); //���ò��������㷨

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);

		System.out.println(Arrays.toString(arr));




	}

	//��������
	public static void insertSort(int[] arr) {
		for (int i=1;i<arr.length;i++){
		//����һ�����������
		int insetVal=arr[i];
		//��ǰ����������±�
		int insetIndex=i-1;
		//��insetVal �ҵ������λ��
		while (insetIndex>=0 && insetVal<arr[insetIndex] ){
				//��ǰ����һλ����ֵ����ǰ���λ��
				arr[insetIndex+1]=arr[insetIndex];
				//�±���ǰŲһλֱ���ҵ�����λ��
				insetIndex--;
		}
		//��ǰһλ����С�ڵ�ǰλ��ֵ��ʱ�򣬽�һ��ʼ��ֵ��ֵ����ǰ���λ��
		arr[insetIndex+1]=insetVal;
	}
}}
