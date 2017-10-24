package me.modedesign.structure.composite.company;

/*
 * 财务部
 */
public class FinanceDepartment extends Company {

	public FinanceDepartment(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void remove(Company c) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display(int depth) {
		System.out.println("-"+depth+name);
	}

	@Override
	public void lineOfDuty() {
		System.out.println(name+"公司财务收支管理");
	}

}
