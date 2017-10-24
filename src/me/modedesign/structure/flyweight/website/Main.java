package me.modedesign.structure.flyweight.website;

/*
 * 通过一个管理，然后来共享数据了，享元
 */
public class Main {
	public static void main(String[] args) {
		WebSiteFatory f = new WebSiteFatory();
		WebSite ws1 = f.getWebSiteCategory("产品展示");
		ws1.use();
		WebSite ws2 = f.getWebSiteCategory("产品展示");
		ws2.use();
		WebSite ws3 = f.getWebSiteCategory("产品展示");
		ws3.use();
		WebSite ws4 = f.getWebSiteCategory("博客");
		ws4.use();
		WebSite ws5 = f.getWebSiteCategory("博客");
		ws5.use();
		WebSite ws6 = f.getWebSiteCategory("博客");
		ws6.use();
		
		System.out.println("网站分类总数为："+f.getWebSiteCount());
		
	}
}
