package me.modedesign.structure.decorate.clothe;

public class Sneakers extends Clothe {

	@Override
	public void show() {
		add();
		System.out.print("��Ь\t");
		person.show();
	}
	//װ��ģʽ�����ǿ��Ծ���ȥ                װ��
	public void add(){
		System.out.print("��");
	}

}
