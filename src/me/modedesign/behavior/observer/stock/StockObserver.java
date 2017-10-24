package me.modedesign.behavior.observer.stock;

public class StockObserver {
	private String name;
	private Secretary sub;
	
	public StockObserver() {
		super();
	}

	public StockObserver(String name, Secretary sub) {
		super();
		this.name = name;
		this.sub = sub;
	}
	
	public void update(){
		System.out.println(String.format(" �رչ�Ʊ���飬��������������", sub.getAction(),name));
	}
}
