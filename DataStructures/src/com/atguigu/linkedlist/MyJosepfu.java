package com.atguigu.linkedlist;

import java.util.Stack;

/**
 * date: 2021/5/7 14:19
 *
 * @author zcq
 */
public class MyJosepfu {
    public static void main(String[] args) {
        Josepfulist  boys=new Josepfulist();
        boys.add(123);
        boys.show();
        boys.countBoy(1,2,123);
        
    }
}

/***
 * ����һ������Ļ�������
 */
class Josepfulist {
    private Boy2 first = null;

    public void add(int nums) {
        if (nums <= 0) {
            System.out.println("nums��ֵ����ȷ");
            return;
        }
        Boy2 curBoy2 = null;
        for (int i = 1; i <= nums; i++) {
            Boy2 boy2 = new Boy2(i);
            if (i == 1) {
                first = boy2;
                first.setNext(first);
                curBoy2 = first;
            } else {
                //��ͼ����
                //1.��������boy��ֵ����ǰ�ĸ���ָ�룬����ָ�������������boy
                curBoy2.setNext(boy2);
                //2.�������ٸ�ֵ����һ��boy���������γɻ�״
                boy2.setNext(first);
                //3.��ǰ����ָ���ƶ�����β��������һ��ѭ���ֿ���ʹ�á����ָ����һ�������boy����
                curBoy2 = boy2;
            }

        }
    }

    public void show(){
        if (null==first.getNext()){
            System.out.println("��ǰ����Ϊ��");
        }
        Boy2 curBoy2 = first;
        while (true){

            System.out.println("С�����Ϊ��"+curBoy2.getNo());
            if (curBoy2.getNext()==first){
                //�Ѿ��������
                break;
            }
            curBoy2=curBoy2.getNext();
        }
    }

    public  void countBoy(int startNo,int countNum,int nums){
        // �ȶ����ݽ���У��
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("������������ ����������");
            return;
        }
        Boy2 help=first;
        //�ƶ�help�����һλ
        while (true){
            if (help.getNext()==first){
                break;
            }
            help=help.getNext();
        }
        //����ǰ����first��helper�ƶ�k-1��
        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            help=help.getNext();
        }
        while (true){
            if (help==first){
                //˵��Ȧ��ֻ��һ���ڵ�
                break;
            }


        //ѭ��������firstָ�����Ҫ��Ȧ��С����
        //helpָ����Ǻ�һ��
        for (int j=0;j<countNum-1;j++){
            first=first.getNext();
            help=help.getNext();
        }
        //��helpֱ��ָ��first����һ��
        //������first���Ȧ
        System.out.println("С����Ȧ�ı��Ϊ��"+first.getNo());
        first=first.getNext();
        help.setNext(first);
    }
        System.out.printf("�������Ȧ�е�С�����%d \n", first.getNo());
    }
}

// ����һ��Boy�࣬��ʾһ���ڵ�
class Boy2 {
    private int no;// ���
    private Boy2 next; // ָ����һ���ڵ�,Ĭ��null

    public Boy2(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy2 getNext() {
        return next;
    }

    public void setNext(Boy2 next) {
        this.next = next;
    }

}
