package me.modedesign.structure.decorate;

/*
 * 装饰模式
 * 装饰模式就是使用被装饰类的一个子类的实例，在客户端将这个子类的实例交给装饰类--------是继承的替代方式
 * 
 * 有点：使用装饰模式，可以提供比继承更加灵活的扩展对象的功能，可以动态的添加对象的功能，也可以随意的组合这些功能
 * 缺点：正因为可以随意组合，所以就会出现一些不合理的逻辑
 * 通过下面代码好好了解下装饰模式----------jdk中使用装饰模式的就是我们的IO流
 */
public class Decorate {
	public static void main(String[] args) {
		//多态
		Phone p = new IPhone();
		p.call();
		System.out.println("**********************************");
		//需求我在接电话之前听到彩玲
		PhoneDecorate pd = new RingPhoneDecorate(p);//这里就是装饰了p对象
		pd.call();
		System.out.println("**********************************");
		//需求我想接电话之后听音学
		pd = new MusicPhoneDecorate(p);
		pd.call();
		System.out.println("**********************************");
		//需求：我想收集在接听前听彩玲，接后听音乐
		//如何做尼，我们自己使用装饰，然后装饰 ----已经装饰的对象
		pd = new RingPhoneDecorate(new MusicPhoneDecorate(pd));
		pd.call();
		System.out.println("**********************************");
//		回想IO中的操作，io流中使用的是装饰模式，可以装饰，增强功能
//
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
	}
}

// 抽象接口
interface Phone {
	void call();
}

// 接口实现类
class IPhone implements Phone {

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("IPhone手机可以打电话了");
	}

}

// 抽象装饰类----如何能做成一个装饰类
// 装饰类必须拥有 被装饰类的对象-----------然后对相应的方法进行修改
abstract class PhoneDecorate implements Phone {

	private Phone e;

	public PhoneDecorate(Phone e) {
		this.e = e;
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		this.e.call();
	}

}

// 具体的装饰类
class RingPhoneDecorate extends PhoneDecorate {

	public RingPhoneDecorate(Phone e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("这个手机可以听彩玲 ");
		super.call();
	}

}

// 具体的装饰类
class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		super.call();
		System.out.println("这个手机可以听音乐");
	}

}