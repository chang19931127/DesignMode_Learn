package me.modedesign.behavior.mediator.unitednation;

/**
 * 
 * @author 43994897 ���Ϲ��ľ���칫��λ�����Ϲ������
 */
public class UnitedNationsSecurityCouncil extends UniteNations {

	// ����ĵ�λ
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
