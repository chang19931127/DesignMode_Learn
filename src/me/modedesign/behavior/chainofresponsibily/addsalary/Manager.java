package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897
 *	这里就是抽象管理者
 */
public abstract class Manager {
	protected String name;//姓名
	protected Manager superior;//上级
	
	public Manager(String name){
		this.name = name;//通过子类事例话，来进行复制
	}
	
	//设置上级
	public void setSuperiot(Manager superior){
		this.superior = superior;
	}
	
	public abstract void requestApplication(Request request);
}
