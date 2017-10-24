package me.modedesign.behavior.state.work;

/*
 * 一个上下文环境，配合一些状态，然后通过状态来new状态，进行逻辑判断
 */
public class Main {
	public static void main(String[] args) {
		Work work = new Work();
		work.setHour(8);
		work.workProgram();
		work.setHour(13);
		work.workProgram();
	}
}
