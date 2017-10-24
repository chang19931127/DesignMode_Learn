package me.modedesign.structure.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

/*
 * Flyweight模式---享元模式
 * 		享元模式是对象的结构模式，享元模式以共享的方式高效的支持大量的细粒度对象。
 * 		享元对象能做到共享的关键是区分内蕴状态(Internal State)和外蕴状态(External State)
 * 																			也就是内部状态，外部状态---翻译真垃圾！
 * 		一个内蕴状态是存储在享元对象内部的，并且是不会随环境改变而有所改变的，因此一个享元可以具有内蕴状态并可以共享
 * 		一个外蕴状态是随环境改变而改变的，不可以共享的状态。享元对象的外蕴状态必须由客户端保存，并在享元对象被创建之后
 * 在需要使用的时候再传入到享元对象内部。
 * 外蕴状态不影响内蕴状态，他们是相互独立的
 * 
 * 
 * 享元模式的主要目的是实现对象的共享，即共享池，当系统中对象多的时候可以减少内存的开销。-----通常与工厂模式一起使用
 * 					FlyWeightFactor    ----------------------------->FlyWeight
 * 								|														|				|
 * 								|													|				         |
 * 							Client											FlyWeight   		 FlyWeight2
 * FlyWeightFactory负责创建和管理享元单元，当一个客户端请求时，工厂需要检查当前对象池中是否有符合条件的对象，
 * 如果有，就返回存在的对象
 * 如果没有，就创建一个新的对象 						FlyWeight是超类
 * 一提到共享池，自然就想到jdbc连接池，就可以总结出特点，共有的属性，因此就适合用享元模式来处理，这样就可以减少实例的数量
 * 例子--------模拟数据库连接池的例子ConnectionPool
 * 
 * 例子-java语言中，String类型就是使用了！享元模式！
 * 包装类     -128 ，127 也使用了享元模式   以及boolean 的"true"和"false"
 * 
 * 享元模式的使用条件
 * 		一个系统有大量的对象
 * 		这些对象耗费大量的内存
 * 		这些对象的状态中的大部分都可以外部化
 * 		这些对象可以按照内蕴状态分成很多组，当把外蕴对象从对象中剔除时，每一组都可以仅仅用一个对象代替
 * 		软件系统不依赖于这些对象的身份，换言之，这些对象可以是不可分辨的
 * 
 * 优点：大幅度的降低内存中对象的数量
 * 缺点：使系统更加复杂，为了使对象可以共享，需要将一些状态外部化，使得读取外部状态运行时间稍微变长
 */
public class Flyweight {
	public static void main(String[] args) {
		// 创建一个享元工厂对象
		FlyWeightFactory factory = new FlyWeightFactory();
		// 向享元工厂对象请求一个内蕴状态为"a"的享元对象
		FlyWeightDemo fly = factory.factory(new Character('a'));
		// 以参量方式传入一个外蕴状态
		fly.operation("First Call");
		// 向享元工厂对象请求一个内蕴状态为'b'的享元对象
		fly = factory.factory(new Character('b'));
		// 以参量方式传入一个外蕴状态
		fly.operation("Second Call");
		// 向享元工厂对象请求一个内蕴状态为'a'的享元对象
		fly = factory.factory(new Character('a'));
		// 以参量方式传入一个外蕴状态
		fly.operation("Third Call");
		/*		
		 * 上述申请了三个享元对象，但是实际上创建的享元对象只有两个，这就是共享的含义
		 */
		factory.checkFlyWeight();
	}
}
// 抽象接口 FlyWeight
abstract class FlyWeightDemo {
	// 一个示意性的方法，参数state是外蕴状态
	//外蕴状态     这个传参的提供就是为了外蕴状态
	public abstract void operation(String state);
}

// 具体享元角色------------------享元类事例化必须通过工厂对象
class ConcreteFlyWeight extends FlyWeightDemo {
	//这里是为了内蕴状态提供存储空间---------这个变量就是存储的内部状态
	private Character intrinsicState = null;

	// 构造器，内蕴状态作为参数传入
	public ConcreteFlyWeight(Character state) {
		this.intrinsicState = state;
	}

	@Override
	//这个参数state是外蕴状态传入的
	public void operation(String state) {
		System.out.println("\nIntrinsic State =" + intrinsicState
				+ ",Extrinsic State= " + state);
	}
}

class FlyWeightFactory {
	private HashMap files = new HashMap();
	private FlyWeightDemo lnkFlyWeight;
	// 构造器
	public FlyWeightFactory() {
	}
	//内蕴状态作为参数传入
	//现保存到集合或者数组中(起一个对象存储作用)，使用key值来筛选是否已经存在
	public FlyWeightDemo factory(Character state) {
		if (files.containsKey(state)) {
			return (FlyWeightDemo) files.get(state);
		} else {
			FlyWeightDemo fly = new ConcreteFlyWeight(state);
			files.put(state, fly);
			return fly;
		}
	}

	// 辅助方法
	public void checkFlyWeight() {
		FlyWeightDemo fly;
		int i = 0;
		System.out.println("\n=========checkFlyWeight()=======");
		for (Iterator it = files.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry e = (Entry) it.next();
			System.out.println("Item " + (++i) + ":" + e.getKey());
		}
		System.out.println("=============checkFlyWeight============");
	}
}

/*------------------------------------------------------------------------------------------------------------------------------------------------------------
 * 这个例子
 * 连接池管理，实现了数据连接的共享，不需要每一次都重新创建连接，节省了数据库的重新创建的开销
 */
class ConnectionPool {
	private Vector<Connection> pool;
	// 共有属性-------------内部状态。。。
	private String url = "jdbc:mysql://localhost:3306/test";
	private String username = "root";
	private String password = "root";
	private String driverClassName = "com.mysql.jdbc.Driver";
	private int poolSize = 100;
	private ConnectionPool instance = null;
	private Connection conn = null;

	// 构造方法-----做一些初始化工作
	private ConnectionPool() {
		pool = new Vector<Connection>(poolSize);
		for (int i = 0; i < poolSize; i++) {
			try {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 返回连接池
	public synchronized Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}
}