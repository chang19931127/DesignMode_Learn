package me.modedesign.behavior.state.work;

/*
 * һ�������Ļ��������һЩ״̬��Ȼ��ͨ��״̬��new״̬�������߼��ж�
 */
public class Main {
	public static void main(String[] args) {
		Work work = new Work();
		work.setHour(8);
		work.workProgram();
		work.setHour(13);
		work.workProgram();
	}
}
