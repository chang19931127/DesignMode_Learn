package me.modedesign.behavior.template;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 模板模式--------一般认为是模板方法模式---通过方法来搞定的
 * -----父类与子类的关系
 * 基于抽象类的
 * 模板方法模式就是定义一个算法的骨架！而将具体的算法延伸到子类中来实现
 * 模板方法模式是类的行为模式，准备一个抽象类，将部分逻辑以具体方法以及具体构造器的形式实现
 * 然后声明一些抽象方法来迫使子类实现剩余的逻辑。不同的子类可以以不同的方式实现这些抽象方法
 * 从而对剩余的逻辑有不同的实现，这就是模板方法模式的用意
 * 
 * 一个抽象类中，有一个主方法，在定义1...n个方法，可以是抽象的，也可以是实际的，定义一个类，继承该抽象类，并重写抽象方法，通过调用抽象类，实现对子类的调用
 * 											test--------------------------->AbstractCalculator(calculate(),split())
 * 																						/										\
 * 																					  /										  \
 *  * 																				/										        \
 * 																			Plus(calculate()							Minus(calculate())
 * 解释：--就是在AbstractCalculator类中定义一个主方法calculate,calculate()调用split()   Plus和Minus分别继承AbstractCalculator类，通过对AbstractCalculator
 * 的调用实现对子类的调用
 * 
 * HttpServlet技术就是用了模板模式
 * AbstractTableModel类
 * 使用场景：
 * 
 * 
 * 优点：使用模板方法模式，在定义算法骨架的同时，可以很灵活的实现具体的算法，满足用户灵活的需求
 * 缺点：如果算法骨架进行修改的话，就要修改抽象类了 
 */
public class Template {
	public static void main(String[] args) {
		/*
		 * 这里就使用了模板模式----定义了一个大概的算法，其他不同的算法子类去具体实现就好
		 * 调用的时候，代码很容易修改，直接管理的是抽象类  进行调用，利用了多态！！！！！
		 */
		GetTime  ct = new ForDemo();
		long getTime = ct.getTime();
		System.out.println(getTime);
		ct = new IODemo();
		getTime = ct.getTime();
		System.out.println(getTime);
	}
}

/*
 * 这是需求：计算一段代码的运行时间--------------也就是提供了模板(template)
 */
abstract class GetTime {
	//模板方法：将基本操作方法组合在一起形成一个总算法或一个总行为的方法
	public long getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}
	//基本方法
	public abstract void code();
}

/*
 * 这里继承了模板 的抽象类，并复写了方法
 */
class ForDemo extends GetTime{

	@Override
	public void code() {
		// TODO Auto-generated method stub
		for (int i = 0; i <100000; i++) {
			System.out.println(i);
		}
	}	
}

/*
 * 这里继承了模板的抽象类，同样复写了方法
 */
class IODemo extends GetTime{

	@Override
	public void code() {
		// TODO Auto-generated method stub
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("c:/demo/I'm going home.mp3"));
			bos = new BufferedOutputStream(new FileOutputStream("c:/demo/a.txt"));
			byte[] bys = new byte[1024];
			int len;
			while((len = bis.read(bys))!=-1){
				bos.write(bys, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bis != null || bos != null){
				try {
					bis.close();
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}