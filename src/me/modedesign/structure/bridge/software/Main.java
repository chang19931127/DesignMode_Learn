package me.modedesign.structure.bridge.software;

/*
 * 这里两个核心---------------软件
 * 											手机品牌
 * 						不同的手机品牌，拥有的软件也不同，因此，我们通过
 * 		桥接模式，来进行继承的分离，来使得 手机品牌拥有软件，这样子 就 方便很多
 * 		如果我们添加一个新的软件，只用写一个软件类，就可以了
 * 		如果我们添加一个新的手机品牌，同样写一个品牌类，就没有问题了
 * 		很好扩展
 * 
 * 
 * 		不要总是使用继承，有的时候，使用组合，或者聚合能起到更好的作用！！！！！！
 * 
 * 	桥接模式：将抽象部分与它的实现部分分离，使他们都可以独立的变化。
 * 				这里 手机就是抽象部分，软件就是实现部分
 * 			
 */
public class Main {
	public static void main(String[] args) {
		HandSetBrand ab;
		ab = new HandSetBrandN();
		ab.setSoft(new HandSetGame());
		ab.run();
		ab.setSoft(new HandSetAddressList());
		ab.run();

		ab = new HandSetBrandM();
		ab.setSoft(new HandSetGame());
		ab.run();
		ab.setSoft(new HandSetAddressList());
		ab.run();
	}
}
