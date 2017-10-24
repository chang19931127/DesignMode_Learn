package me.modedesign.behavior.chainofresponsibily.addsalary;

/**
 * 
 * @author 43994897 总经理
 */
public class GeneralManager extends Manager {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void requestApplication(Request request) {
		if (request.getRequestType() == "请假")
			System.out.println(String.format("%s:%s    天数: %d 被批准", name,
					request.getRequestContent(), request.getNumber()));
		else if (request.getRequestContent() == "加薪"
				&& request.getNumber() <= 500) {
			System.out.println(String.format("%s:%s    数量: %d 被批准", name,
					request.getRequestContent(), request.getNumber()));
		} else {
			System.out.println(String.format("%s:%s    数量: %d 再说吧", name,
					request.getRequestContent(), request.getNumber()));
		}
	}

}
