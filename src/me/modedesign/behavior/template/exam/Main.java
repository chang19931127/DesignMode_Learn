package me.modedesign.behavior.template.exam;

/*
 * ͨ���ͻ��˵��ã�ֱ��ʹ�������ûһ������
 */
public class Main {
	public static void main(String[] args) {
		TestPaper studentA = new TestPaperA();
		studentA.testQuestion1();
		studentA.testQuestion2();
		
		TestPaper studentB = new TestPaperB();
		studentB.testQuestion1();
		studentB.testQuestion2();
	}
}
