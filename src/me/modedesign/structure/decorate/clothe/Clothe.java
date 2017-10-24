package me.modedesign.structure.decorate.clothe;

public abstract class Clothe implements IPerson {
	protected IPerson person;
	
	public void Decorate(IPerson person){
		this.person = person;
	}
	
	public abstract void show();
}
