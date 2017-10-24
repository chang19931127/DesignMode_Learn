package me.modedesign.structure.adapter.basketball;

public class ForegeinCenter  {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void gongji(){
		System.out.println("外籍中锋" + name + "进攻");
	}
	
	public void fangshou(){
		System.out.println("外籍中锋" + name + "防守");
	}
}
