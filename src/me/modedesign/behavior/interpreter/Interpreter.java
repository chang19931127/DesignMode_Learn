package me.modedesign.behavior.interpreter;

/*
 * ������ģʽ(Interpreter)
 * 			������ģʽһ��Ӧ����oop�����еı������Ŀ����У�����������Ƚ�խ
 * 			����˼�壬���ͣ�������ģʽֻ���������������������ģ�����ָ������������ʱ�����µĽ�����
 * 			����һ������֮�󣬽�����ģʽ���Զ�������ķ���һ�ֱ�ʾ����ͬʱ�ṩһ�����������ͻ��˿���ʹ������������������������
 * 			
 * 
 * 
 * 			Test------------------------------------------>O------------------------------------------------->Context
 * 																																		private int num1
 * 																																		private int num2
 * 																	Expression													public Context()
 * 																	-----------														int getNum1()
 * 																	int interpret												int getNum2()
 * 																/					\
 * 															/							\
 * 														/									\
 * 													Plus									Minus
 * 												int interpret              		int interpret()
 * Context����һ�������Ļ����࣬Plus��Minus�ֱ������������ʵ��
 * 
 * ������ģʽ���������ָ����Ľ���������������ʽ�Ľ������ȵ�
 */
public class Interpreter {
	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
		System.out.println("new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8))");
		System.out.println("�����9+2-8="+result);
	}
}
//������ʽ
interface Expression{
	int interpret(Context context);
}
class Plus implements Expression{

	@Override
	public int interpret(Context context) {
		return context.getNum1() + context.getNum2();
	}
}
class Minus implements Expression{

	@Override
	public int interpret(Context context) {
		return context.getNum1()-context.getNum2();
	}
}
//�������ṩ������֮���ȫ����Ϣ
class Context{
	private int num1;
	private int num2;
	public Context(int num1, int num2) {
		super();
		this.num1 = num1;
		this.num2 = num2;
	}
	public int getNum1() {
		return num1;
	}
	public void setNum1(int num1) {
		this.num1 = num1;
	}
	public int getNum2() {
		return num2;
	}
	public void setNum2(int num2) {
		this.num2 = num2;
	}
	
}