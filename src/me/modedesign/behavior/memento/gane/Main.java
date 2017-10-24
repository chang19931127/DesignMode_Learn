package me.modedesign.behavior.memento.gane;

/*
 * 我们借助了一个RoleStateCaratacker   来存储我们的数据
 */
public class Main {
	public static void main(String[] args) {
		GameRole role = new GameRole();
		role.stateDisplay();
		
		//保存进度-----------借助外力
		RoleStateCarataker stateAdmin = new RoleStateCarataker();
		stateAdmin.setMemote(role.saveState());
		
		//大战
		role.fight();
		role.stateDisplay();
		
		//恢复状态
		role.recoveryState(stateAdmin.getMemote());
		role.stateDisplay();
	}
}
