package me.modedesign.behavior.template.exam;

/*
 * 通过客户端调用，直接使用子类就没一点问题
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
