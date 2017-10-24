package me.modedesign.structure.adapter.basketball;

/*
 * 客户端调用
 */
public class Main {
	public static void main(String[] args) {
		Player b = new Forwards("巴蒂尔");
		b.Attrack();
		//这里犹豫姚明 不懂英文所以必须进行适配
		/*
		 * 
		 * 实际中，我们都是通过构造器来构造，也就是在我们的大系统中，通过adapter来进行扩展，
		 * 只要 实现的方法是通过对象调用的就有可能
		 * 
		 * 
		 */
		Player m = new TranslatorAdapter("姚明");
		m.Defense();
		
	}
}
