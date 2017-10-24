package me.modedesign.structure.composite.company;

/*
 * 抽象接口 
 */
public abstract class Company {
	protected String name ;

	public Company(String name) {
		super();
		this.name = name;
	}
	
	public abstract void add(Company c);//增加
	public abstract void remove(Company c);//移出
	public abstract void display(int depth);//显示
	public abstract void lineOfDuty();//履行责任
}
