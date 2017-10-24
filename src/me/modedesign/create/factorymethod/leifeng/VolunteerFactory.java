package me.modedesign.create.factorymethod.leifeng;


//具体工厂---------志愿者雷锋工厂
public class VolunteerFactory implements IFactory{

	@Override
	public LeiFeng createLeiFeng() {
		return new Volunteer();
	}

}
