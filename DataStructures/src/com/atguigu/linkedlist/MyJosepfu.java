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
 * 构建一个单向的环形链表
 */
class Josepfulist {
    private Boy2 first = null;

    public void add(int nums) {
        if (nums <= 0) {
            System.out.println("nums的值不正确");
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
                //画图分析
                //1.将新来的boy赋值给当前的辅助指针，辅助指针便引像新来的boy
                curBoy2.setNext(boy2);
                //2.新来的再赋值给第一个boy，这样就形成环状
                boy2.setNext(first);
                //3.当前辅助指针移动到队尾，这样下一次循环又可以使用。这个指针是一个虚拟的boy对象
                curBoy2 = boy2;
            }

        }
    }

    public void show(){
        if (null==first.getNext()){
            System.out.println("当前链表为空");
        }
        Boy2 curBoy2 = first;
        while (true){

            System.out.println("小孩编号为："+curBoy2.getNo());
            if (curBoy2.getNext()==first){
                //已经遍历完毕
                break;
            }
            curBoy2=curBoy2.getNext();
        }
    }

    public  void countBoy(int startNo,int countNum,int nums){
        // 先对数据进行校验
        if (first == null || startNo < 1 || startNo > nums) {
            System.out.println("参数输入有误， 请重新输入");
            return;
        }
        Boy2 help=first;
        //移动help到最后一位
        while (true){
            if (help.getNext()==first){
                break;
            }
            help=help.getNext();
        }
        //报数前先让first合helper移动k-1次
        for (int j=0;j<startNo-1;j++){
            first=first.getNext();
            help=help.getNext();
        }
        while (true){
            if (help==first){
                //说明圈里只有一个节点
                break;
            }


        //循环结束后，first指向的是要出圈的小孩子
        //help指向的是后一个
        for (int j=0;j<countNum-1;j++){
            first=first.getNext();
            help=help.getNext();
        }
        //将help直接指向first的下一个
        //这样子first便出圈
        System.out.println("小孩出圈的编号为："+first.getNo());
        first=first.getNext();
        help.setNext(first);
    }
        System.out.printf("最后留在圈中的小孩编号%d \n", first.getNo());
    }
}

// 创建一个Boy类，表示一个节点
class Boy2 {
    private int no;// 编号
    private Boy2 next; // 指向下一个节点,默认null

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
