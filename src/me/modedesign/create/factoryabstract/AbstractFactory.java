package me.modedesign.create.factoryabstract;

/*
 * ���󹤳�
 * �ṩһ������@һϵ��@��ػ��໥��������Ľӿڣ�������Զ����Ǿ������
 * �����ڹ�������ģʽ�����ǹ�������ģʽֻ�����eat�����⣬��������ƶ�����õ�ʱ�����ģʽ�͸�������------���󹤳�ģʽ��
 * Ҳ����˵һ�������������������ͬ�Ķ���
 * 
 * ������һ���������һ��
 * һ�����󹤳�(�̼�)����ʵ�ֹ���(���ǣ�ƻ��),ÿ����������������(�����Ʒ���ֻ�������),������������(���ǵ��ԣ������ֻ���ƻ�����ԣ�ƻ���ֻ�
 * 
 * ������,�����ֻ����������ԡ�-------------��ƻ����ƻ���ֻ���ƻ�����ԡ���������,�����ֻ������ǵ��ԡ�
 * ��������˵��
 * ���󹤳�ģʽ������������ģʽ��
 * ���󹤳�ģʽ���ǹ���������������ģʽ����һ��������
 * ��������ģʽֻ��һ�������Ʒ�࣬���󹤳��ж����Ʒ��
 */
public class AbstractFactory {
	public static void main(String[] args) {
		// ƻ���ֻ�����
		IFactory factory = new AppleFactory();
		IComputer computer = factory.createComputer();
		IPhone phone = factory.createPhone();
		computer.sufe();
		phone.call();
		//ֻ���޸Ĺ���
		factory = new SamsungFactory();
		computer = factory.createComputer();
		phone = factory.createPhone();
		computer.sufe();
		phone.call();
/*		//������һ����Ϊ����
 * 		ֻ��Ҫ�ṩһ����Ϊ����(��չ)��Ȼ���ṩ��Ϊ�ֻ�(��չ)���ͻ�Ϊ����(��չ)����ok��
		factory = new HuaWeiFactory();
		computer = factory.createComputer();
		phone = factory.createPhone();
		computer.sufe();
		phone.call();*/
	}
}

// �����ֻ�����绰
interface IPhone {
	void call();
}

// ������ԣ���ʾ
interface IComputer {
	void sufe();
}

// �����Ʒ�������ֻ������ǵ���
class SamsungPhone implements IPhone {
	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("�����ֻ���绰");
	}
}

class SansungComputer implements IComputer {
	@Override
	public void sufe() {
		// TODO Auto-generated method stub
		System.out.println("���ǵ�������");
	}
}

// �����Ʒ��ƻ���ֻ���ƻ������
class ApplePhone implements IPhone {
	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("ƻ���ֻ���绰");
	}
}

class AppleComputer implements IComputer {
	@Override
	public void sufe() {
		// TODO Auto-generated method stub
		System.out.println("ƻ����������");
	}
}

/*
 * ���󹤳���
 */
interface IFactory {
	// �����ֻ�
	IPhone createPhone();

	// �������
	IComputer createComputer();
}

// ���峧������
class SamsungFactory implements IFactory {
	@Override
	public IPhone createPhone() {
		// TODO Auto-generated method stub
		return new SamsungPhone();
	}

	@Override
	public IComputer createComputer() {
		// TODO Auto-generated method stub
		return new SansungComputer();
	}
}

// ���峧��ƻ��
class AppleFactory implements IFactory {
	@Override
	public IPhone createPhone() {
		// TODO Auto-generated method stub
		return new ApplePhone();
	}

	@Override
	public IComputer createComputer() {
		// TODO Auto-generated method stub
		return new AppleComputer();
	}
}
