package me.modedesign.behavior.state.work;

public class ForenonState implements State {

	@Override
	public void writeProgram(Work work) {
		if(work.getHour() <12){
			System.out.println("��ǰʱ��"+ work.getHour() +"�㣬���繤��������");
		}else{
			work.setState(new NoonState());
			work.workProgram();
		}
	}

}
