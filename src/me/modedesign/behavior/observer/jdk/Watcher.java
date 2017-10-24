package me.modedesign.behavior.observer.jdk;

import java.util.Observable;
import java.util.Observer;

/*
 * π€≤Ï’ﬂ
 */
public class Watcher implements Observer {
	
	public Watcher(Watched watched) {
		watched.addObserver(this);
	}

	@Override
	public void update(Observable observable, Object data) {
		System.out.println("Data has been changed to  "+((Watched)observable).retrieveData());
	}
}
