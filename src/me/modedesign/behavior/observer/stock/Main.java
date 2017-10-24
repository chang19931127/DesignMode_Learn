package me.modedesign.behavior.observer.stock;

public class Main {
	public static void main(String[] args) {
		Secretary tongzizhe = new Secretary();
		
		StockObserver tongshi1 = new StockObserver("小朋友", tongzizhe);
		StockObserver tongshi2 = new StockObserver("大男孩", tongzizhe);
		
		tongzizhe.Attach(tongshi2);
		tongzizhe.Attach(tongshi1);
		
		//老板回来了
		tongzizhe.setAction("老板回来了!!!!");
		
		tongzizhe.notifyObservers();
	}
}
