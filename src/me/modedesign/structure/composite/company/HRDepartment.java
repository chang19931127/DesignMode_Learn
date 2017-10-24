package me.modedesign.structure.composite.company;

/*
 * ������Դ��
 * �������ǿ�ʵ��
 */
public class HRDepartment extends Company {

	public HRDepartment(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		
	}

	@Override
	public void remove(Company c) {
		
	}

	@Override
	public void display(int depth) {
		System.out.println("-"+depth+name);
	}

	@Override
	public void lineOfDuty() {
		System.out.println(name + "Ա����ѵ����");
	}

}
