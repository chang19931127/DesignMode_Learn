package me.modedesign.behavior.memento.gane;

/*
 * ���ǽ�����һ��RoleStateCaratacker   ���洢���ǵ�����
 */
public class Main {
	public static void main(String[] args) {
		GameRole role = new GameRole();
		role.stateDisplay();
		
		//�������-----------��������
		RoleStateCarataker stateAdmin = new RoleStateCarataker();
		stateAdmin.setMemote(role.saveState());
		
		//��ս
		role.fight();
		role.stateDisplay();
		
		//�ָ�״̬
		role.recoveryState(stateAdmin.getMemote());
		role.stateDisplay();
	}
}
