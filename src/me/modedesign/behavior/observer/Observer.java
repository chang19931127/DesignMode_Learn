package me.modedesign.behavior.observer;

import java.util.Enumeration;
import java.util.Vector;


/*
 * �۲���ģʽ-��������ģʽ-ģ����ͼģʽ-Դ������ģʽ
 * 
 * -----������֮��Ĺ�ϵ��
 * 
 * �۲���ģʽ�ܺ���⣬�򵥵���˵����һ�仰����һ������仯ʱ�����������ö���Ķ��󶼻�
 * �յ�֪ͨ���������ű仯�� 
 * ����֮����һ�Զ�Ĺ�ϵ
 * 
 * ����۲��� ͬʱ����ĳһ���������
 * 				Test------------------------>Subject---------------------------------------------------------->Observer
 * 												(add(),dell(),notify())																update()
 * 															|																				/			\			
 * 															|																			/					\
 * 												AbstractSubject(�ӿڷ���)										Observer1 		Observer2
 * 													Vector(Observer)
 * 															|
 * 														MySubject
 * MySubject�����ǵ�������Observer1��Observer2��������MySubject����
 * ��MySubject�������ı䣬��Observer1��Observer2��Ȼ�仯,AbstractSubject���ж�������Ҫ��صĶ���
 * �������ӻ���ɾ����Ҫ��صĶ���
 * 
 * java�����ṩ�Թ۲���ģʽ��֧��
 * java.util�����棬�ṩ��һ��Observable���Լ�һ��Observer�ӿڣ��γ�֧��
 * 												Observable�����һ�����۲��߶���        Observer�ǹ۲���---���۲��߸ı䵼�¹۲��߸ı�
 * ���۲��߷����ı��֪ͨ�۲���update
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
//Observer �ӿ�
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
//Subject �ӿ�
interface Subject{
	//add �۲���
	public void add(Observer1 observer);
	//delete �۲���
	public void delete(Observer1 observer);
	//notify all �۲���
	public void notifyObserver();
	//����operate
	public void operation();
}
//����Subject     ӵ��Observer
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




