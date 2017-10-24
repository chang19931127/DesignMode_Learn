package me.modedesign.create.factorymethod.leifeng;

//具体工厂-------学生雷锋工厂
public class UnderGraduateFactory implements IFactory {

	@Override
	public LeiFeng createLeiFeng() {
		return new UnderGraduate();
	}

}
