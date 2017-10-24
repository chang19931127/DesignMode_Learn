package me.modedesign.behavior.observer.stock;

import java.util.ArrayList;
import java.util.List;

/*
 * ������
 */
public class Secretary {
	//��Ϊ
	private String action;	

	//ͬ���б�------��Ҫ����ȥ������Ϊ��ͬ��
	private List<StockObserver> observers = new ArrayList<StockObserver>();
	
	//����ͬ��
	public void Attach(StockObserver observer){
		observers.add(observer);
	} 
	
	//֪ͨ����
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
