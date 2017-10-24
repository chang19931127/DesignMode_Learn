package me.modedesign.structure.flyweight.website;

/**
 * 
 * @author 43994897
 *	具体网站类
 */
public class ConcreterWebSite extends WebSite {

	private String name;

	public ConcreterWebSite(String name) {
		this.name = name;
	}

	@Override
	public void use() {
		System.out.println("网站分类：" + name);
	}

}
