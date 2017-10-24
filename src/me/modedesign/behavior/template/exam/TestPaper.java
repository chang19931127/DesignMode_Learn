package me.modedesign.behavior.template.exam;

/*
 * 试卷
 * 这里使用了模板方法，我们知道大概的程序代码，这里
 * 我们仅仅流出一个问题，提共给子类去实现，子类通过实现方法，然后被调用
 * 
 * 
 * 
 * 子类方法实现，然后被父类方法调用！！！！！！！！！！
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 这样如果修改需求只需要修改   父类就没有一点问题！
 */
public abstract class TestPaper {
	public void testQuestion1() {
		System.out
				.println("杨过得到，后来给郭靖，练成倚天剑,屠龙刀的选铁可能是[ ] "+"\na.球磨铸铁"+"\nb.马口铁"+"\nc.高速合金钢"+"\nd.碳素纤维");
		answer1();
	}

	public void testQuestion2() {
		System.out.println(" 杨过，承瑛，陆无双铲除了情花，造成[ ]" + "\na.使这种植物不再害人 "
				+ "\nb.使一种珍稀物种灭绝 " + "\nc.破坏了那个生物圈的生态平衡" + "\nd.造成该地区沙漠化");
		answer2();
	}

	protected abstract void answer1();

	protected abstract void answer2();
}
