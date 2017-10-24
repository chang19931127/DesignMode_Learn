package me.modedesign.structure.adapter.basketball;

/*
 * �������࣬ͨ��ӵ��fc��
 * ����Ҳ����ͨ������ע��������
 */
public class TranslatorAdapter extends Player {

	private ForegeinCenter fc = new ForegeinCenter();

	public TranslatorAdapter(String name) {
		super(name);
		fc.setName(name);
		System.out.println("��"+fc.getName()+"����");
	}

	@Override
	public void Attrack() {
		fc.gongji();
	}

	@Override
	public void Defense() {
		fc.fangshou();
	}

}
