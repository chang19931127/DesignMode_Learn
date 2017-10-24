package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897
 *	伊拉克
 */
public class Iraq extends Country {

	public Iraq(UniteNations mediator) {
		super(mediator);
	}

	@Override
	public void declare(String message) {
		mediator.declare(message, this);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("伊拉克获得对方消息："+message);
	}

}
