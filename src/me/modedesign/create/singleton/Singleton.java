package me.modedesign.create.singleton;

/*
 * ����ģʽ
 * ȷ�������ڴ���ֻ��һ�����󣬸�������Զ����������Ҷ����ṩ
 * �ŵ㣺ϵͳֻ����һ�����󣬽�Լϵͳ��Դ�������������
 * ȱ�㣺û�г���㣬��չ���ѣ����ι���
 */
public class Singleton {
	public static void main(String[] args) {
		Student s1 = Student.getStudent();
		Student s2 = Student.getStudent();
		System.out.println(s1==s2);//true ���ǵ���
	}
}

//��֤����
class Student{
	//˽�й��췽��
	private Student(){
	}
	//�Լ�����һ��
	private static Student s = new Student();
	//�����ṩ�ӿ�
	public static Student getStudent(){
		/*if(s==null){
		 * return new Student();����ģʽ
		 * }
		 * ��ʹ�õ�ʱ��Ż����
		 * */
		return s;
	}
}

/*
 * ʹ�þ�̬���������æʵ������
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