package me.modedesign.create.builder.buildpeople;

//�ͻ��˵���
public class Main  {
	public static void main(String[] args) {
		PersonBuilder ptb1 = new PersonThinBuilder();
		PersonBuilder ptb2 = new PersonHeavyBuilder();
		PersonDirector pdThin = new PersonDirector(ptb2);
		pdThin.createPerson();
	}
}
