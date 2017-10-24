package me.modedesign.behavior.memento;

/*
 * Memento 备忘录模式 ---快照模式(Snapshot Pattern) 或Token模式
 * 类的状态----
 * 				(备忘录模式)	主要目的是保存一个对象的某种状态，以便在适当的时候恢复对象，个人觉得叫做备份模式更形象些，
 * 通俗的讲下：假设有原始类A，A中有各种属性，A可以决定需要备份的属性，备忘录B用来存储A的一些内部状态，类C尼？就是一个用来
 * 存储备忘录的，且只能存储，不能修改等操作。
 * 
 * ！！！！！！！！！！！！！！！！！！！
 * 备忘录模式的用意是在不破坏封装对象的条件下，将一个对象的状态扑抓到，并外部化，存储起来，
 * 从而以在将来合适的时候把这个对象还原到存储起来的状态。
 * 这样子或许很好理解-----------
 * 发起人角色(Originator)------------------------备忘录角色(Memento)----------------负责人角色(Storage)
 * 
 * 
 * 							Test--------------------------------------------------------------------------	|
 * 								|																								|
 * 								|																								|
 * 								|																								|
 * 							Original----------------------->Memento<-------------------------- Storage
 * 						String value						String value								Memento memento
 * 				Memento createMemento()
 * 这里分析一下-----Original类是原始类，里面有一个需要保存的属性value及创建一个备忘录类，
 * 用来保存value值。Memento类是备忘录类，Storage类是存储备忘录类，持有Memento类的实例。
 * 应该就很好理解了---A需要备份，创建了B来备份-----C持有这个B，方便调用，但是不能修改
 * 
 * 
 * 
 * 
 * 同样在迭代器模式中，我们了解到宽窄接口，这里我们要复习一遍
 * 		宽接口：提供修改内部元素的方法的接口，就叫做宽接口
 * 		窄接口：不提供修改内部元素的方法的接口，就叫做窄接口
 * java在实现备忘录模式的时候同时实现“宽”“窄”接口是不容易的。
 * 如果忽略宽窄接口---仅仅实现！宽接口！那个这个实现叫做“白箱实现”---------我们演示的程序就是白箱实现
 * 
 * 
 * 
 * 
 * 		备忘录模式，同时利用宽接口和窄接口实现。。存在两个接口
 * 那么我们先要知道的是，如何利用java同时实现“宽接口”，“窄接口”。
 * 			也就是搞双接口             Wide                                  Narrow               两个接口
 * 												operation1						标示接口
 * 												operation2
 * 			1，一个具体类的双重接口-------这个很简单，就是实现了双接口！！！！
 * 			2，对不同对象提供不同的接口 --------这个就需要一个类来承担责任----内部类很好解决
 * 	这样子使用java来实现备忘录模式就是“黑盒实现”----使用匿名类将类封装、
 * 								讲道理如何实现尼？
 * 							其实内部类就是   Memento这个类    给这个类提供一个标记接口---供负责人角色使用
 * 						这里起一个好听的名字-----------”自述历史“模式
 * 
 */
public class Memento {
	//可以查看main函数发现并没有自己创建Memento对象，也就是说      原始对象直接和备忘录接触
	//因为这里提供的接口修改了内部属性，因此这里被称作“白箱实现”
	//实际上“白箱实现”破坏了对象的封装，因为其属性可以被疯狂搞！
	//这种可以实现备忘录模式与多重检查点结合
	public static void main(String[] args) {
		//创建原始对象
		Original original = new Original("banana");
		//创建备忘录---------给Storage备忘录对象传入一个original创建的备忘
		Storage storage = new Storage(original.createMemento());
		System.out.println("初始化状态为------：" + original.getValue());
		//新修改原始状态
		original.setValue("apple");
		System.out.println("修改后的状态为-------：" + original.getValue());
		//回到原始状态
		original.restoreMemento(storage.getMemento());
		System.out.println("恢复后的状态为------" + original.getValue());

	}
}
//原始对象-------可以产生备忘，并且可以重置到备忘
class Original {
	//需要备忘的属性
	private String value;

	public Original(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	//工厂方法---返还一个新的备忘录对象
	public MementoDemo createMemento() {
		return new MementoDemo(value);
	}
	//将发起人恢复到备忘录对象所记载的状态
	public void restoreMemento(MementoDemo memento) {
		this.value = memento.getValue();
	}
}
//备忘对象---可以存储 需要备忘的数据
class MementoDemo {
	private String value;

	public MementoDemo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
//备忘录------持有一个备忘
class Storage {
	//持有备忘
	private MementoDemo memento;

	public Storage(MementoDemo memento) {
		this.memento = memento;
	}

	public MementoDemo getMemento() {
		return memento;
	}

	public void setMemento(MementoDemo memento) {
		this.memento = memento;
	}
}

/*
 * ****************************************************************************************************************************
 * 同时实现“宽接口”“窄接口”
 */
//两个接口
interface Wide{
	void operation1();
	void operation2();
}
interface Narrow{
	//这个接口在备忘录模式中代表的事Memento这个类的标示接口    这个类 被内部类 Memento所实现，并封装
}
/*
 * 第一种可能
 * 
 * 									User------------------> interface        	interface<-----------------Other
 * 																		Wide				Narrow
 * 																	operation1()     	标记接口
 * 																	operation2()
 * 																			^							^
 * 																			|							|
 * 																			|							|
 * 																					ConcertClass   实现都交给了一个类
 * 																					operation1()
 * 																					operation2()
 * 								可以看出ConcertClass类责任重大
 * 
 */																
 
class User{
	//第二种可能
	//一个内部类来搞,内部类ConcreteClass替代了Wide这个接口    换句话说就是可以省略Wide接口
	//这个可能是最好的解决方案！！！！！！！也就是说ConcerteClass这个类被成功封装
	class ConcreteClass implements Narrow {
		private void operation1(){
			System.out.println("operation1()");
		}
		private void operation2(){
			System.out.println("operation2()");
		}
	}
	//这个方法向外界提供内部类的实例
	public Narrow getConcreteClass(){
		return (Narrow) new ConcreteClass();
	}
}








