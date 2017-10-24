package me.modedesign.behavior.observer.stock;

import java.util.ArrayList;
import java.util.List;

/*
 * 秘书类
 */
public class Secretary {
	//行为
	private String action;	

	//同事列表------需要秘书去发出行为的同事
	private List<StockObserver> observers = new ArrayList<StockObserver>();
	
	//增加同事
	public void Attach(StockObserver observer){
		observers.add(observer);
	} 
	
	//通知方法
	public void notifyObservers(){
		for (StockObserver observer : observers) {
			observer.update();
		}
	}
	
	public String getAction() {
		return action;
	}
	public void setAction(String action) {
		this.action = action;
	}
	
	
}
