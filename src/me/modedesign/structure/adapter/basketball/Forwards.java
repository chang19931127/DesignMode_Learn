package me.modedesign.structure.adapter.basketball;

/*
 * ǰ��
 */
public class Forwards extends Player {

	public Forwards(String name) {
		super(name);
	}

	@Override
	public void Attrack() {
		System.out.println("ǰ��" + name + "����");
	}

	@Override
	public void Defense() {
		System.out.println("ǰ��" + name + "����");
	}

}
