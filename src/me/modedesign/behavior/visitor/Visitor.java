package me.modedesign.behavior.visitor;

/*
 * 访问者模式（Visitor）
 * 		对象的行为模式：目的就是为了封装一些施加于某种数据结构元素之上的操作。就是操作有变化，但是数据结构绝对不能变
 * 		针对对象聚集出现的模式-----------	同一对象---迭代模式                 			操作相同
 * 																不同对象---考虑访问者模式			不同对象操作不同
 * 										这里所说的数据结构，就是不同对象的数据结构，Subject 例如 人里面        ！有男人和女人
 * 																							易变的算法是在Visitor中生命
 * 																							增加新的操作就是增加新的Visitor
 * 	
 * 		访问者模式把数据结构和作用于结构上的操作解耦合，使得操作集合可相对自由的演化。访问者模式适用于数据
 * 结构相对稳定算法又易变化的系统。因为访问者模式使得算法操作增加变得容易。若系统数据结构对象易于变化，经常有
 * 新的数据对象增加进来，则不适合使用访问者模式。
 * 简单的说，访问者模式就是一种离散对象数据结构与行为的方法，通过这种分离，可达到为一个被访问者动态添加新的操作
 * 而无需做其它的修改的效果。
 * 
 * 
 * 				Test------------------------------------------>O------------------------------------------------------------->O(多个)
 * 																		Subject(数据结构稳定)											Visitor
 * 																		accept()																	visit()
 * 																	getSubject()																		|
 * 																			|																				|
 * 																			|																				|
 * 																		MySubject																MyVisit
 * 																accept(Visitor visitor)														visit()
 * 																		getSubject()				
 * 										意思就是一个对象	接受一个访问者来访问自己,执行一种操作
 * 																		接受另一个访问者来访问自己执行另一种操作
 * 																		就是这个Visitor是一个聚集。。。。
 * 										访问者模式是在Subject的数据结构稳定的情况下，Visitor的visit方法操作易变的时候使用
 * 
 * 
 * 优点：增加操作容易，因为增加操作意味着增加新的访问者。 访问者模式将有关行为集中到一个访问者对象中，其改变不影响系统数据结构
 * 缺点：增加新的数据结构很困难
 * 
 * 该模式的适用场景：如果我们想为一个现有的类增加新功能，不得不考虑几个事情：	
 * 						1，新功能会不会与现有功能出现兼容性问题？
 * 						2，以后会不会再需要添加？
 * 						3，如果类不允许修改代码怎么办？
 * 		面对这些问题，最好的解决方法就是使用访问者模式，访问者模式适合数据结构相对稳定的系统，把数据结构和算法解耦
 */
public class Visitor {
	public static void main(String[] args) {
		VisitorDemo visitor = new MyVistior();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}
}
//Visitor接口
interface VisitorDemo{
	void visit(Subject sub);
	//这里有多个Visitor方法   只是 访问的Subject 不同 可以 传入子类参数
	/*
	 void visit(SubjectA sub);
	 void visit(SubjectB sub);
	 void visit(SubjectC sub);
	 这里的方法个数是固定的-------因为数据结构稳定
	 */
}
//Visitor实现类，要存放访问的对象
class MyVistior implements VisitorDemo{
	@Override
	public void visit(Subject sub) {
		System.out.println("visit the subject : " +sub.getSubject());
		//这里就是可经常变动的操作了，或者追加新的Visitor对象来 通过增加类来扩展逻辑
	}
}
//Subject接口
interface Subject{
	void accept(VisitorDemo visitor);
	String getSubject();
}
//Subject类，accept方法，接受将要访问它的对象，getSubject()获得将要被访问的属性
class MySubject implements Subject{
	@Override
	public void accept(VisitorDemo visitor) {
		visitor.visit(this);
	}
	@Override
	public String getSubject() {
		return	"love";
	}
	
}










