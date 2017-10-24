package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897 �ܾ���
 */
public class GeneralManager extends Manager {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void requestApplication(Request request) {
		if (request.getRequestType() == "���")
			System.out.println(String.format("%s:%s    ����: %d ����׼", name,
					request.getRequestContent(), request.getNumber()));
		else if (request.getRequestContent() == "��н"
				&& request.getNumber() <= 500) {
			System.out.println(String.format("%s:%s    ����: %d ����׼", name,
					request.getRequestContent(), request.getNumber()));
		} else {
			System.out.println(String.format("%s:%s    ����: %d ��˵��", name,
					request.getRequestContent(), request.getNumber()));
		}
	}

}
