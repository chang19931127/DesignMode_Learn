package me.modedesign.structure.facade.stock;

/*
 * ���ģʽ������
 * ������
 */
public class Fund {
	private Stock1 stock1;
	private Stock2 stock2;
	private Stock3 stock3;
	private NationalDebt1 nationDebt1;

	public Fund() {
		//��������ڹ����ʱ�����⣬Ҳ���ǿ���д�������
		this.stock1 = new Stock1();
		this.stock2 = new Stock2();
		this.stock3 = new Stock3();
		this.nationDebt1 = new NationalDebt1();
	}

	public void buyFund(){
		stock1.buy();
		stock2.buy();
		stock3.buy();
		nationDebt1.buy();
	}
	
	public void sellFund(){
		stock1.sell();
		stock2.sell();
		stock3.sell();
		nationDebt1.sell();
	}
}
