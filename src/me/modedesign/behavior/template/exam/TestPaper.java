package me.modedesign.behavior.template.exam;

/*
 * �Ծ�
 * ����ʹ����ģ�巽��������֪����ŵĳ�����룬����
 * ���ǽ�������һ�����⣬�Ṳ������ȥʵ�֣�����ͨ��ʵ�ַ�����Ȼ�󱻵���
 * 
 * 
 * 
 * ���෽��ʵ�֣�Ȼ�󱻸��෽�����ã�������������������
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * ��������޸�����ֻ��Ҫ�޸�   �����û��һ�����⣡
 */
public abstract class TestPaper {
	public void testQuestion1() {
		System.out
				.println("����õ����������������������콣,��������ѡ��������[ ] "+"\na.��ĥ����"+"\nb.�����"+"\nc.���ٺϽ��"+"\nd.̼����ά");
		answer1();
	}

	public void testQuestion2() {
		System.out.println(" �����������½��˫�������黨�����[ ]" + "\na.ʹ����ֲ�ﲻ�ٺ��� "
				+ "\nb.ʹһ����ϡ������� " + "\nc.�ƻ����Ǹ�����Ȧ����̬ƽ��" + "\nd.��ɸõ���ɳĮ��");
		answer2();
	}

	protected abstract void answer1();

	protected abstract void answer2();
}
