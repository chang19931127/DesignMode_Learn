package me.modedesign.behavior.iterator.buyticket;

public abstract class Iterator {
	public abstract Object first();
	public abstract Object next();
	public abstract boolean isDone();
	public abstract Object currentItem();
}