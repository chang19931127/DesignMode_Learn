package me.modedesign.behavior.memento.gane;

/*
 *  这个类用来 保存状态的，仅仅是保存，并不具有修改的能力
 */
public class RoleStateMemento {
	private String vitality;
	private String attack;
	private String defend;
	
	public RoleStateMemento(String vitality, String attack, String defend) {
		super();
		this.vitality = vitality;
		this.attack = attack;
		this.defend = defend;
	}
	public String getVitality() {
		return vitality;
	}
	public String getAttack() {
		return attack;
	}
	public String getDefend() {
		return defend;
	}
	
	
}
