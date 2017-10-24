package me.modedesign.behavior.state.work;

public class Work {
	private double hour;
	private State state;

	public Work(){
		//�������ʼ״̬
		state =  new ForenonState();
	}
	
	public void workProgram(){
		state.writeProgram(this);
	}
	public double getHour() {
		return hour;
	}

	public void setHour(double hour) {
		this.hour = hour;
	}

	public State getState() {
		return state;
	}

	public void setState(State state) {
		this.state = state;
	}

}
