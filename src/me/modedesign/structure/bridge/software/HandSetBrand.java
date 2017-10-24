package me.modedesign.structure.bridge.software;

/*
 * ÊÖ»úÆ·ÅÆ
 */
public abstract class HandSetBrand {
	protected HandSetSoft soft;

	public void setSoft(HandSetSoft soft) {
		this.soft = soft;
	}
	
	public abstract void run();
}
