package me.modedesign.create.builder.buildpeople;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

//因为是建造模式，因此需要一个指挥官来进行建造
public class PersonDirector extends Frame{
	private PersonBuilder pb;

	public PersonDirector(PersonBuilder pb) {
		this.pb = pb;
	}
	
	/*
	 *	这里面可以自己定义画图顺序
	 * java 中   获得Graphics 比较困难
	 * 
	 */
	@Override
	public void paint(Graphics g) {
		pb.g = (Graphics2D) g;
		pb.buildHead();
		pb.buildBody();
		pb.buildArmLeft();
		pb.buildArmRight();
		pb.buildLegLeft();
		pb.buildLegRight();
	}
	
	public void createPerson(){
		this.setBounds(800, 800, 200, 200);
		this.setVisible(true);
	}
}
