package me.modedesign.create.prototype.resume;


public class Main {
	public static void main(String[] args) throws CloneNotSupportedException {
		Resume a = new Resume("����");
		a.setPersonalInfo("��", "29");
		a.setWorkExperence("1998-2000", "XX��˾");
		
		Resume b = (Resume) a.clone();
		b.setWorkExperence("1998-2006", "YY��ҵ");
		
		Resume c = (Resume) a.clone();
		
		c.setPersonalInfo("��", "24");
		System.out.println("...............");
		a.display();
		b.display();
		c.display();
	}
}
