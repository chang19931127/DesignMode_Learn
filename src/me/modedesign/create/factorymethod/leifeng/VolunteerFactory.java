package me.modedesign.create.factorymethod.leifeng;


//���幤��---------־Ը���׷湤��
public class VolunteerFactory implements IFactory{

	@Override
	public LeiFeng createLeiFeng() {
		return new Volunteer();
	}

}
