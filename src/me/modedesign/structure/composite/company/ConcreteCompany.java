package me.modedesign.structure.composite.company;

import java.util.ArrayList;
import java.util.List;

/*
 * 具体公司类
 */
public class ConcreteCompany extends Company {
	private List<Company> children = new ArrayList<Company>();

	public ConcreteCompany(String name) {
		super(name);
	}

	@Override
	public void add(Company c) {
		children.add(c);
	}

	@Override
	public void remove(Company c) {
		children.remove(c);
	}

	@Override
	public void display(int depth) {

		System.out.println("-"+ depth + name);
		for (Company company : children) {
			company.display(depth + 1);
		}
	}

	@Override
	public void lineOfDuty() {
		for (Company company : children) {
			company.lineOfDuty();
		}
	}

}
