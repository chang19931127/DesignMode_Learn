package me.modedesign.create.factorysimple;

/*
 * -------------------------------------简单工厂模式
 * 定义一个@具体@的工厂类，用来生产我们需要的对象---------我们需要的对象可以进行抽象出来
 * 优点：客户端不需要负责对象的创建，从而明确了各个类的职责
 * 缺点：如何给工厂内部添加新对象只能修改源代码
 * 
 * 如果我们想使我们的工厂模式 客户端都不修改的话，那么我们可以通过反射，直接从配置文件中获取工厂名字
 * 然后直接客户端调用，我们文件中写的那个工厂就直接调用那个工厂了，这样子十分方便
 * 
 * 
 */
public class SimpleFactory {
	// 客户端
	public static void main(String[] args) {
		// 具体类调用
		Dog d = new Dog();
		Cat c = new Cat();
		c.eat();
		d.eat();
		
		// 工厂调用，这个解耦方便
		Animal a = AnimalFactory.createAmail("dog");
		a.eat();
		a = AnimalFactory.createAmail("cat");
		a.eat();

		// NullPointException
		/*
		 * 这里如果想添加pig 只需要创建这个类(扩展)，继承Animal(扩展)，然后再工厂中添加这个pig的制造(需要修改原代码)
		 */
		a = AnimalFactory.createAmail("pig");
		a.eat();
	}
}

/*
 * 将我们需要工厂出来的对象 首先抽象出来，这样子，解耦，方便调用 这里可以使抽象类，也可以是接口
 */
abstract class Animal {
	public abstract void eat();
}

/*
 * 这里就是一个具体类鱼，抽象出来动物，外面直接调用动物 多态 来引用，最好
 */
class Cat extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("猫吃鱼");
	}
}

/*
 * 同样具体类狗，继承了 Animal------通过多态来调用
 */
class Dog extends Animal {
	@Override
	public void eat() {
		// TODO Auto-generated method stub
		System.out.println("狗吃肉");
	}
}

/*
 * 这个类是我们的主角 动物工厂，用来生产------动物，但是生产那个具体的动物，在内部来抉择 因此追加新的动物，就必须修改这个工厂类
 */
class AnimalFactory {
	// 隐藏构造方法，不让外界使用
	private AnimalFactory() {
	}

	// 对外提供 根据我们传入的参数来进行--生产
	public static Animal createAmail(String type) {
		// 判断
		if ("dog".equals(type)) {
			return new Dog();
		} else if ("cat".equals(type)) {
			return new Cat();
		} else {
			return null;
		}
	}
}