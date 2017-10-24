package me.modedesign.behavior.iterator.buyticket;

import java.util.ArrayList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		ConcreteAggregate a = new ConcreteAggregate();
		List<Object> list = new ArrayList<Object>();
		list.add("大鸟");
		list.add("小菜");
		list.add("行李");
		list.add("老外");
		list.add("公交内部员工");
		list.add("小偷");
		
		a.setItems(list);
		Iterator i = new ConcreteIterator(a);
		System.out.println(i.first());
		while(!i.isDone()){
			System.out.println(i.currentItem()+"请买票！！！");
			i.next();
		}
	}
}
