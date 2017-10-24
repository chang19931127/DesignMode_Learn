package me.modedesign.structure.facade;

/*
 * Facade模式，外观模式，门面模式，都可以
 * 外观模式就是为了解决类与类之间的依赖关系，像spring一样，可以将类和类之间的关系配置到配置文件中，而外观模式就是将他们的关系放在一个Facade类中
 * 降低了类类之间的耦合度，该模式没有涉及到接口，结构如下(以计算机的启动过程为例子阐述，门面模式)
 * 
 * 门面模式是对象的结构模式，外部与一个子系统的通信必须通过一个统一的！！！门面！！！对象进行-------------------这就是门面模式
 * 就是将复杂的系统分而治之，这样的好处就是修改一个子系统并不会影响其它的系统，就是我们打交道的对象不是子系统了而是门面这个类
 * 
 * 门面角色：客户端可以调用这个角色的方法，此角色知晓(相关的一个或者多个)子系统的功能和责任。
 * 				在正常情况下，本角色将会被客户端发来的请求委派到相应的子系统中
 * 子系统角色：可以同时有一个或者多个子系统，每一个子系统都不是一个单独的类，而是一个类的集合。
 * 				每个子系统都可以被客户直接调用，或者门面角色调用，子系统并不知道门面的存在，对于子系统来说门面仅仅就是一个客户端
 * 
 * 
 * 总结，如果没有Computer类，那么，cpu，memory，disk，他们之间将会互相持有实例，产生关系，有了Computer这个类，他们之间的关系被放在了Computer中
 * 就起到了解耦作用！
 * 
 * 优点：
 * 			为复杂子系统提供一个简单接口：Facade模式提供一个简单的默认视图
 * 			子系统的独立性：子系统之间没有依赖性
 * 			层次化结构：Facaed模式定义了系统中每一层的入口
 */
public class Facade {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startUp();
		System.out.println("---------------------------------------------------");
		computer.shutDown();
	}
}
//总管 computer
class Computer{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public Computer(){
		//进行构造
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
	public void startUp(){
		System.out.println("start up computer");
		cpu.startUp();
		memory.startUp();
		disk.startUp();
		System.out.println("start computer finished");
	}
	public void shutDown(){
		System.out.println("begin to close the computer");
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
		System.out.println("computer closed");
	}
}
//零件cpu
class CPU{
	public void startUp(){
		System.out.println("cpu start");
	}
	public void shutDown(){
		System.out.println("cpu shutdown");
	}
}
//零件memory
class Memory{
	public void startUp(){
		System.out.println("memory start");
	}
	public void shutDown(){
		System.out.println("memory shutdown");
	}
}
//零件disk
class Disk{
	public void startUp(){
		System.out.println("disk startup");
	}
	public void shutDown(){
		System.out.println("disk shutdown");
	}
}