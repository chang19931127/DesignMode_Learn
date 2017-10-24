package me.modedesign.behavior.memento.gane;

/*
 *  ��������� ����״̬�ģ������Ǳ��棬���������޸ĵ�����
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
