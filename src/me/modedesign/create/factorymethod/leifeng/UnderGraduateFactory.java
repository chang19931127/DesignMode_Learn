package me.modedesign.create.factorymethod.leifeng;

//���幤��-------ѧ���׷湤��
public class UnderGraduateFactory implements IFactory {

	@Override
	public LeiFeng createLeiFeng() {
		return new UnderGraduate();
	}

}
