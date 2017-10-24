package me.modedesign.behavior.strategy.cash;

public class CashNormal extends CashSuper {

	@Override
	public double acceptCash(double money) {
		return money;
	}

}
