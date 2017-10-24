package me.modedesign.behavior.state.work;

public class NoonState implements State {

	@Override
	public void writeProgram(Work work) {
		System.out.println("下班回家了！！！！！！！");
	}

}
