package me.modedesign.behavior.observer.jdk;

import java.util.Observer;

/*
 * ����java�ṩ�Ĺ۲���
 * 
 * ���۲��߷����ı� ��֪ͨ�۲���updata
 */
public class Tester {
	static private Watched watched;
	static private Observer watcher;
	public static void main(String[] args) {
		watched = new Watched();
		watcher = new Watcher(watched);
		watched.changeData("in c, we create bugs.");
		watched.changeData("in java, we inherit bugs.");
		watched.changeData("in visual basic , we visualize bugs");
	}
}
