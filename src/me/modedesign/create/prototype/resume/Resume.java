package me.modedesign.create.prototype.resume;

//简历类
/*
 * 这里一定要实现Cloneable这个接口，这个接口就类似于 标记接口。没有的话就会报错，不支持CloneNotSupportedException
 * 
 * 还有这里有一个深复制和浅复制的概念，引用leixing都是浅复制，因此我们一般情况下都是使用序列化来进行copy
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


	// 设置个人信息
	public void setPersonalInfo(String sex, String age){
		this.sex = sex;
		this.age=age;
	}
	
	//设置工作经历
	public void setWorkExperence(String timeArea, String company){
		this.timeArea = timeArea;
		this.company = company;
	}
	
	//显示
	public void display(){
		System.out.println("姓名："+name+"性别：" + sex+"年龄：" + age);
		System.out.println("工作经历："+"时间："+timeArea+"公司："+company);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	
}
