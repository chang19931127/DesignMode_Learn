package me.modedesign.behavior.chainofresponsibily;

/*
 * ������ģʽ(Chain of Responsibility)
 * �������Ϊģʽ
 * -----������֮��Ĺ�ϵ
 * 			�ж������ÿ��������ж���һ����������ã������ͻ��γ�һ�������������������ϴ��ݣ�ֱ��ĳһ������������������
 * ���Ƿ����߲���������������Ǹ�����ᴦ����������ԣ�������ģʽ����ʵ�֣��������ͻ��˵�����£���ϵͳ���ж�̬�ĵ�����
 * 
 * 					�мɣ���������������������һ��ʱ�̣�����ֻ������һ�����󴫸���һ�����󣬶����������������
 * 
 * 									AbstractHandler--------------------------------------->Handler
 * 										Handler handler													--------
 * 											getHandler()														operation()
 * 											setHandler()												
 * 																\														/
 * 																	\												/
 * 																		\										/
 * 																			\								/
 * 																						MyHandler
 * 										Test------------------------->			--------	
 * 																								operation()
 * AbstractHandler���ṩ��get��set ����������MyHandler�����ú��޸����ö���MyHandler���Ǻ��ģ�ʵ����������һϵ���໥���еĶ���
 * ����һ������
 * 
 * �����벻����������ģʽ
 * 			һ������������ģʽҪ��һ������Ĵ����߶���ֻ����������Ϊ��ѡ��һ��
 * 												1��һ�ǳе����Ρ�
 * 												2�����ǰ������Ƹ���ҡ�       �������������
 * 			��һ������������ģʽ���棬һ��������뱻ĳһ�������߶���������
 * 			��һ��������������ģʽ�У�һ���������ղ����κν��ܶ������ܡ�
 * 			��ʵ�к����ҵ� ����������ģʽ
 * 
 * 	 ������ģʽ����������ķ��Ͷ˺ͽ��ܶ�֮�����ϣ�ʹ��������л��ᴦ���������
 * 
 * �������DOMģ���е��¼����������������ģʽ��
 * 	һ��һ��Ľ��У�������¼���ִ��
 * 
 * 
 * һ���򵥵�ʵ��-----------ֱ������ʵ��û���¼Ҿ�ִ�в���
 */
public class ChainOfResponsibily {
	public static void main(String[] args) {
		MyHandler h1 = new MyHandler("h1");
		MyHandler h2 = new MyHandler("h2");
		MyHandler h3 = new MyHandler("h3");
		h1.setHandler(h2);
		h2.setHandler(h3);
		//ֱ��ĳһ������������������
		h1.operator();
		//���ϵ����������һ������������һ��������������һ����--------
	}
}
//����ӿ�-------�����˲�������
interface Handler{
	void operator();
}
//���� �� --------�������� ��ģʽ���
abstract class AbstractHandler{
	private Handler handler;
	public Handler getHandler(){
		return handler;
	}
	public void setHandler(Handler handler){
		this.handler=handler;
	}
}
//������     ��Ҫʵ����Ҫ�̳�          ---------����Ԫ��Ҳ��ͨ������� ������
class MyHandler extends AbstractHandler implements Handler{
	private String name;
	public MyHandler(String name){
		this.name = name;
	}
	//ʵ���˷���---------��������������������ʽִ��
	@Override
	public void operator() {
		if(getHandler() !=null){
			//�����ƽ�
			System.out.println("the request is passed to" +getHandler());
			getHandler().operator();
		}else{
			System.out.println("the request is handler here");
		}
	}	
}



