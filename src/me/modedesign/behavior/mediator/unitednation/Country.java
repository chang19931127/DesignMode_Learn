package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897
 *	抽象国家
 */
public abstract class Country {
	protected UniteNations mediator;
	
	public Country(UniteNations mediator){
		this.mediator = mediator;
	}
	
	//声明消息
	public abstract void declare(String message);
	//获得消息
	public abstract void getMessage(String message);
}
