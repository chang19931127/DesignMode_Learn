package me.modedesign.behavior.strategy.cash;

//≤‚ ‘
public class Test {
	public static void main(String[] args) throws Exception {
		String type = "¥Ú8’€";
		CashContext cc = new CashContext(type);
		double totalPrice = cc.getResult(100);
		System.out.println(totalPrice);
	}
}
