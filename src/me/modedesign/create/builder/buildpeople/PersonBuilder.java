package me.modedesign.create.builder.buildpeople;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

//建造人
//这里提供了 人的大致轮廓，细节去叫子类实现
public abstract class PersonBuilder {

	private static final long serialVersionUID = -7162629489563581268L;
	protected Graphics2D g ;
	
	public abstract void buildHead();
	public abstract void buildBody();
	public abstract void buildArmLeft();
	public abstract void buildArmRight();
	public abstract void buildLegLeft();
	public abstract void buildLegRight();
}
