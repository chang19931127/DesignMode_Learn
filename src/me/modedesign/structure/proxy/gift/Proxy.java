package me.modedesign.structure.proxy.gift;

/*
 * �����Ĵ�����
 */
public class Proxy implements GiveGift{

	//ӵ�д������
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
