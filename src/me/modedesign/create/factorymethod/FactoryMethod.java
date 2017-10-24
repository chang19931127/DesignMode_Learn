package me.modedesign.create.factorymethod;

/*
 * 工厂方法模式
 * 抽象工厂类，负责定义创建对象的接口----------具体对象的创建工作交给具体工厂类来实现
 * 也就是说，工厂类抽象出来了！！！！
 */
public class FactoryMethod {
	public static void main(String[] args) {
		Factory f = new DogFactory();
		Animal a = f.createAnimal();
		a.eat();
		//这里需要一只猫
		f=new CatFactory();
		a=f.createAnimal();
		a.eat();
/*		这里如果需要一个猪
 * 		我们只需要写一个猪的工厂实现抽象工厂(扩展)----然后写一个猪的类继承动物的类(扩展)，客户端就直接可以调用(只需要修改客户端就可以了)
		f=new PigFactory();
		a=f.createAnimal();
		a.eat();*/
	}
}

/*
 * 将我们需要工厂出来的对象 首先抽象出来，这样子，解耦，方便调用 这里可以使抽象类，也可以是接口
 */
abstract class Animal {
	public abstract void eat();
}

/*
 * 工厂类，抽象出来，调用具体工厂，然后具体工厂创造对象
 */
interface Factory {
	Animal createAnimal();
}

/*
 * 具体类 狗，
 */
class Dog extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("狗吃肉");
	}
}

/*
 * 具体类猫
 */
class Cat extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("猫吃鱼");
	}
}

/*
 * 具体工厂狗
 */
class DogFactory implements Factory{
	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Dog();
	}	
}

/*
 * 具体工厂猫
 */
class CatFactory implements Factory{
	@Override
	public Animal createAnimal() {
		// TODO Auto-generated method stub
		return new Cat();
	}	
}
