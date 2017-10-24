package me.modedesign.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * 原型模式
 * 原型模式从名字可以看出，该模式的思想就是将一个对象作为原型，对其进行复制，克隆，产生一个和原对象类似的新对象
 */
public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Prototypes pro = new Prototypes();
		pro.setString("长江");
		SerializableObject obj= new SerializableObject("很长");
		pro.setObj(obj);
		System.out.println("pro:"+pro.getString()+"---"+pro.getObj());
		Prototypes pro2 =new Prototypes(); 
		pro2.setString("黄河");
		SerializableObject obj2= new SerializableObject("很黄");
		pro2.setObj(obj2);
		System.out.println("pro2:"+pro2.getString()+"---"+pro2.getObj());
		Prototypes pro3 = new Prototypes();
		pro2 = (Prototypes) pro.clone();
		//这里是浅复制，可以看出，对象是直接过来的，并没有重复复制一个新的
		System.out.println("浅复制之后----pro2：String："+pro2.getString()+"---obj:"+pro2.getObj().getName());
		pro3 = (Prototypes) pro.deepClone();
		//这里是深复制，可以看出，引用对象存在，同时，引用对象是重新构造的
		System.out.println("深复制之后----pro3：String："+pro3.getString()+"---obj:"+pro3.getObj().getName());
		//这里就可以看出他们之间的 端倪 --------我们选择修改pro的引用setObj
		obj.setName("浅复制惨了，复制的对象pro的应用对象obj的值被修改了");
		System.out.println("浅复制之后----pro2：String："+pro2.getString()+"---obj:"+pro2.getObj().getName());
		System.out.println("深复制之后----pro3：String："+pro3.getString()+"---obj:"+pro3.getObj().getName());
		//这里可以得出一个结论就是 浅复制的对象的引用对象并没有完全复制，只是复制的是引用
	}
}

//原型类
/*
 * 很简单一个原型类，只需要实现CLoneable接口，覆写clone方法(这里方法名无所谓可以叫 clone1，也可以叫clone2，但是一定不要忘记 super.clone()这个方法调用)
 * Object.clone()方法是native方法，不做多考虑
 * 
 * 这里对于clone进行一个普及知识
 * 浅复制：
 * 		将一个对象复制后，基本数据类型的变量都会重新创建(复制)，而引用类型指向的还是原对象所指向的
 * 深复制：
 * 		将一个对象复制后，不论是基本数据类型还是引用类型，都是重新创建的。
 * 简单的来说，深复制就是完全彻底的复制，而浅复制不彻底
 * 
 * java语言所有类都会继承一个方法clone()方法，而这个方法所作的正式浅复制
 */
class Prototypes implements Cloneable,Serializable{

	private static final long serialVersionUID = 881922500265594229L;
	
	private String string;
	
	private SerializableObject obj;
	
	//浅复制
	@Override
	public Object clone() throws CloneNotSupportedException {
		Prototypes proto = (Prototypes) super.clone();
//		加上下面两段 代码，通过复制 引用对象，从而达到深复制------------------如果引用还涉及引用，那么还是串行化深复制比较完美
//		SerializableObject obj = (SerializableObject) proto.getObj().clone();
//		proto.setObj(obj);
		return proto;
	}
	
	//深复制
	/*
	 * 把对象写入流里的过程是串行化(Serialization)过程，叫做冷冻
	 * 而把对象从流中读出来的并行化(Deserialization)的过程，叫做解冻
	 * java语言里深复制一个对象，常常可以先使用对象实现Serializable接口，然后把对象写到一个流里
	 * 在从流里读出来，就可以重建对象
	 */
	public Object deepClone() throws CloneNotSupportedException, IOException, ClassNotFoundException{
		//写入当前对象的二进制流
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		//读入二进制流产生的新对象
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public SerializableObject getObj() {
		return obj;
	}
	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}
}

class SerializableObject implements Serializable,Cloneable{
	
	private String name;
	public SerializableObject() {
		super();
	}
	public SerializableObject(String name) {
		this.name = name;
	}
	private static final long serialVersionUID = 1L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

