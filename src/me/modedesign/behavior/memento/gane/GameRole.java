package me.modedesign.behavior.memento.gane;

/*
 * ��Ϸ��ɫ������һЩ�ܹ��䶯�����ԣ�������Ҫ��ʱ����
 */
public class GameRole {
	private String vit; // ������
	private String atk; // ������
	private String def; // ������

	// �����ɫ״̬------����ֱ�ӷ���һ���࣬�������� ��ǰ״̬�Ķ���
	public RoleStateMemento saveState() {
		return new RoleStateMemento(vit, atk, def);
	}

	// �ָ���ɫ״̬
	public void recoveryState(RoleStateMemento memento) {
		this.vit = memento.getVitality();
		this.atk = memento.getAttack();
		this.def = memento.getDefend();
	}

	public GameRole() {
		this.vit = "100";
		this.atk = "100";
		this.def = "100";
	}

	// ״̬��ʾ
	public void stateDisplay() {
		System.out.println("��ɫ��ǰ״̬");
		System.out.println("����" + vit);
		System.out.println("������" + atk);
		System.out.println("������" + def + "\n");
	}

	// ս��
	public void fight() {
		this.vit = "0";
		this.atk = "0";
		this.def = "0";
	}

	public String getVit() {
		return vit;
	}

	public void setVit(String vit) {
		this.vit = vit;
	}

	public String getAtk() {
		return atk;
	}

	public void setAtk(String atk) {
		this.atk = atk;
	}

	public String getDef() {
		return def;
	}

	public void setDef(String def) {
		this.def = def;
	}

}
