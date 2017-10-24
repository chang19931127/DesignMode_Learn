package me.modedesign.create.singleton;

/*
 * 单例模式
 * 确保类在内存中只有一个对象，该类必须自动创建，并且对外提供
 * 优点：系统只存在一个对象，节约系统资源，可以提高性能
 * 缺点：没有抽象层，扩展很难，责任过重
 */
public class Singleton {
	public static void main(String[] args) {
		Student s1 = Student.getStudent();
		Student s2 = Student.getStudent();
		System.out.println(s1==s2);//true 就是单例
	}
}

//保证单例
class Student{
	//私有构造方法
	private Student(){
	}
	//自己创造一个
	private static Student s = new Student();
	//对外提供接口
	public static Student getStudent(){
		/*if(s==null){
		 * return new Student();懒汉模式
		 * }
		 * 当使用的时候才会加载
		 * */
		return s;
	}
}

/*
 * 使用静态代码快来帮忙实例单例
 */
class Person{
	
	static{
		s = new Person();
	}
	
	private static Person  s;
	
	private Person(){}
	
	public static Person getPerson(){
		return s;
	}
}