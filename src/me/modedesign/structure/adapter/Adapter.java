package me.modedesign.structure.adapter;

/*
 * 适配器模式，
 * 将某个类的接口转换成客户端期望的另外一个接口。
 * 目的：是消除由于接口不匹配所造成的类的兼容问题。
 * 主要分为三类：
 * 				-----类的适配器模式 
 * 											当希望将一个类转换成满足另一个新接口的类时可以使用类的适配器模式，创建一个新类，继承原有的类，实现新的接口
 * 				-----对象的适配器模式
 * 											当希望将一个对象转换成满足另一个新接口的对象时，可以创建一个Wrapper类持有原类的一个实例，在Wrapper类的方法中调用该实例的方法
 * 				-----接口的适配器模式
 * 											当不希望实现一个接口中的所有方法的时候，我们可以创建一个抽象的Wrapper类，空实现所有方法，当我们写别的类的时候，继承抽象类就可以了
 * 适配器模式的用意是将接口不同而功能相同或者相近的两个接口加以转换
 * 
 * 什么情况下使用适配器模式
 * 		1，系统需要使用现有的类，而此类的接口不符合系统的需要
 * 		2，想要建立一个可以重复使用的类，用于于一些彼此之间没有太大关联的一些类，包括一些可能在将来引进的类仪器工作，这些源类不一定有很复杂的接口。
 * 		3，（对对象的适配器模式而言）在设计里，需要改变多个已有的子类接口，如果使用类的适配器模式，就要针对每一个子类作一个适配器类，而这个不太实际
 * 
 * Iterator 迭代器使用了 适配器模式-------适配到Enumeration     	使用的是对象的适配器模式
 * 
 * 
 * 
 * 还有一个模式缺省适配模式---------就是我们所说的        				
 * 	WindowAdapter			 事件监听中使用的也是比较多的				使用的是接口的适配器模式
 * xml解析器中    XMLProperties将xml接口适配成java.util.Properties类型    SAX
 * 
 */
public class Adapter {
	public static void main(String[] args) {
		//类的适配器模式测试
		Targetable target = new Adapter1();
		target.method1();
		target.method2();
		//对象的适配器模式测试
		Source source = new Source();
		Targetable target2 = new Wrapper(source);
		target2.method1();
		target2.method2();
		//接口的适配器模式测试
		Targetable target3A = new SourceSub1();
		Targetable target3B= new SourceSub2();
		target3A.method1();
		target3A.method2();
		target3B.method1();
		target3B.method2();
	}
}
//待适配类，拥有一个方法
class Source{
	public void method1(){
		System.out.println("this is original method");
	}
}
//适配目标接口
interface Targetable{
	//与元类方法相同
	public void method1();
	//新类的方法
	public void method2();
}
//适配器类，继承待适配类，实现适配接口-----------------类的适配器模式
//这样Targetable接口的实现类就具有了Source类的功能
class Adapter1 extends Source implements Targetable{
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetable method");
	}
}
class Wrapper implements Targetable{
	private Source source;
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetable method");
	}
}
//这里我们通过一个抽象类，将原接口的方法 先空实现
abstract class Wrapper2 implements Targetable{
	@Override
	public void method1() {System.out.println("method1()空实现");}
	@Override
	public void method2() {System.out.println("method2()空实现");}	
}
class SourceSub1 extends Wrapper2{
	@Override
	public void method1() {
		System.out.println("thr sourceable interface's first sub1");
	}	
}
class SourceSub2 extends Wrapper2{
	@Override
	public void method2() {
		System.out.println("thr sourceable interface's second sub2");
	}	
}