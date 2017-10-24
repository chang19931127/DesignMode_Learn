package me.modedesign.create.builder;

/*
 * 建造者模式
 * -----建造模式可以将一个产品的内部表象与产品的生成过程分割开来，从而可以使一个建造过程生成
 * 
 * 建造模式利用一个！导演者对象！和具体！建造者对象！一个一个地建造出所有的零件，从而建造出
 * 所有的零件，隐藏零件建造过程，把对建造过程进行指挥的责任和具体建造者零件的责任分割开来，
 * 达到责任划分和封装的目的
 * 零件可能是对象，也可能是组成成分
 * 
 * 涉及的角色
 * -----抽象建造者角色
 * -----具体建造者角色
 * -----导演者角色-------------------与客户端交通的
 * -----产品角色
 * 
 * 什么时候使用建造者模式
 * 1，需要生成的产品对象有复杂的内部结构
 * 2，需要生成的产品对象的属性相互依赖
 * 3，在对象创建过程中使用到系统中其他的一些对象
 * 
 * --------------场景应用建造小人
 * 建造人---需要建造（头，身体，左手，右手。。。。。）零件，这些零件构成一个(人)产品
 * 根据零件的不同，导致产品不同 ，这就是建造模式的真谛
 * 当一个产品需要很多零件参与构造的时候---使用建造者决定一种产品的制造，使用指挥官来调用建造者
 * 
 * JavaMail 中的Message 和MimeMessage等类 均是退化的建造者模式的应用
 */
public class Builder {
	public static void main(String[] args) {
		//客户端直接操作 导演者，然后调用导演者的 构造产品方法
		Director director = new Director();
		director.construct();
		
		System.out.println("----------------------------------------");
		//也可以忽略导演者
		Builders builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		Product product = builder.retrieveResult();
	}
}
//导演者角色
class Director{
	private Builders builder;
	//这个方法很重要，这个方法是！产品构造方法！负责调用各个零件-产生产品
	public void construct(){
		builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		builder.retrieveResult();
		//continue with other code
	}
}
//抽象建造者角色
abstract class Builders{
	//零件一
	public abstract void buildPart1();
	//零件二
	public abstract void buildPart2();
	public abstract Product retrieveResult();
}
//具体的建造者角色----------这样子的话建造者：必须所有零件都要建造，否则编译不通过
class ConcreteBuilder extends Builders{
	private Product product = new Product();

	@Override
	public void buildPart1() {
		// TODO Auto-generated method stub
		//builder the first part of the produce
		System.out.println("产生零件一");
	}

	@Override
	public void buildPart2() {
		// TODO Auto-generated method stub
		//builder the second part of the produce
		System.out.println("产生零件二");
	}

	@Override
	public Product retrieveResult() {
		// TODO Auto-generated method stub
		System.out.println("产品已经得到"+product);
		return product;
	}
	
}
//产品角色-------------------这里如果有多个产品，就可以抽象出接口
class Product{
	//Anything pertaining to this product
	//builderPart1----builderPart2
	//这里需要注意的是：产品是由零件决定的，这些零件缺一不可
}