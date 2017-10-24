package me.modedesign.structure.facade.stock;

/*
 * 外观模式 
 * 之前 客户端调用一系列对象，必须对一系列对象都要知根知底
 * 而如今，客户端只需要知道一个对象，其他的事情交给这个对象就可以了
 * 这就是外观模式
 * 
 * 为系统中的一组接口提供一个一致的界面，此模式定义了一个高层接口，这个接口使得这个系统更加容易使用
 */
public class Main {
	public static void main(String[] args) {
		Fund jijin = new  Fund();
		
		jijin.buyFund();
		
		
		jijin.sellFund();
	}
}
