package me.modedesign.behavior.state.work;

public class ForenonState implements State {

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() <12){
			System.out.println("当前时间"+ work.getHour() +"点，上午工作，精神");
		}else{
			work.setState(new NoonState());
			work.workProgram();
		}
	}

}
