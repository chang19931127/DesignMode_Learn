package me.modedesign.create.factorysimple;

/*
 * -------------------------------------�򵥹���ģʽ
 * ����һ��@����@�Ĺ����࣬��������������Ҫ�Ķ���---------������Ҫ�Ķ�����Խ��г������
 * �ŵ㣺�ͻ��˲���Ҫ�������Ĵ������Ӷ���ȷ�˸������ְ��
 * ȱ�㣺��θ������ڲ�����¶���ֻ���޸�Դ����
 * 
 * ���������ʹ���ǵĹ���ģʽ �ͻ��˶����޸ĵĻ�����ô���ǿ���ͨ�����䣬ֱ�Ӵ������ļ��л�ȡ��������
 * Ȼ��ֱ�ӿͻ��˵��ã������ļ���д���Ǹ�������ֱ�ӵ����Ǹ������ˣ�������ʮ�ַ���
 * 
 * 
 */
public class SimpleFactory {
	// �ͻ���
	public static void main(String[] args) {
		// ���������
		Dog d = new Dog();
		Cat c = new Cat();
		c.eat();
		d.eat();
		
		// �������ã���������
		Animal a = AnimalFactory.createAmail("dog");
		a.eat();
		a = AnimalFactory.createAmail("cat");
		a.eat();

		// NullPointException
		/*
		 * ������������pig ֻ��Ҫ���������(��չ)���̳�Animal(��չ)��Ȼ���ٹ�����������pig������(��Ҫ�޸�ԭ����)
		 */
		a = AnimalFactory.createAmail("pig");
		a.eat();
	}
}

/*
 * ��������Ҫ���������Ķ��� ���ȳ�������������ӣ����������� �������ʹ�����࣬Ҳ�����ǽӿ�
 */
abstract class Animal {
	public abstract void eat();
}

/*
 * �������һ���������㣬��������������ֱ�ӵ��ö��� ��̬ �����ã����
 */
class Cat extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("è����");
	}
}

/*
 * ͬ�������๷���̳��� Animal------ͨ����̬������
 */
class Dog extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
}

/*
 * ����������ǵ����� ���﹤������������------������������Ǹ�����Ķ�����ڲ������� ���׷���µĶ���ͱ����޸����������
 */
class AnimalFactory {
	// ���ع��췽�����������ʹ��
	private AnimalFactory() {
	}

	// �����ṩ �������Ǵ���Ĳ���������--����
	public static Animal createAmail(String type) {
		// �ж�
		if ("dog".equals(type)) {
			return new Dog();
		} else if ("cat".equals(type)) {
			return new Cat();
		} else {
			return null;
		}
	}
}