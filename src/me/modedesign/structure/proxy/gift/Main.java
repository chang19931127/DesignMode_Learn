package me.modedesign.structure.proxy.gift;

public class Main {
	public static void main(String[] args) {
		SchoolGirl mm = new SchoolGirl();
		mm.setName("����");
		
		//����  ���д���
		Proxy daili = new Proxy(mm);
		
		daili.giveDolls();
		daili.giveFlowers();
		daili.giveChocolate();
		
		//��һ�¾ͳ��׵�������           �����ͻ��Ķ�����
	}
}
