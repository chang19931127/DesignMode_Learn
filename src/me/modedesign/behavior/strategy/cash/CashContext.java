package me.modedesign.behavior.strategy.cash;

public class CashContext {
	private CashSuper sc;
	
	//这里就是策略模式和简单工厂模式的结合
	public CashContext(String type) throws Exception {
		//使用反射就可以避免这些选择判断然后创建对象了！！！！！！！！！！！！！！
		if(null != type && !"".equals(type)){
			if(type.equals("正常收费")){
				CashNormal cs1 = new CashNormal();
				sc = cs1;
			}else if(type.equals("打8折")){
				CashRebate cs2 = new CashRebate(0.8);
				sc=cs2;
			}else{
				throw new Exception("没有收费情况");
			}
		}else{
			throw new Exception("保证type不能为空");
		}
	}
	
	public double getResult(double money){
		return sc.acceptCash(money);
	}
}
