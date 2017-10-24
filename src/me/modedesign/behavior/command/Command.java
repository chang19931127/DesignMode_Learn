package me.modedesign.behavior.command;

/*
 * 命令模式 Command       又称行动模式或者交易模式
 * -----类与类之间的关系
 * 
 * 			命令模式把一个请求或者操作封装到一个对象中，命令模式允许系统使用不同的请求把客户端参数化，
 * 对请求排队或者记录请求日志，可以提供命令的撤销和恢复功能
 * 	
 * 			命令模式是对命令的封装。命令模式把发出命令的责任和执行命令的责任分隔开，委派给不同的对象。
 * 
 * 			每一个命令都是一个操作，请求的一方发出请求执行一个操作；
 * 														接受的一方收到请求并执行操作。		
 * 
 * 		命令模式很好理解，举个例子
 * 司令员下令让士兵去干件事情，整个事情角度来看，！司令员！的作用是发号！口令！，口令经过传递，！士兵！接收到口令，然后士兵去执行。
 * 		过程好在，三个动作相互解耦，任何一方都不依赖，只需要做自己做的事情
 * 
 * 使用了命令模式-----客户端就不用直接和执行者打交道了，只需要管理请求着，打交道的细节交给请求着了
 * 
 * 																													Command
 * 																													------------
 * 																														exe()
 * 																														|																															
 * 																														|
 * 			Test         								Invoker											MyCommand											Receiver
 * 													Command command；--------------->		Receiver receiver;		------------------------->		----------------	
 * 															action()											exe();														action();
 * 这里通过类图就很明显，可以看出    命令者 发送命令 给传输者，然后传输者执行命令
 * 
 * 													客户端直接 
 *         命令请求者     ------------------命令（对其进行关联）--------------------命令接受者
 * 
 * 命令模式的使用场景
 * 						1，使用命令模式作为“回呼”在面向对象系统中的替代。“回呼”讲的就是先将一个函数登记上，然后再以后调用此函数
 * 						2，需要在不同的时间指定请求，将请求排队。
 * 						3，系统需要支持命令的撤销。命令对象可以把状态存储起来
 * 						4，如果一个系统要将系统中所有的数据更新到日志里，以便在系统崩溃的时候，可以根据日志里读回所有的数据更新命令。
 * 						5，一个系统需要支持交易。一个交易结构封装了一组数据更新命令
 * 
 * 优缺点：
 * 						1，命令模式把请求一个操作的对象与直到怎么执行一个操作的对象分割开
 * 						2，命令类与其他任何别的类一样，可以修改和推广
 * 						3，你可以把命令对象聚合在一起，合称为合成命令
 * 						4，由于加新的具体命令类不影响其他的类，因此增加新的具体命令类很容易
 * 						1，使用命令模式会导致某些系统有过多的具体命令类，当命令类很多的时候
 * 
 * struts 貌似就是使用的命令模式
 * AWT的时间处理----------Listener接口就相当于命令接口
 */
public class Command {
	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		CommandDemo cmd = new MyCommand(receiver);
		Invoker invoker = new Invoker(cmd);
		invoker.action();
	}
}
//命令 接口
interface CommandDemo {
	void exe();
}
//具体命令类
class MyCommand implements CommandDemo {
	private Receiver receiver;
	public MyCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}
	@Override
	public void exe() {
		receiver.action();
	}
}
//接受者
class Receiver {
	public void action() {
		System.out.println("command received!");
	}
}
//请求者
class Invoker {
	//不管什么命令，只是发送一个命令
	private CommandDemo command;
	public Invoker(CommandDemo command) {
		super();
		this.command = command;
	}
	public void action() {
		command.exe();
	}
}
