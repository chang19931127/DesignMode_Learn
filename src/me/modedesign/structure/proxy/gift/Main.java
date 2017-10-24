package me.modedesign.structure.proxy.gift;

public class Main {
	public static void main(String[] args) {
		SchoolGirl mm = new SchoolGirl();
		mm.setName("娇娇");
		
		//代理  进行代理
		Proxy daili = new Proxy(mm);
		
		daili.giveDolls();
		daili.giveFlowers();
		daili.giveChocolate();
		
		//这一下就彻底的隐藏了           真正送花的对象了
	}
}
