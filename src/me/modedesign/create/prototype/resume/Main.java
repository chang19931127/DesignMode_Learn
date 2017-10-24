package me.modedesign.create.prototype.resume;


public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Resume a = new Resume("大鸟");
		a.setPersonalInfo("男", "29");
		a.setWorkExperence("1998-2000", "XX公司");
		
		Resume b = (Resume) a.clone();
		b.setWorkExperence("1998-2006", "YY企业");
		
		Resume c = (Resume) a.clone();
		
		c.setPersonalInfo("男", "24");
		System.out.println("...............");
		a.display();
		b.display();
		c.display();
	}
}
