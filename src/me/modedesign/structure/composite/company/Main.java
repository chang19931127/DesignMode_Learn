package me.modedesign.structure.composite.company;

public class Main {
	public static void main(String[] args) {
		Company root = new ConcreteCompany("�����ܹ�˾");
		root.add(new HRDepartment("�ܹ�˾������Դ��"));
		root.add(new FinanceDepartment("�ܹ�˾����"));
		
		Company comp = new ConcreteCompany("�Ϻ������ֹ�˾");
		comp.add(new HRDepartment("�����ֹ�˾������Դ��"));
		comp.add(new FinanceDepartment("�����ֹ�˾����"));
		root.add(comp);
		
		Company comp1 = new ConcreteCompany("�Ͼ����´�");
		comp1.add(new HRDepartment("�Ͼ����´�������Դ��"));
		comp1.add(new FinanceDepartment("�Ͼ����´�����"));
		root.add(comp1);
		
		Company comp2 = new ConcreteCompany("���ݰ��´�");
		comp2.add(new HRDepartment("���ݰ��´�������Դ��"));
		comp2.add(new FinanceDepartment("���ݰ��´���������"));
		root.add(comp2);
		System.out.println("\n�ṹͼ");
		root.display(1);
		System.out.println("\nְ��");
		root.lineOfDuty();
	}
}
