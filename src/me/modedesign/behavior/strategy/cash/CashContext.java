package me.modedesign.behavior.strategy.cash;

public class CashContext {
	private CashSuper sc;
	
	//������ǲ���ģʽ�ͼ򵥹���ģʽ�Ľ��
	public CashContext(String type) throws Exception {
		//ʹ�÷���Ϳ��Ա�����Щѡ���ж�Ȼ�󴴽������ˣ���������������������������
		if(null != type && !"".equals(type)){
			if(type.equals("�����շ�")){
				CashNormal cs1 = new CashNormal();
				sc = cs1;
			}else if(type.equals("��8��")){
				CashRebate cs2 = new CashRebate(0.8);
				sc=cs2;
			}else{
				throw new Exception("û���շ����");
			}
		}else{
			throw new Exception("��֤type����Ϊ��");
		}
	}
	
	public double getResult(double money){
		return sc.acceptCash(money);
	}
}
