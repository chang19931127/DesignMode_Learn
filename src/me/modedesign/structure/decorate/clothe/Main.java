package me.modedesign.structure.decorate.clothe;

//仔细了解这个程序！！！！！！！！！！！！！
//这个程序  很有内涵阿、！！！！！！！！！！！、
/*
 * 因此可以明白装饰模式其实是在一个方法中做文章，
 * 其他的就是   依赖关系了，因此你可以装饰他，他可以装饰你，因此具有共同结构
 * 
 * 我们这里做文章的地方就是show()方法
 * 
 * 
 * 我们这里是通过  Decorate方法      依赖的
 * 
 * 最好的是  通过构造函数    注入 是最好的！！！！！
 */
public class Main {
	public static void main(String[] args) {
		Person person = new Person("richard");
		
		TShirts tx = new TShirts();
		BigTrouser kk = new BigTrouser();
		Sneakers pqx = new Sneakers();
		System.out.println("richard 的装扮是");
		tx.Decorate(person);
		kk.Decorate(tx);
		pqx.Decorate(kk);
		pqx.show();
	}
}
