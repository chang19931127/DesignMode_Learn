package me.modedesign.structure.decorate.clothe;

//��ϸ�˽�������򣡣�����������������������
//�������  �����ں�����������������������������
/*
 * ��˿�������װ��ģʽ��ʵ����һ�������������£�
 * �����ľ���   ������ϵ�ˣ���������װ������������װ���㣬��˾��й�ͬ�ṹ
 * 
 * �������������µĵط�����show()����
 * 
 * 
 * ����������ͨ��  Decorate����      ������
 * 
 * ��õ���  ͨ�����캯��    ע�� ����õģ���������
 */
public class Main {
	public static void main(String[] args) {
		Person person = new Person("richard");
		
		TShirts tx = new TShirts();
		BigTrouser kk = new BigTrouser();
		Sneakers pqx = new Sneakers();
		System.out.println("richard ��װ����");
		tx.Decorate(person);
		kk.Decorate(tx);
		pqx.Decorate(kk);
		pqx.show();
	}
}
