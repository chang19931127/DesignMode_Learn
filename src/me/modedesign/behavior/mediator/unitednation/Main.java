package me.modedesign.behavior.mediator.unitednation;

public class Main {
	public static void main(String[] args) {
		UnitedNationsSecurityCouncil unsc = new UnitedNationsSecurityCouncil();
		
		USA usa = new USA(unsc);
		Iraq iraq = new Iraq(unsc);
		
		unsc.setUsa(usa);
		unsc.setIraq(iraq);
		
		usa.declare("��׼�з�������");
		iraq.declare("����û�к�����");
		
		/*
		 * ���������  USA��Iraq�Ĺ�ϵ������֮��Ĺ�ϵͨ���������ϵ�����ˣ����Կ�������������ʮ���Ӵ�
		 * ʮ���Ӵ�
		 */
	}
}
