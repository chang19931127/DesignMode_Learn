package me.modedesign.structure.adapter.basketball;

public class Center extends Player{

	public Center(String name) {
		super(name);
	}

	@Override
	public void Attrack() {
		System.out.println("�з�" + name + "����");		
	}

	@Override
	public void Defense() {
		System.out.println("�з�" + name + "����");		
	}

}
