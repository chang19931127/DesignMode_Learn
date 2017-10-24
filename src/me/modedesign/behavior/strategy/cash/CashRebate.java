package me.modedesign.behavior.strategy.cash;

public class CashRebate extends CashSuper {

	private double moneyRebate = 0;
	

	public CashRebate(double moneyRebate) {
		this.moneyRebate = moneyRebate;
	}


	@Override
	public double acceptCash(double money) {
		return money*moneyRebate;
	}
	
}
