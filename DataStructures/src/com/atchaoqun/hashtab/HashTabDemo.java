package com.atchaoqun.hashtab;

import java.util.Scanner;

public class HashTabDemo {

	public static void main(String[] args) {
		MyHashTable myHashTable = new MyHashTable(10);
		//дһ���򵥵Ĳ˵�������
		String key="";
		Scanner scanner = new Scanner(System.in);

		while (true){
			System.out.println("add����ӹ�Ա");
			System.out.println("list: ��ʾ��Ա");
			System.out.println("exit: �Ƴ��˵�");
			key=scanner.next();
			switch (key){
				case "add":
					System.out.println("����id:");
					int id=scanner.nextInt();
					System.out.println("��������");
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
 * ����Hashtab �����������
 */
class MyHashTable{
	private EmpLinkedList[] empLinkedLists;
	private int size;
	//������
	public MyHashTable (int size){
		this.size=size;
		empLinkedLists=new EmpLinkedList[size];
		//?�����п�,��ʱ��ʼ��ʱֻ������EmpLinkedList[],������������Ķ����ǿյĲ�û�г�ʼ��
		for (int i=0;i<size;i++){
			empLinkedLists[i]=new EmpLinkedList();
		}
	}

	//��ӹ�Ա
	public void add(Emp emp){
		int empLinkedListNo=hashFun(emp.getId());
		empLinkedLists[empLinkedListNo].add(emp);

	}

	/**
	 * �������е�����
	 */
	public void list(){

		for (int i =0;i<size;i++){
			empLinkedLists[i].list();
		}
	}

	/**
	 * 	��дһ��ɢ�к�����ʹ��һ���򵥵�ȡģ��
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


//����EmpLinkedList
class  EmpLinkedList{
	//ͷָ�룬ָ���һ��Emp,���������������head��ֱ��ָ���һ��Emp
	private Emp head;

	/**
	 * �ٶ���ӹ�Աʱ��id���������ģ���id�÷������Ǵ�С��
	 * ������ǽ��ù�Աֱ�Ӽӵ����������󼴿�
	 * @param emp
	 */
	public void  add(Emp emp){
		if (head == null){
			head =emp;
			return;
		}
		//������ǵ�һ����Ա����ʹ��һ������ָ�룬������λ�����
		Emp curEmp=head;
		while (true){
			if (curEmp.next==null){
				break;
			}
			curEmp=curEmp.next;
		}
		//�˳�ѭ��ʱ��ʾ����������󣬱���ӽ�ȥ
		curEmp.next=emp;
	}

	public void list(){
		if (head==null){
			System.out.println("��ǰ����Ϊ��");
			return;
		}
		Emp curEmp=head;
		while (true){
			System.out.println("��ǰ�������"+curEmp.toString());

			if (curEmp.next==null){
				break;
			}
			curEmp=curEmp.next;

		}
	}
}
