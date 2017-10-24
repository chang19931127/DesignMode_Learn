package me.modedesign.create.prototype.resume;

//������
/*
 * ����һ��Ҫʵ��Cloneable����ӿڣ�����ӿھ������� ��ǽӿڡ�û�еĻ��ͻᱨ����֧��CloneNotSupportedException
 * 
 * ����������һ����ƺ�ǳ���Ƶĸ������leixing����ǳ���ƣ��������һ������¶���ʹ�����л�������copy
 * 
 */
public class Resume implements Cloneable {

	private String name;
	private String sex;
	private String age;
	private String timeArea;
	private String company;

	public Resume() {
		super();
	}

	public Resume(String name) {
		super();
		this.name = name;
	}


	// ���ø�����Ϣ
	public void setPersonalInfo(String sex, String age){
		this.sex = sex;
		this.age=age;
	}
	
	//���ù�������
	public void setWorkExperence(String timeArea, String company){
		this.timeArea = timeArea;
		this.company = company;
	}
	
	//��ʾ
	public void display(){
		System.out.println("������"+name+"�Ա�" + sex+"���䣺" + age);
		System.out.println("����������"+"ʱ�䣺"+timeArea+"��˾��"+company);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
