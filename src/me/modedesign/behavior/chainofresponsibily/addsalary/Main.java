package me.modedesign.behavior.chainofresponsibily.addsalary;

public class Main {
	public static void main(String[] args) {
		Manager jingli = new CommonManager("����");
		Manager zongjian = new Majordomo("�ܼ�");
		Manager zongjingli = new GeneralManager("�ܾ���");
		
		jingli.setSuperiot(zongjian);
		zongjian.setSuperiot(zongjingli);
		
		Request request = new Request();
		request.setRequestType("���");
		request.setRequestContent("��Ҫ��٣�����׼");
		request.setNumber(4);
		
		jingli.requestApplication(request);
		
	}
}
