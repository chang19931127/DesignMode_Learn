package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897
 *	美国
 */
public class USA extends Country {

	public USA(UniteNations mediator) {
		super(mediator);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("美国获得对方信息："+message);
	}

	@Override
	public void declare(String message) {
		mediator.declare(message, this);
	}
	
}
