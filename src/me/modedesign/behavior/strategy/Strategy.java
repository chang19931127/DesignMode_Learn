package me.modedesign.behavior.strategy;

import javax.xml.stream.events.StartElement;

/*
 * 行为模式
 * 		父类与子类的关系
 * 				策略模式（strategy）
 * 策略模式定义了一系列算法，并将每个算法封装起来，使他们可以相互转换，且算法的变化不会影响到使用算法的用户。
 * 需要设计一个接口，为一系列实现类提供统一的方法，多个实现类实现该接口，设计一个抽象类(可有可无，属于辅助类),提供辅助函数
 * 
 * 													客户端---------------->公共的策略接口-----(辅助的策略类)
 * 																			|					|					|
 * 																			|					|					|
 * 																			|					|					|
 * 																	实现策略一  实现策略二  实现策略三
 * 
 * 
 * 策略模式的决定权在用户，系统本身提供不同的策略实现，增删等，并对策略进行封装，因此策略模式多用在算法决策系统中，外部用户只需要决定那个算法就好
 * 策略模式仅适用于客户端在几种算法中选择一种的情形。
 * 
 * 例子： 购物车中的折扣计算---可以使用策略模式
 * 				java中AWT中的LayoutManager
 * 											BorderLayout
 * 											FlowLayout
 * 											GridBagLayout	
 * 											CardLayout。。。。
 * 
 * 优点：
 * 			1，策略模式提供了管理系那个管的算法族的问题
 * 			2，策略模式提供了可以替换继承关系的办法（环境拥有策略下面有）
 * 			3，适用策略模式可以避免使用多重条件转移语句
 * 缺点：
 * 			1，客户端必须知道所有的策略类，并自行决定使用哪一个策略类
 * 			2，策略模式造成很多的策略类
 */
public class Strategy {
	public static void main(String[] args) {
		String exp="2+8";
		ICalulator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println("\t"+result);
		// 转义斜杠"\"
	}
}
//统一的接口
interface ICalulator{
	public int calculate(String exp);
}
//辅助类，为了某些算法作出一些轮廓
abstract class AbstractCalculate{
	public int[] spilt(String exp,String opt){
		String[] array= exp.split(opt);
		int[] arrayInt = new int [2];
		arrayInt[0]=Integer.parseInt(array[0]);
		arrayInt[1]=Integer.parseInt(array[1]);
		return arrayInt;
	}
}
//下面三个都是实现类---看用户怎么调用了
class Plus extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt =spilt(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}
}
class Minus extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt =spilt(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}
}
class Multiply extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt = spilt(exp, "\\*");
		return arrayInt[0] * arrayInt[1];
	}
}


//——————————————————————————————————————————————————————、

//一个拥有环境的策略模式
//环境
class Context{
	private Strategy1 strategy;
	//策略方法
	public void contextInterface(){
		strategy.strategyInterface();
	}
}
//策略统一抽象接口
abstract class Strategy1{
	//策略方法
	public abstract void strategyInterface();
}
//具体实现策略
class ConcreteStrategy1 extends Strategy1{
	@Override
	public void strategyInterface() {
	//具体的策略	
	}
}
