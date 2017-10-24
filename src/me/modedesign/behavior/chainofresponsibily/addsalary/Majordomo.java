package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897
 *	�ܼ�
 */
public class Majordomo extends Manager {

	public Majordomo(String name) {
		super(name);
	}

	@Override
	public void requestApplication(Request request) {
		if (request.getRequestType() == "���" && request.getNumber() <= 5)
			System.out.println(String.format("%s:%s    ����: %d ����׼", name,
					request.getRequestContent(), request.getNumber()));
		else {
			if (superior != null) {
				superior.requestApplication(request);
			}
		}
	}

}
