package com.atchaoqun.hashtab;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		MyHashTable myHashTable = new MyHashTable(10);
		//写一个简单的菜单来测试
		String key="";
		Scanner scanner = new Scanner(System.in);

		while (true){
			System.out.println("add：添加雇员");
			System.out.println("list: 显示雇员");
			System.out.println("exit: 推出菜单");
			key=scanner.next();
			switch (key){
				case "add":
					System.out.println("输入id:");
					int id=scanner.nextInt();
					System.out.println("输入名字");
					String name=scanner.next();
					myHashTable.add(new Emp(id,name));
					break;
				case "list":
					myHashTable.list();
				case "exit":
					scanner.close();
					System.exit(0);
				default:
					break;
			}
		}



	}

}

/**
 * 创建Hashtab 管理多条链表
 */
class MyHashTable{
	private EmpLinkedList[] empLinkedLists;
	private int size;
	//构造器
	public MyHashTable (int size){
		this.size=size;
		empLinkedLists=new EmpLinkedList[size];
		//?这里有坑,此时初始化时只创建了EmpLinkedList[],但是数组里面的对象是空的并没有初始化
		for (int i=0;i<size;i++){
			empLinkedLists[i]=new EmpLinkedList();
		}
	}

	//添加雇员
	public void add(Emp emp){
		int empLinkedListNo=hashFun(emp.getId());
		empLinkedLists[empLinkedListNo].add(emp);

	}

	/**
	 * 遍历所有的链表
	 */
	public void list(){

		for (int i =0;i<size;i++){
			empLinkedLists[i].list();
		}
	}

	/**
	 * 	编写一个散列函数，使用一个简单的取模法
	 */
	public int hashFun(int id){
		return id% size;
	}
}

class Emp{
	public  int id;
	public  String name;
	public Emp next;

	public Emp(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Emp getNext() {
		return next;
	}

	public void setNext(Emp next) {
		this.next = next;
	}

	@Override
	public String toString() {
		return "Emp{" +
				"id=" + id +
				", name='" + name + '\'' +
				'}';
	}
}


//创建EmpLinkedList
class  EmpLinkedList{
	//头指针，指向第一个Emp,因此我们这个链表的head是直接指向第一个Emp
	private Emp head;

	/**
	 * 假定添加雇员时，id是自增长的，即id得分配总是从小打到
	 * 因此我们将该雇员直接加到本链表的最后即可
	 * @param emp
	 */
	public void  add(Emp emp){
		if (head == null){
			head =emp;
			return;
		}
		//如果不是第一个雇员，则使用一个辅助指针，帮助定位到最后
		Emp curEmp=head;
		while (true){
			if (curEmp.next==null){
				break;
			}
			curEmp=curEmp.next;
		}
		//退出循环时表示到达链表最后，便添加进去
		curEmp.next=emp;
	}

	public void list(){
		if (head==null){
			System.out.println("当前链表为空");
			return;
		}
		Emp curEmp=head;
		while (true){
			System.out.println("当前链表对象："+curEmp.toString());

			if (curEmp.next==null){
				break;
			}
			curEmp=curEmp.next;

		}
	}
}
