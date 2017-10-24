package me.modedesign.structure.composite.company;

/*
 * ����ӿ� 
 */
public abstract class Company {
	protected String name ;

	public Company(String name) {
		super();
		this.name = name;
	}
	
	public abstract void add(Company c);//����
	public abstract void remove(Company c);//�Ƴ�
	public abstract void display(int depth);//��ʾ
	public abstract void lineOfDuty();//��������
}
