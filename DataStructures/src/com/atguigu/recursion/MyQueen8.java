package com.atguigu.recursion;

/**
 * date: 2021/5/13 17:32
 *
 * @author zcq
 */
public class MyQueen8 {
    int max=8;
    int[] array=new int[max];
    static int count=0;
    public static void main(String[] args) {
        MyQueen8 myQueen8 = new MyQueen8();
        myQueen8.check(0);
        System.out.println(count);
    }

    //дһ�����������Խ��ʺ�ڷ��Ǹ���λ�����
    private void print(){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        count++;
        System.out.println();
    }

    private void  check(int n){
        if (n==max){
            print();
            return;
        }
        //�Դ˷���ʺ󣬲��ж��Ƿ��ͻ
        for (int i=0;i<max;i++){
            //�Ȱѵ�ǰ����ʺ�n,�ŵ����еĵ�һ��
            array[n]=i;
            if (judge(n)){
                //���ŷ�ֹn+1���ʺ󣬼���ʼ�ݹ�
                check(n+1);
            }
            //�����ͻ�ˣ����������ִ��ѭ��
        }
    }

    /**
     *  �鿴�Ƿ��г�ͻ�Ļʺ�
     */
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            //ǰ���ж��Ƿ���ͬһ��
            //�����ж��Ƿ���ͬһб��
            //�����������ɾ��Σ��ж��Ƿ�Ϊ�����Σ��Ƿ񳤵��ڿ��������ͬһб����
            if (array[i] ==array[n] ||Math.abs(n-i)==Math.abs(array[n]-array[i]) ){
                return false;
            }
        }
        return true;
    }
}
