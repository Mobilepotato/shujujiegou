package com.atchaoqun.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class MyQuickSort {

	public static void main(String[] args) {
		int[] arr = {-9,78,500,900,0,23,-567,-99,70, -1,901, 4561};

		//���Կ��ŵ�ִ���ٶ�
		// ����Ҫ��80000�������������
//		int[] arr = new int[8000000];
//		for (int i = 0; i < 8000000; i++) {
//			arr[i] = (int) (Math.random() * 8000000); // ����һ��[0, 8000000) ��
//		}

		System.out.println("����ǰ");
		Date data1 = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1Str = simpleDateFormat.format(data1);
		System.out.println("����ǰ��ʱ����=" + date1Str);

		quickSort(arr, 0, arr.length-1);

		Date data2 = new Date();
		String date2Str = simpleDateFormat.format(data2);
		System.out.println("����ǰ��ʱ����=" + date2Str);
		System.out.println("arr=" + Arrays.toString(arr));
	}

	public static void quickSort(int[] arr,int left, int right) {
		int l = left; //���±�
		int r = right; //���±�
		//pivot�����ֵ
		int pivot=arr[(right+left)/2];
		int temp = 0;
		while (l<r){
			//һֱ��ֱ����һ����ߵ�ֵ����pivot
			while (arr[l]<pivot){
				l+=1;
			}
			//һֱ��ֱ����һ���ұߵ�ֵС��pivot
			while (arr[r]>pivot){
				r-=1;
			}
			//���1>=r˵��pivot���������ߵ�ֵ���Ѿ����մ�С����
			if (l>=r){
				break;
			}
			//����
			temp=arr[l];
			arr[l]=arr[r];
			arr[r]=temp;
			//��������꣬����arr[l]==pivot,˵��r�Ѿ���pivot���λ����r-1����Ϊ��һ�εݹ�����±�
			if (arr[l]==pivot){
				r-=1;
			}
			//��������꣬����arr[l]==pivot,˵��r�Ѿ���pivot���λ����r+1����Ϊ��һ�εݹ�����±�
			if (arr[r]==pivot){
				l+=1;
			}

		}

		if (l==r){
			l+=1;
			r-=1;
		}

		if (left<r){
			quickSort(arr,left,r);
		}

		if (l<right){
			quickSort(arr,l,right);
		}
	}
}
