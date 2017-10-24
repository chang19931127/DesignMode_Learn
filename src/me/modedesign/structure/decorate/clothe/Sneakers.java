package me.modedesign.structure.decorate.clothe;

public class Sneakers extends Clothe {

	@Override
	public void show() {
		add();
		System.out.print("球鞋\t");
		person.show();
	}
	//装饰模式中我们可以尽情去                装饰
	public void add(){
		System.out.print("破");
	}

}
