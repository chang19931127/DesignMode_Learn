package me.modedesign.behavior.interpreter;

/*
 * 解释器模式(Interpreter)
 * 			解释器模式一般应用在oop开发中的编译器的开发中，所以适用面比较窄
 * 			顾名思义，解释，解释器模式只描述解释器是怎样工作的，并不指名怎样在运行时创建新的解释器
 * 			给定一个语言之后，解释器模式可以定义出其文法的一种表示，并同时提供一个解释器，客户端可以使用这个解释器来解释这个句子
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
 * Context类是一个上下文环境类，Plus和Minus分别是用来计算的实现
 * 
 * 解释器模式用来做各种各样的解释器，如正则表达式的解析器等等
 */
public class Interpreter {
	public static void main(String[] args) {
		int result = new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8));
		System.out.println("new Minus().interpret(new Context(new Plus().interpret(new Context(9, 2)), 8))");
		System.out.println("计算的9+2-8="+result);
	}
}
//抽象表达式
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
//环境，提供解释器之外的全局信息
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