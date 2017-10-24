package me.modedesign.behavior.state;

/*
 * 状态模式 state    又称状态对象模式----行为模式
 * 		状态模式允许一个对象内部状态改变的时候改变其行为。这个对象看上去就像是改变了他的类一样
 * 
 * 核心思想：当对象的状态改变时，同时改变其行为，很好理解！就拿QQ来说，有几种状态，在线，隐身，忙碌等
 * 每个状态对应不同的操作，而且你的好友也可以看到你的状态，所以状态模式就两点：		
 * 				1，可以通过改变状态来获得不同的行为
 * 				2，你的好友能同时看到你的变化
 * 
 * 				Test--------------------------> Context-------------------------->State
 * 														State state;								String value
 * 														method()									method1()
 * 																										method2()
 * 
 * 
 * 
 * 																										ConcreteState
 * 上面的类图仅仅是一个简单的状态模式---我们直接通过修改掉用的方法来模拟状态的改变，在实际情况
 * 我们会创建出来一个抽象状态角色-----具体状态角色随意调用改变。。。
 * 意思就是Context拥有一个State(抽象接口)  然后一些ConcreteState(具体状态)被进行调用
 * 
 * 			
 * 总结：状态模式在日常开发中用的挺多的尤其是做网站的时候，我们有时希望根据对象的某一属性，
 * 区别开他们的一些功能，比如说简单的权限控制。	
 * 
 * 什么情况下使用状态模式
 * 			1，一个对象的行为以来与他所处的状态，对象的行为必须随着其状态的改变而改变。
 * 			2，对象在某个方法里依赖于一重或多重的条件转移语句，其中有大量的代码。状态模式把条件转移语句的的每一个分支都包装到一个单独
 * 的类里，这使得这些条件转移分支能够以类的方法独立存在和演化，维护类并不影响系统其他部分。
 * 
 * 
 * 一个状态模式的应用例子 ：   TCP
 * 	TcpConnection对象有很多状态，1，已建立连接。2，聆听。3，关闭。TcpState
 * TcpConnection扮演环境角色--------------------------持有TcpState扮演状态角色(抽象)(TcpClosed,TcpEstablished具体)
 * 见下
 * 
 * 
 * 
 * 
 * 是不是感觉策略模式和状态模式很相似111111111111111啊哈哈哈还是有区别的
 */
public class State {
	public static void main(String[] args) {
		StateDemo state = new StateDemo();
		Context context = new Context(state);
		state.setVlaue("state1");// 设置第一种状态
		context.method();
		state.setVlaue("state2");// 设置第二种状态
		context.method();
	}
}

// 状态类的核心类
class StateDemo {
	private String vlaue;

	public String getVlaue() {
		return vlaue;
	}

	public void setVlaue(String vlaue) {
		this.vlaue = vlaue;
	}

	public void method1() {
		System.out.println("execute the first opt !");
	}

	public void method2() {
		System.out.println("execute the second opt!");
	}
}

// 状态模式的切换类
class Context {
	private StateDemo state;

	public Context(StateDemo state) {
		super();
		this.state = state;
	}

	public StateDemo getState() {
		return state;
	}

	public void setState(StateDemo state) {
		this.state = state;
	}

	public void method() {
		if (state.getVlaue().equals("state1")) {
			state.method1();
		} else if (state.getVlaue().equals("state2")) {
			state.method2();
		}
	}
}
/*
//环境角色
class TcpConnection {
	private TcpState state;
	public void open(){
		state.open();
	}
	public void setState(TcpState state){
		this.state = state;
	}
	public void close(){
		state.close();
	}
	public void acknowledge(){
		state.acknowledge();
	}
}
//抽象状态角色
interface TcpState {
	void open();
	void close();
	void acknowledge();
}
//具体状态角色
class TcpEstablished implements TcpState {
	@Override
	public void open() {
		// write you code here
	}
	@Override
	public void close() {
		// write you code here
	}
	@Override
	public void acknowledge() {
		// write you code here
	}
}
*/