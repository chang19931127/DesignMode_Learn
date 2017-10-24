package me.modedesign.behavior.chainofresponsibily;

/*
 * 责任链模式(Chain of Responsibility)
 * 对象的行为模式
 * -----类与类之间的关系
 * 			有多个对象，每个对象持有对下一个对象的引用，这样就会形成一条链，请求在这条链上传递，直到某一个对象决定处理该请求。
 * 但是发出者并不清楚到底最终那个对象会处理该请求，所以，责任链模式可以实现，在隐瞒客户端的情况下，对系统进行动态的调整。
 * 
 * 					切忌！！！！！！！！！！在一个时刻，命令只允许由一个对象传给另一个对象，而不允许传给多个对象
 * 
 * 									AbstractHandler--------------------------------------->Handler
 * 										Handler handler													--------
 * 											getHandler()														operation()
 * 											setHandler()												
 * 																\														/
 * 																	\												/
 * 																		\										/
 * 																			\								/
 * 																						MyHandler
 * 										Test------------------------->			--------	
 * 																								operation()
 * AbstractHandler类提供了get和set 方法，方便MyHandler类设置和修改引用对象，MyHandler类是核心，实例话后生成一系列相互持有的对象
 * 构成一条链。
 * 
 * 纯的与不纯的责任链模式
 * 			一个纯的责任链模式要求一个具体的处理者对象只能在两个行为中选择一个
 * 												1，一是承担责任。
 * 												2，二是把责任推给大家。       不允许其他情况
 * 			在一个纯的责任链模式里面，一个请求必须被某一个处理者对象所接收
 * 			在一个不纯的责任链模式中，一个请求最终不被任何接受段所接受。
 * 			现实中很难找到 纯的责任链模式
 * 
 * 	 责任链模式减低了请求的发送端和接受端之间的耦合，使多个对象都有机会处理这个请求
 * 
 * 浏览器的DOM模型中的事件处理均采用责任链模式。
 * 	一层一层的进行，如果有事件就执行
 * 
 * 
 * 一个简单的实例-----------直到处理实例没有下家就执行操作
 */
public class ChainOfResponsibily {
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");
		h1.setHandler(h2);
		h2.setHandler(h3);
		//直到某一个对象决定处理该请求
		h1.operator();
		//链上的请求可以是一条链，可以是一个树，还可以是一个环--------
	}
}
//抽象接口-------定义了操作方法
interface Handler{
	void operator();
}
//抽象 类 --------定义了链 的模式情况
abstract class AbstractHandler{
	private Handler handler;
	public Handler getHandler(){
		return handler;
	}
	public void setHandler(Handler handler){
		this.handler=handler;
	}
}
//具体类     既要实现又要继承          ---------链的元素也是通过这个类 创建的
class MyHandler extends AbstractHandler implements Handler{
	private String name;
	public MyHandler(String name){
		this.name = name;
	}
	//实现了方法---------在这个方法里面进行了链式执行
	@Override
	public void operator() {
		if(getHandler() !=null){
			//请求移交
			System.out.println("the request is passed to" +getHandler());
			getHandler().operator();
		}else{
			System.out.println("the request is handler here");
		}
	}	
}



