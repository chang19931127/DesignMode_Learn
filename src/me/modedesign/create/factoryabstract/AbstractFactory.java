package me.modedesign.create.factoryabstract;

/*
 * 抽象工厂
 * 提供一个创建@一系列@相关或相互依赖对象的接口，而无需吃定他们具体的类
 * 类似于工厂方法模式，但是工厂方法模式只解决了eat得问题，当工厂设计多个引用的时候，设计模式就改名叫作------抽象工厂模式了
 * 也就是说一个工厂可以生产多个不同的对象
 * 
 * 这里有一个例子理解一下
 * 一个抽象工厂(商家)两个实现工厂(三星，苹果),每个工厂都可以生产(抽象产品，手机，电脑),具体下来就是(三星电脑，三星手机，苹果电脑，苹果手机
 * 
 * 〈厂家,生产手机，生产电脑〉-------------〈苹果，苹果手机，苹果电脑〉，〈三星,三星手机，三星电脑〉
 * 可以这样说，
 * 抽象工厂模式依赖工厂方法模式，
 * 抽象工厂模式就是工厂，而工厂方法模式就是一条生产线
 * 工厂方法模式只有一个抽象产品类，抽象工厂有多个产品类
 */
public class AbstractFactory {
	public static void main(String[] args) {
		// 苹果手机工厂
		IFactory factory = new AppleFactory();
		IComputer computer = factory.createComputer();
		IPhone phone = factory.createPhone();
		computer.sufe();
		phone.call();
		//只用修改工厂
		factory = new SamsungFactory();
		computer = factory.createComputer();
		phone = factory.createPhone();
		computer.sufe();
		phone.call();
/*		//如果添加一个华为工厂
 * 		只需要提供一个华为工厂(扩展)，然后提供华为手机(扩展)，和华为电脑(扩展)，就ok了
		factory = new HuaWeiFactory();
		computer = factory.createComputer();
		phone = factory.createPhone();
		computer.sufe();
		phone.call();*/
	}
}

// 抽象手机，打电话
interface IPhone {
	void call();
}

// 抽象电脑，显示
interface IComputer {
	void sufe();
}

// 具体产品，三星手机，三星电脑
class SamsungPhone implements IPhone {
	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("三星手机打电话");
	}
}

class SansungComputer implements IComputer {
	@Override
	public void sufe() {
		// TODO Auto-generated method stub
		System.out.println("三星电脑上网");
	}
}

// 具体产品，苹果手机，苹果电脑
class ApplePhone implements IPhone {
	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("苹果手机打电话");
	}
}

class AppleComputer implements IComputer {
	@Override
	public void sufe() {
		// TODO Auto-generated method stub
		System.out.println("苹果电脑上网");
	}
}

/*
 * 抽象工厂类
 */
interface IFactory {
	// 创造手机
	IPhone createPhone();

	// 创造电脑
	IComputer createComputer();
}

// 具体厂家三星
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

// 具体厂家苹果
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
