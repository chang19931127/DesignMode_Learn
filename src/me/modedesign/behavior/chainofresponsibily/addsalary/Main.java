package me.modedesign.behavior.chainofresponsibily.addsalary;

public class Main {
	public static void main(String[] args) {
		Manager jingli = new CommonManager("经理");
		Manager zongjian = new Majordomo("总监");
		Manager zongjingli = new GeneralManager("总经理");
		
		jingli.setSuperiot(zongjian);
		zongjian.setSuperiot(zongjingli);
		
		Request request = new Request();
		request.setRequestType("请假");
		request.setRequestContent("我要请假，请批准");
		request.setNumber(4);
		
		jingli.requestApplication(request);
		
	}
}
