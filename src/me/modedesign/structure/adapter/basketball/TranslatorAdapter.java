package me.modedesign.structure.adapter.basketball;

/*
 * 适配器类，通过拥有fc，
 * 我们也可以通构造器注入来进行
 */
public class TranslatorAdapter extends Player {

	private ForegeinCenter fc = new ForegeinCenter();

	public TranslatorAdapter(String name) {
		super(name);
		fc.setName(name);
		System.out.println("替"+fc.getName()+"翻译");
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
