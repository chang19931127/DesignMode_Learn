package me.modedesign.behavior.mediator;

/*
 * 	中介者模式(Mediator) 中间人
 * 				对象的行为模式，中介者模式包装了一系列对象相互作用的方式，使得这些对象不必互相明显引用。
 * 	中介者模式是用来降低类类之间的耦合的，因为如果类类之间有依赖关系的话，不利于功能的扩展和维护
 * 因为只要修改一个对象，其他关联的对象都得到修改。如果使用中介者模式，只需关心和Mediator类的关系，
 * 具体类类之间的关系及调度交给Mediator就行，这有点像spring容器的作用
 * Mediator 管理 User
 * 一大堆User对象十分混乱，又被称为同事对象，他们之间有有一些相互作用，当使用Mediator后，同事对象
 * 不再互相作用，反而只和Mediator对象发生关系，一切听从Mediator
 * 
 * 例如中国加入WTO就可以用这个模式解释！！！！！！！！！嘿嘿，很多国家通过WTO来进行模拟
 * 			Test------------------------------------------>O<-----------------------------------------User
 * 																															Mediator mediator
 * 																	Mediator											abstract void work()
 * 															---------------------
 * 																void createMeditor()
 * 																void workAll()
 * 																		|
 * 																		|
 * 																MyMediator											
 * 																User user1		---------------------------->	User1			User2
 * 																User user2		---------------------------->	work()			work()
 * 																void createMediator()								|
 * 																void workAll()________________________|
 * User类统一接口，User1和User2分别是不同的对象，二者之间有关联，如果不采用中介者模式，
 * 则需要二者相互持有引用，这样二者的耦合度很高，为了解耦，引入Mediator类，提供统一的接口，
 * MyMediator是实现类，持有User1和User2的实例，用来对User1和User2的控制。这样User1和User2
 * 两个对象相互独立，他们只需要保持好和Mediator之间的关系就行，剩下的交给MyMediator类来维护
 * 
 * 																		
 */
public class Mediator {
	public static void main(String[] args) {
		MediatorDemo mediator  = new MyMediator();
		mediator.createMediator();
		mediator.workAll();
	}
}
//中介者抽象接口
interface MediatorDemo{
	void createMediator();
	void workAll();
}
//中介者具体类
class MyMediator implements MediatorDemo{
	private User user1;
	private User user2;
	public User getUser1() {
		return user1;
	}
	public User getUser2() {
		return user2;
	}
	@Override
	public void createMediator() {
		user1 = new User1(this);
		user2 = new User2(this);
	}
	@Override
	public void workAll() {
		user1.work();
		user2.work();
	}
} 
//抽象类
abstract class User{
	private MediatorDemo mediator;
	public MediatorDemo getMediator(){
		return mediator;
	}
	public User(MediatorDemo mediator){
		this.mediator = mediator;
	}
	public abstract void work();
}
class User1 extends User{
	public User1(MediatorDemo mediator){
		super(mediator);
	}
	@Override
	public void work() {
		System.out.println("user1 exe!!");
	}
}
class User2 extends User{
	public User2(MediatorDemo mediator){
		super(mediator);
	}
	@Override
	public void work() {
		System.out.println("user2 exe!!");
	}
}

