package me.modedesign.structure.bridge.software;

/*
 * �ֻ�Ʒ��
 */
public abstract class HandSetBrand {
	protected HandSetSoft soft;

	public void setSoft(HandSetSoft soft) {
		this.soft = soft;
	}
	
	public abstract void run();
}
