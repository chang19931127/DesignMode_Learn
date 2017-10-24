package me.modedesign.behavior.observer.stock;

public class Main {
	public static void main(String[] args) {
		Secretary tongzizhe = new Secretary();
		
		StockObserver tongshi1 = new StockObserver("С����", tongzizhe);
		StockObserver tongshi2 = new StockObserver("���к�", tongzizhe);
		
		tongzizhe.Attach(tongshi2);
		tongzizhe.Attach(tongshi1);
		
		//�ϰ������
		tongzizhe.setAction("�ϰ������!!!!");
		
		tongzizhe.notifyObservers();
	}
}
