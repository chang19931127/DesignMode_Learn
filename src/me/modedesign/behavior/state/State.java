package me.modedesign.behavior.state;

/*
 * ״̬ģʽ state    �ֳ�״̬����ģʽ----��Ϊģʽ
 * 		״̬ģʽ����һ�������ڲ�״̬�ı��ʱ��ı�����Ϊ�����������ȥ�����Ǹı���������һ��
 * 
 * ����˼�룺�������״̬�ı�ʱ��ͬʱ�ı�����Ϊ���ܺ���⣡����QQ��˵���м���״̬�����ߣ�����æµ��
 * ÿ��״̬��Ӧ��ͬ�Ĳ�����������ĺ���Ҳ���Կ������״̬������״̬ģʽ�����㣺		
 * 				1������ͨ���ı�״̬����ò�ͬ����Ϊ
 * 				2����ĺ�����ͬʱ������ı仯
 * 
 * 				Test--------------------------> Context-------------------------->State
 * 														State state;								String value
 * 														method()									method1()
 * 																										method2()
 * 
 * 
 * 
 * 																										ConcreteState
 * �������ͼ������һ���򵥵�״̬ģʽ---����ֱ��ͨ���޸ĵ��õķ�����ģ��״̬�ĸı䣬��ʵ�����
 * ���ǻᴴ������һ������״̬��ɫ-----����״̬��ɫ������øı䡣����
 * ��˼����Contextӵ��һ��State(����ӿ�)  Ȼ��һЩConcreteState(����״̬)�����е���
 * 
 * 			
 * �ܽ᣺״̬ģʽ���ճ��������õ�ͦ�������������վ��ʱ��������ʱϣ�����ݶ����ĳһ���ԣ�
 * �������ǵ�һЩ���ܣ�����˵�򵥵�Ȩ�޿��ơ�	
 * 
 * ʲô�����ʹ��״̬ģʽ
 * 			1��һ���������Ϊ��������������״̬���������Ϊ����������״̬�ĸı���ı䡣
 * 			2��������ĳ��������������һ�ػ���ص�����ת����䣬�����д����Ĵ��롣״̬ģʽ������ת�����ĵ�ÿһ����֧����װ��һ������
 * �������ʹ����Щ����ת�Ʒ�֧�ܹ�����ķ����������ں��ݻ���ά���ಢ��Ӱ��ϵͳ�������֡�
 * 
 * 
 * һ��״̬ģʽ��Ӧ������ ��   TCP
 * 	TcpConnection�����кܶ�״̬��1���ѽ������ӡ�2��������3���رա�TcpState
 * TcpConnection���ݻ�����ɫ--------------------------����TcpState����״̬��ɫ(����)(TcpClosed,TcpEstablished����)
 * ����
 * 
 * 
 * 
 * 
 * �ǲ��Ǹо�����ģʽ��״̬ģʽ������111111111111111�������������������
 */
public class State {
	public static void main(String[] args) {
		StateDemo state = new StateDemo();
		Context context = new Context(state);
		state.setVlaue("state1");// ���õ�һ��״̬
		context.method();
		state.setVlaue("state2");// ���õڶ���״̬
		context.method();
	}
}

// ״̬��ĺ�����
class StateDemo {
	private String vlaue;

	public String getVlaue() {
		return vlaue;
	}

	public void setVlaue(String vlaue) {
		this.vlaue = vlaue;
	}

	public void method1() {
		System.out.println("execute the first opt !");
	}

	public void method2() {
		System.out.println("execute the second opt!");
	}
}

// ״̬ģʽ���л���
class Context {
	private StateDemo state;

	public Context(StateDemo state) {
		super();
		this.state = state;
	}

	public StateDemo getState() {
		return state;
	}

	public void setState(StateDemo state) {
		this.state = state;
	}

	public void method() {
		if (state.getVlaue().equals("state1")) {
			state.method1();
		} else if (state.getVlaue().equals("state2")) {
			state.method2();
		}
	}
}
/*
//������ɫ
class TcpConnection {
	private TcpState state;
	public void open(){
		state.open();
	}
	public void setState(TcpState state){
		this.state = state;
	}
	public void close(){
		state.close();
	}
	public void acknowledge(){
		state.acknowledge();
	}
}
//����״̬��ɫ
interface TcpState {
	void open();
	void close();
	void acknowledge();
}
//����״̬��ɫ
class TcpEstablished implements TcpState {
	@Override
	public void open() {
		// write you code here
	}
	@Override
	public void close() {
		// write you code here
	}
	@Override
	public void acknowledge() {
		// write you code here
	}
}
*/