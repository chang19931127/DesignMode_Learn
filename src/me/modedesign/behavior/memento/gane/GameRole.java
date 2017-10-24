package me.modedesign.behavior.memento.gane;

/*
 * 游戏角色，具有一些能够变动的属性，我们需要及时保存
 */
public class GameRole {
	private String vit; // 生命力
	private String atk; // 攻击力
	private String def; // 防御力

	// 保存角色状态------我们直接返回一个类，这个类就是 当前状态的对象
	public RoleStateMemento saveState() {
		return new RoleStateMemento(vit, atk, def);
	}

	// 恢复角色状态
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

	// 状态提示
	public void stateDisplay() {
		System.out.println("角色当前状态");
		System.out.println("体力" + vit);
		System.out.println("攻击力" + atk);
		System.out.println("防御力" + def + "\n");
	}

	// 战斗
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
