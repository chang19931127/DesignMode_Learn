package me.modedesign.structure.flyweight.website;

/*
 * ͨ��һ������Ȼ�������������ˣ���Ԫ
 */
public class Main {
	public static void main(String[] args) {
		WebSiteFatory f = new WebSiteFatory();
		WebSite ws1 = f.getWebSiteCategory("��Ʒչʾ");
		ws1.use();
		WebSite ws2 = f.getWebSiteCategory("��Ʒչʾ");
		ws2.use();
		WebSite ws3 = f.getWebSiteCategory("��Ʒչʾ");
		ws3.use();
		WebSite ws4 = f.getWebSiteCategory("����");
		ws4.use();
		WebSite ws5 = f.getWebSiteCategory("����");
		ws5.use();
		WebSite ws6 = f.getWebSiteCategory("����");
		ws6.use();
		
		System.out.println("��վ��������Ϊ��"+f.getWebSiteCount());
		
	}
}
