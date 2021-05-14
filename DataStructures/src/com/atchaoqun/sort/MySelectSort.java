package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

//ѡ������
public class MySelectSort {

	public static void main(String[] args) {
//		int [] arr = {101, 34, 119, 1, -1, 90, 123};

		//����Ҫ��80000�������������
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
		}

//		System.out.println("����ǰ");
//		System.out.println(Arrays.toString(arr));

		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		selectSort(arr);


		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);

//		System.out.println("�����");
//		System.out.println(Arrays.toString(arr));


	}

	//ѡ������
	public static void selectSort(int[] arr) {



		for (int i=0;i<arr.length;i++){
			int temp1=arr[i];
			for (int j=i;j<arr.length;j++){
				if (arr[j]<temp1){

					arr[i]=arr[j];
					arr[j]=temp1;
				}
			}
		}
		/*

		//ʹ�����Ƶ��ķ�ʽ��������ѡ������
		//��1��
		//ԭʼ������ �� 	101, 34, 119, 1
		//��һ������ :   	1, 34, 119, 101
		//�㷨 �ȼ�--�� �����ӣ� ���ǿ��԰�һ�����ӵ��㷨����ֳɼ򵥵�����-���𲽽��

		//��1��
		int minIndex = 0;
		int min = arr[0];
		for(int j = 0 + 1; j < arr.length; j++) {
			if (min > arr[j]) { //˵���ٶ�����Сֵ����������С
				min = arr[j]; //����min
				minIndex = j; //����minIndex
			}
		}


		//����Сֵ������arr[0], ������
		if(minIndex != 0) {
			arr[minIndex] = arr[0];
			arr[0] = min;
		}

		System.out.println("��1�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101


		//��2��
		minIndex = 1;
		min = arr[1];
		for (int j = 1 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if(minIndex != 1) {
			arr[minIndex] = arr[1];
			arr[1] = min;
		}

		System.out.println("��2�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 119, 101

		//��3��
		minIndex = 2;
		min = arr[2];
		for (int j = 2 + 1; j < arr.length; j++) {
			if (min > arr[j]) { // ˵���ٶ�����Сֵ����������С
				min = arr[j]; // ����min
				minIndex = j; // ����minIndex
			}
		}

		// ����Сֵ������arr[0], ������
		if (minIndex != 2) {
			arr[minIndex] = arr[2];
			arr[2] = min;
		}

		System.out.println("��3�ֺ�~~");
		System.out.println(Arrays.toString(arr));// 1, 34, 101, 119 */




	}

}
