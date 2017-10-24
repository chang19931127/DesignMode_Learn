package me.modedesign.create.builder.buildpeople;

//客户端调用
public class Main  {
	public static void main(String[] args) {
		PersonBuilder ptb1 = new PersonThinBuilder();
		PersonBuilder ptb2 = new PersonHeavyBuilder();
		PersonDirector pdThin = new PersonDirector(ptb2);
		pdThin.createPerson();
	}
}
