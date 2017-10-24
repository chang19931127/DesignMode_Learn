package me.modedesign.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;


/*
 * 观察者模式-发布订阅模式-模型试图模式-源监听器模式
 * 
 * -----类与类之间的关系。
 * 
 * 观察者模式很好理解，简单的来说就是一句话：当一个对象变化时，其他依赖该对象的对象都会
 * 收到通知，并且随着变化！ 
 * 对象之间是一对多的关系
 * 
 * 多个观察者 同时监听某一个主题对象
 * 				Test------------------------>Subject---------------------------------------------------------->Observer
 * 												(add(),dell(),notify())																update()
 * 															|																				/			\			
 * 															|																			/					\
 * 												AbstractSubject(接口方法)										Observer1 		Observer2
 * 													Vector(Observer)
 * 															|
 * 														MySubject
 * MySubject是我们的主对象，Observer1和Observer2是依赖于MySubject对象
 * 当MySubject对象发生改变，则Observer1和Observer2必然变化,AbstractSubject类中定义了需要监控的对象
 * 可以增加或者删除需要监控的对象
 * 
 * java语言提供对观察者模式的支持
 * java.util库里面，提供了一个Observable类以及一个Observer接口，形成支持
 * 												Observable类代表一个被观察者对象        Observer是观察者---被观察者改变导致观察者改变
 * 被观察者发生改变就通知观察者update
 * 
 */														
 
 												
public class Observer {
	public static void main(String[] args) {
		Subject sub = new MySubject();
		sub.add(new Observer1ImplA());
		sub.add(new Observer1ImplB());
		sub.operation();
	}
}
//Observer 接口
interface Observer1{
	public void update();
}
class Observer1ImplA implements Observer1{
	@Override
	public void update() {
		System.out.println("observer1ImplA has received!");
	}
}
class Observer1ImplB implements Observer1{
	@Override
	public void update() {
	System.out.println("observer1ImplB has received!");
	}
}
//Subject 接口
interface Subject{
	//add 观察者
	public void add(Observer1 observer);
	//delete 观察者
	public void delete(Observer1 observer);
	//notify all 观察者
	public void notifyObserver();
	//自身operate
	public void operation();
}
//抽象Subject     拥有Observer
abstract class  AbstractSubject implements Subject{
	private Vector<Observer1> vector = new Vector<Observer1>();
	@Override
	public void add(Observer1 observer) {
		vector.add(observer);
	}
	@Override
	public void delete(Observer1 observer) {
		vector.remove(observer);
	}
	@Override
	public void notifyObserver() {
		Enumeration<Observer1>enum0 = vector.elements();
		while(enum0.hasMoreElements()){
			enum0.nextElement().update();
		}
	}
}
class MySubject extends AbstractSubject{
	@Override
	public void operation() {
		System.out.println("update self!");
		notifyObserver();
	}	
}




