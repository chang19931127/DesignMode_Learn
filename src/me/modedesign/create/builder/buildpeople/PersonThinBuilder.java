package me.modedesign.create.builder.buildpeople;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;


//具体的建造者，必须实现所有的方法，要不然编译器就会报错
public class PersonThinBuilder extends PersonBuilder  {

	private static final long serialVersionUID = 4885194437824035455L;

	@Override
	public void buildHead() {
		g.draw(new Ellipse2D.Double(50,20,30,30));
	}

	@Override
	public void buildBody() {
		g.draw(new Rectangle2D.Double(60,50,10,50));
	}

	@Override
	public void buildArmLeft() {
		g.draw(new Line2D.Double(60,50,40,100));
	}

	@Override
	public void buildArmRight() {
		g.draw(new Line2D.Double(70,50,90,100));
	}

	@Override
	public void buildLegLeft() {
		g.draw(new Line2D.Double(60,100,45,150));
	}

	@Override
	public void buildLegRight() {
		g.draw(new Line2D.Double(70,100,85,150));
	}

}
