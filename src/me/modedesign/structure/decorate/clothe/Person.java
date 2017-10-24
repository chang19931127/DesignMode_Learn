package me.modedesign.structure.decorate.clothe;

//Person
public class Person implements IPerson {
	private String name;

	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	public void show(){
		System.out.println("×°°çµÄÊÇ"+name);
	}
}
