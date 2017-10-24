package me.modedesign.behavior.iterator.buyticket;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ConcreteAggregate a = new ConcreteAggregate();
		List<Object> list = new ArrayList<Object>();
		list.add("����");
		list.add("С��");
		list.add("����");
		list.add("����");
		list.add("�����ڲ�Ա��");
		list.add("С͵");
		
		a.setItems(list);
		Iterator i = new ConcreteIterator(a);
		System.out.println(i.first());
		while(!i.isDone()){
			System.out.println(i.currentItem()+"����Ʊ������");
			i.next();
		}
	}
}
