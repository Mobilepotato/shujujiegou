package com.atguigu.linkedlist;

import sun.misc.PostVMInitHook;

/**
 * date: 2021/5/6 15:24
 *
 * @author zcq
 */
public class MyWork {
    public static void main(String[] args) {

        HeroNode hero1 = new HeroNode(1, "�ν�", "��ʱ��");
        HeroNode hero2 = new HeroNode(3, "¬����", "������");
        HeroNode hero3 = new HeroNode(5, "����", "�Ƕ���");
        HeroNode hero4 = new HeroNode(7, "�ֳ�", "����ͷ");

        SingleLinkedList singleLinkedList=new SingleLinkedList();
        singleLinkedList.add(hero1);
        singleLinkedList.add(hero2);
        singleLinkedList.add(hero3);
        singleLinkedList.add(hero4);
        System.out.println("ԭ��������Ϊ��");
        singleLinkedList.list();
//        System.out.println("������µ����������Ϊ��");
//        singleLinkedList= descLinkede(singleLinkedList);
//        // ����һ�µ�����ķ�ת����
//        singleLinkedList.list();




        HeroNode hero5 = new HeroNode(2, "�ν�", "��ʱ��");
        HeroNode hero6 = new HeroNode(4, "¬����", "������");
        HeroNode hero7 = new HeroNode(6, "����", "�Ƕ���");
        HeroNode hero8 = new HeroNode(8, "�ֳ�", "����ͷ");

        SingleLinkedList singleLinkedList1=new SingleLinkedList();
        singleLinkedList.add(hero5);
        singleLinkedList.add(hero6);
        singleLinkedList.add(hero7);
        singleLinkedList.add(hero8);
    }


    /**
     * �����������
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
            //14���������tempָ�������ƶ�
            //23������Ҫ��ɽ�temp�е�������ӵ��µ�������
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
     * ����������ϲ���������
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

