package me.modedesign.structure.bridge;

/*
 * 桥接模式-         柄体模式(Handle and Body)-接口模式----Bridge
 * 三个概念：
 * 				抽象化：存在于多个实体中的共同的概念性联系，就是抽象化
 * 				实现化：抽象化给出的具体实现，就是实现化
 * 				解耦：两个实体的行为的某种强关联，而将他们的强关联去掉，就是解耦
 * 							继承是强关联关系，聚合时弱关联关系，推荐使用聚合！！！，
 * 
 * 桥接模式就是把事物和具体实现分开，使他们可以各自独立的变化。
 * 桥接的用意是：将抽象化与实现化解耦，使得二者可以独立变化，像我们常用的JDBC桥DriverManager一样，
 * JDBC进行数据库连接的时候，在各个数据库之间进行切换，基本不需要太多的代码，甚至丝毫不用动，
 * 原因就是JDBC提供了统一的接口，每个数据库提供各自的实现，用一个叫做数据库驱动的程序来桥接就行了！
 * 
 * 桥梁模式的使用场景：
 * 			如果一个系统需要在构建的抽象化角色和具体化角色之间增加灵活性
 * 			设计要求实现化角色的任何改变不影响客户端
 * 			一个构建有多个抽象化角色和实现化角色
 * 			
 * 
 * 
 * 例子：
 * 			通过对Bridage1 这个类的调用，实现了对接口Sourceable的实现类SourceSub1和SourceSub2的调用
 * 
 * 完美的例子：JDBC（看下设计规则）
 * 			Client------>DriverManager(接口，多个具体)-----聚合---->Driver(接口)
 * 													
 * 												MysqlDriver          OracleDriver        DB2Driver
 */
public class Bridge {
	public static void main(String[] args) {
		Bridge1 bridge = new MyBridge();
		//调用第一个对象
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		//调用第二个对象
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}
//抽象的接口-----------------实现化角色和具体实现化角色
interface Sourceable{
	void method();
}
//接口实现类1
class SourceSub1 implements Sourceable{
	@Override
	public void method() {
		System.out.println("this is the first sub!");
	}	
}
//接口实现类2
class SourceSub2 implements Sourceable{
	@Override
	public void method() {
		System.out.println("this is the second sub!");
	}	
}
//抽象--桥----持有Sourceable接口的实例(set,get)-------抽象化角色和修正抽象化角色
//抽象化角色就像是一个水杯的手柄，而实现化角色就像是水杯的杯身------------于是乎”柄体“就来了
abstract class Bridge1{
	private Sourceable source;//---这就属于聚合
	
	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}

	public void method(){
		source.method();
	}
}
//具体的桥            这个类可以有很多
class MyBridge extends Bridge1{
	public void method(){
		getSource().method();
	}
}