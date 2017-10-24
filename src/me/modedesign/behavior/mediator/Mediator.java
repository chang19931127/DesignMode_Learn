package me.modedesign.behavior.mediator;

/*
 * 	�н���ģʽ(Mediator) �м���
 * 				�������Ϊģʽ���н���ģʽ��װ��һϵ�ж����໥���õķ�ʽ��ʹ����Щ���󲻱ػ����������á�
 * 	�н���ģʽ��������������֮�����ϵģ���Ϊ�������֮����������ϵ�Ļ��������ڹ��ܵ���չ��ά��
 * ��ΪֻҪ�޸�һ���������������Ķ��󶼵õ��޸ġ����ʹ���н���ģʽ��ֻ����ĺ�Mediator��Ĺ�ϵ��
 * ��������֮��Ĺ�ϵ�����Ƚ���Mediator���У����е���spring����������
 * Mediator ���� User
 * һ���User����ʮ�ֻ��ң��ֱ���Ϊͬ�¶�������֮������һЩ�໥���ã���ʹ��Mediator��ͬ�¶���
 * ���ٻ������ã�����ֻ��Mediator��������ϵ��һ������Mediator
 * 
 * �����й�����WTO�Ϳ��������ģʽ���ͣ������������������ٺ٣��ܶ����ͨ��WTO������ģ��
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
 * User��ͳһ�ӿڣ�User1��User2�ֱ��ǲ�ͬ�Ķ��󣬶���֮���й���������������н���ģʽ��
 * ����Ҫ�����໥�������ã��������ߵ���϶Ⱥܸߣ�Ϊ�˽������Mediator�࣬�ṩͳһ�Ľӿڣ�
 * MyMediator��ʵ���࣬����User1��User2��ʵ����������User1��User2�Ŀ��ơ�����User1��User2
 * ���������໥����������ֻ��Ҫ���ֺú�Mediator֮��Ĺ�ϵ���У�ʣ�µĽ���MyMediator����ά��
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
//�н��߳���ӿ�
interface MediatorDemo{
	void createMediator();
	void workAll();
}
//�н��߾�����
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
//������
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

