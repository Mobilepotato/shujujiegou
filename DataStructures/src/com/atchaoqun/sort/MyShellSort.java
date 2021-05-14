package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyShellSort {

	public static void main(String[] args) {
//		int[] arr = { 8, 9, 1, 7, 2, 3, 5, 4, 6, 0 };

		// ����Ҫ��80000�������������
		int[] arr = new int[800000];
		for (int i = 0; i < 800000; i++) {
			arr[i] = (int) (Math.random() * 800000); // ����һ��[0, 8000000) ��
		}

		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

//		shellSort(arr); //����ʽ
		shellSort2(arr);//��λ��ʽ

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);

//		System.out.println(Arrays.toString(arr));
	}

	// ʹ�����Ƶ��ķ�ʽ����дϣ������
	// ϣ������ʱ�� �����������ڲ���ʱ���ý�����,
	// ˼·(�㷨) ===> ����
	public static void shellSort(int[] arr) {
		int temp=0;
		for (int k=arr.length /2 ; k>0; k/=2){
		//ϣ������ĵ�һ������
		//��Ϊ��һ�������ǽ�10�����ݷֳ���5��
		//����Ϊ����i��Ϊ���٣�����Ϊ5��i����Ҫѭ��5��
		for (int i=k;i<arr.length;i++){
			//j-=5���ǽ���1��5��10��15��20��25��ЩԪ�ذ�����Ϊһ�飬��Ϊ��������i=10�����������
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

	//�Խ���ʽ��ϣ����������Ż�->��λ��
	public static void shellSort2(int[] arr) {

		// ����gap, ���𲽵���С����
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			// �ӵ�gap��Ԫ�أ�����������ڵ������ֱ�Ӳ�������
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						//�ƶ�
						arr[j] = arr[j-gap];
						j -= gap;
					}
					//���˳�while�󣬾͸�temp�ҵ������λ��
					arr[j] = temp;
				}

			}
		}
	}

}
