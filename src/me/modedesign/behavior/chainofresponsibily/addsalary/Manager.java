package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897
 *	������ǳ��������
 */
public abstract class Manager {
	protected String name;//����
	protected Manager superior;//�ϼ�
	
	public Manager(String name){
		this.name = name;//ͨ�������������������и���
	}
	
	//�����ϼ�
	public void setSuperiot(Manager superior){
		this.superior = superior;
	}
	
	public abstract void requestApplication(Request request);
}
