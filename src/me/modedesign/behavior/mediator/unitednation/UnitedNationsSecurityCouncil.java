package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897 联合国的具体办公单位，联合国安理会
 */
public class UnitedNationsSecurityCouncil extends UniteNations {

	// 管理的单位
	private USA usa;
	private Iraq iraq;

	public void setUsa(USA usa) {
		this.usa = usa;
	}

	public void setIraq(Iraq iraq) {
		this.iraq = iraq;
	}

	@Override
	public void declare(String message, Country colleague) {
		if (colleague == usa) {
			iraq.getMessage(message);
		} else {
			usa.getMessage(message);
		}
	}

}
