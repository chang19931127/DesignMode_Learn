package me.modedesign.structure.adapter.basketball;

/*
 * ����ѡ��
 */
public abstract class Player {
	protected String name;

	public Player(String name ){
		this . name = name ;
	}
	
	public abstract void Attrack();
	public abstract void Defense();
}
