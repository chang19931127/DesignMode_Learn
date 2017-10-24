package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897
 *	����
 */
public class USA extends Country {

	public USA(UniteNations mediator) {
		super(mediator);
	}

	@Override
	public void getMessage(String message) {
		System.out.println("������öԷ���Ϣ��"+message);
	}

	@Override
	public void declare(String message) {
		mediator.declare(message, this);
	}
	
}
