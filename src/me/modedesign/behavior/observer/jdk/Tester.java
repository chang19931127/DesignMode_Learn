package me.modedesign.behavior.observer.jdk;

import java.util.Observer;

/*
 * 基于java提供的观察者
 * 
 * 被观察者发生改变 就通知观察者updata
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
