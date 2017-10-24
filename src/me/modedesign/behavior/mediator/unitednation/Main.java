package me.modedesign.behavior.mediator.unitednation;

public class Main {
	public static void main(String[] args) {
		UnitedNationsSecurityCouncil unsc = new UnitedNationsSecurityCouncil();
		
		USA usa = new USA(unsc);
		Iraq iraq = new Iraq(unsc);
		
		unsc.setUsa(usa);
		unsc.setIraq(iraq);
		
		usa.declare("不准研发核武器");
		iraq.declare("我们没有核武器");
		
		/*
		 * 这里分离了  USA和Iraq的关系，他们之间的关系通过安理会联系起来了，足以看出安理会这个类十分庞大
		 * 十分庞大
		 */
	}
}
