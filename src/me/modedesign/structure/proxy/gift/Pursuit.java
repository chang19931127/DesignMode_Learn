package me.modedesign.structure.proxy.gift;

/*
 * ׷�����࣡������
 * Ҳ�������ǵ�   ���������
 */
public class Pursuit implements GiveGift{

	private SchoolGirl mm;
	
	public Pursuit(SchoolGirl mm) {
		this.mm = mm;
	}

	@Override
	public void giveDolls() {
		System.out.println(mm.getName() + ",���������ޣ�����" );
	}

	@Override
	public void giveFlowers() {
		System.out.println(mm.getName() + ",�����ʻ�������");
	}

	@Override
	public void giveChocolate() {
		System.out.println(mm.getName() + ",�����ɿ���");
	}	

}
