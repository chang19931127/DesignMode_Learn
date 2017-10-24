package me.modedesign.create.factorymethod;

/*
 * ��������ģʽ
 * ���󹤳��࣬�����崴������Ľӿ�----------�������Ĵ��������������幤������ʵ��
 * Ҳ����˵���������������ˣ�������
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Factory f = new DogFactory();
		Animal a = f.createAnimal();
		a.eat();
		//������Ҫһֻè
		f=new CatFactory();
		a=f.createAnimal();
		a.eat();
/*		���������Ҫһ����
 * 		����ֻ��Ҫдһ����Ĺ���ʵ�ֳ��󹤳�(��չ)----Ȼ��дһ�������̳ж������(��չ)���ͻ��˾�ֱ�ӿ��Ե���(ֻ��Ҫ�޸Ŀͻ��˾Ϳ�����)
		f=new PigFactory();
		a=f.createAnimal();
		a.eat();*/
	}
}

/*
 * ��������Ҫ���������Ķ��� ���ȳ�������������ӣ����������� �������ʹ�����࣬Ҳ�����ǽӿ�
 */
abstract class Animal {
	public abstract void eat();
}

/*
 * �����࣬������������þ��幤����Ȼ����幤���������
 */
interface Factory {
	Animal createAnimal();
}

/*
 * ������ ����
 */
class Dog extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("������");
	}
}

/*
 * ������è
 */
class Cat extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("è����");
	}
}

/*
 * ���幤����
 */
class DogFactory implements Factory{
	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Dog();
	}	
}

/*
 * ���幤��è
 */
class CatFactory implements Factory{
	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Cat();
	}	
}
