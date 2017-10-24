package me.modedesign.structure.adapter.basketball;

public class Center extends Player{

	public Center(String name) {
		super(name);
	}

	@Override
	public void Attrack() {
		System.out.println("中锋" + name + "进攻");		
	}

	@Override
	public void Defense() {
		System.out.println("中锋" + name + "进攻");		
	}

}
