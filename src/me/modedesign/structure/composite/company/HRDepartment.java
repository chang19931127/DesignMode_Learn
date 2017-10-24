package me.modedesign.structure.composite.company;

/*
 * 人力资源部
 * 其他都是空实现
 */
public class HRDepartment extends Company {

	public HRDepartment(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		
	}

	@Override
	public void remove(Company c) {
		
	}

	@Override
	public void display(int depth) {
		System.out.println("-"+depth+name);
	}

	@Override
	public void lineOfDuty() {
		System.out.println(name + "员工培训管理");
	}

}
