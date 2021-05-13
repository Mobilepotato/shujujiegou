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

    //写一个方法，可以讲皇后摆放那个的位置输出
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
        //以此放入皇后，并判断是否冲突
        for (int i=0;i<max;i++){
            //先把当前这个皇后n,放到改行的第一列
            array[n]=i;
            if (judge(n)){
                //接着防止n+1个皇后，即开始递归
                check(n+1);
            }
            //如果冲突了，便继续往下执行循环
        }
    }

    /**
     *  查看是否有冲突的皇后
     */
    private boolean judge(int n){
        for (int i=0;i<n;i++){
            //前面判断是否在同一列
            //后面判断是否在同一斜线
            //将两个点连成矩形，判断是否为正方形，是否长等于宽。相等则在同一斜线上
            if (array[i] ==array[n] ||Math.abs(n-i)==Math.abs(array[n]-array[i]) ){
                return false;
            }
        }
        return true;
    }
}
