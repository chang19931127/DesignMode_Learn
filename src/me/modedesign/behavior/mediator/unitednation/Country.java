package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897
 *	�������
 */
public abstract class Country {
	protected UniteNations mediator;
	
	public Country(UniteNations mediator){
		this.mediator = mediator;
	}
	
	//������Ϣ
	public abstract void declare(String message);
	//�����Ϣ
	public abstract void getMessage(String message);
}
