package com.atguigu.linkedlist;

import sun.misc.PostVMInitHook;

/**
 * date: 2021/5/6 15:24
 *
 * @author zcq
 */
public class MyWork {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode hero2 = new HeroNode(3, "卢俊义", "玉麒麟");
        HeroNode hero3 = new HeroNode(5, "吴用", "智多星");
        HeroNode hero4 = new HeroNode(7, "林冲", "豹子头");

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println("原来的链表为：");
        singleLinkedList.list();
//        System.out.println("倒序后新的链表的链表为：");
//        singleLinkedList= descLinkede(singleLinkedList);
//        // 测试一下单链表的反转功能
//        singleLinkedList.list();




        HeroNode hero5 = new HeroNode(2, "宋江", "及时雨");
        HeroNode hero6 = new HeroNode(4, "卢俊义", "玉麒麟");
        HeroNode hero7 = new HeroNode(6, "吴用", "智多星");
        HeroNode hero8 = new HeroNode(8, "林冲", "豹子头");

        SingleLinkedList singleLinkedList1=new SingleLinkedList();
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero6);
        singleLinkedList.add(hero7);
        singleLinkedList.add(hero8);
    }


    /**
     * 将链表倒序输出
     * @param singleLinkedList
     * @return
     */
    public static SingleLinkedList descLinkede(SingleLinkedList singleLinkedList){
        HeroNode temp=singleLinkedList.getHead();
        HeroNode next=null;
        HeroNode temp2=new HeroNode(0,"","");
        SingleLinkedList singleLinkedList1=new SingleLinkedList();
        boolean flag=true;
        while (flag){
            if (temp.next==null){
                break;
            }
            //14两步完成了temp指针的向后移动
            //23两步需要完成将temp中的数据添加到新的链表中
            next=temp.next;
            temp.next=temp2.next;
            temp2.next=temp;
            temp=next;
        }
        temp.next=temp2.next;
        singleLinkedList1.add(temp);
        return singleLinkedList1;
    }


    /**
     * 将两个链表合并并且排序
     */
    public static SingleLinkedList sortMerge(SingleLinkedList singleLinkedList,SingleLinkedList singleLinkedList1){
        HeroNode temp=singleLinkedList.getHead();
        HeroNode temp1=singleLinkedList.getHead();
        HeroNode next=null;
        HeroNode temp2=new HeroNode(0,"","");
        SingleLinkedList singleLinkedList2=new SingleLinkedList();
        boolean flag=true;
        while (temp.next!=null){
         while (temp1.next!=null){
             if (temp.no>temp1.no){

             }
         }


        }



        return null;
    }

}

