package me.modedesign.structure.proxy.gift;

/*
 * 真正的代理类
 */
public class Proxy implements GiveGift{

	//拥有代理对象
	private Pursuit gg ;
	
	
	public Proxy(SchoolGirl	mm) {
		gg = new Pursuit(mm);
	}

	@Override
	public void giveDolls() {
		gg.giveDolls();
	}

	@Override
	public void giveFlowers() {
		gg.giveFlowers();
	}

	@Override
	public void giveChocolate() {
		gg.giveChocolate();
	}

}
