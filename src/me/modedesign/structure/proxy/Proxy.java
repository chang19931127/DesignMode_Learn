package me.modedesign.structure.proxy;

/*
 * 代理类
 * 其实每个模式名称就表明了该模式的作用，代理模式就是多一个代理类出来，替元对象进行一些操作，比如我们出去找房子的时候找的是中介，中介就是代理
 * 
 * 代理模式的应用场景
 * 如果已有的方法在使用的时候需要对原有的方法进行改进，此时有两种方法！
 * 				-----1，修改原有的方法来适应，这样违反了“对扩展开放，对修改关闭”的原则
 * 				-----2，就是采用一个代理类调用原有的方法，且对产生的结果进行控制，这种方法就是代理模式
 * 使用代理模式可以将功能划分的清晰，有助于后期维护
 * 可以说代理模式是对被代理对象   施加控制，而不是增强其功能(这就与装饰模式分割开来)
 * 
 * jdk动态代理  Proxy    InvocationHandler  类
 */
public class Proxy {
	public static void main(String[] args) {
		Sourceable source = new Proxy2();
		source.method();
	}
}
//代理类和被代理类的公共接口，或者抽象类---------普通类也可以
interface Sourceable{
	public void method();
}
//这个是被代理类，需要被代理类代理扩展功能-------------------代理类并没有拥有被代理对象-------装饰模式是拥有的被装饰对象
class Source implements Sourceable{
	@Override
	public void method() {
		System.out.println("this orginal method!");
	}
}
//这个是代理类，对类进行了扩展
class Proxy2 implements Sourceable{
	private Source source;
	public Proxy2() {
		super();
		this.source = new Source();
	}
	@Override
	public void method() {
		before();
		source.method();
		after();
	}
	private void before() {
		System.out.println("before proxy!");
	}
	private void after() {
	System.out.println("after proxy!");
	}
}