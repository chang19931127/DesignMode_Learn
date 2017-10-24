package me.modedesign.behavior.memento.gane;

/*
 * 存储备忘录的对象，不能对备忘录对象进行修改
 */
public class RoleStateCarataker {
	private RoleStateMemento memote;

	public RoleStateMemento getMemote() {
		return memote;
	}

	public void setMemote(RoleStateMemento memote) {
		this.memote = memote;
	}
	
	
}
