package me.modedesign.behavior.memento;

/*
 * Memento ����¼ģʽ ---����ģʽ(Snapshot Pattern) ��Tokenģʽ
 * ���״̬----
 * 				(����¼ģʽ)	��ҪĿ���Ǳ���һ�������ĳ��״̬���Ա����ʵ���ʱ��ָ����󣬸��˾��ý�������ģʽ������Щ��
 * ͨ�׵Ľ��£�������ԭʼ��A��A���и������ԣ�A���Ծ�����Ҫ���ݵ����ԣ�����¼B�����洢A��һЩ�ڲ�״̬����C�᣿����һ������
 * �洢����¼�ģ���ֻ�ܴ洢�������޸ĵȲ�����
 * 
 * ��������������������������������������
 * ����¼ģʽ���������ڲ��ƻ���װ����������£���һ�������״̬��ץ�������ⲿ�����洢������
 * �Ӷ����ڽ������ʵ�ʱ����������ԭ���洢������״̬��
 * �����ӻ���ܺ����-----------
 * �����˽�ɫ(Originator)------------------------����¼��ɫ(Memento)----------------�����˽�ɫ(Storage)
 * 
 * 
 * 							Test--------------------------------------------------------------------------	|
 * 								|																								|
 * 								|																								|
 * 								|																								|
 * 							Original----------------------->Memento<-------------------------- Storage
 * 						String value						String value								Memento memento
 * 				Memento createMemento()
 * �������һ��-----Original����ԭʼ�࣬������һ����Ҫ���������value������һ������¼�࣬
 * ��������valueֵ��Memento���Ǳ���¼�࣬Storage���Ǵ洢����¼�࣬����Memento���ʵ����
 * Ӧ�þͺܺ������---A��Ҫ���ݣ�������B������-----C�������B��������ã����ǲ����޸�
 * 
 * 
 * 
 * 
 * ͬ���ڵ�����ģʽ�У������˽⵽��խ�ӿڣ���������Ҫ��ϰһ��
 * 		��ӿڣ��ṩ�޸��ڲ�Ԫ�صķ����Ľӿڣ��ͽ�����ӿ�
 * 		խ�ӿڣ����ṩ�޸��ڲ�Ԫ�صķ����Ľӿڣ��ͽ���խ�ӿ�
 * java��ʵ�ֱ���¼ģʽ��ʱ��ͬʱʵ�֡�����խ���ӿ��ǲ����׵ġ�
 * ������Կ�խ�ӿ�---����ʵ�֣���ӿڣ��Ǹ����ʵ�ֽ���������ʵ�֡�---------������ʾ�ĳ�����ǰ���ʵ��
 * 
 * 
 * 
 * 
 * 		����¼ģʽ��ͬʱ���ÿ�ӿں�խ�ӿ�ʵ�֡������������ӿ�
 * ��ô������Ҫ֪�����ǣ��������javaͬʱʵ�֡���ӿڡ�����խ�ӿڡ���
 * 			Ҳ���Ǹ�˫�ӿ�             Wide                                  Narrow               �����ӿ�
 * 												operation1						��ʾ�ӿ�
 * 												operation2
 * 			1��һ���������˫�ؽӿ�-------����ܼ򵥣�����ʵ����˫�ӿڣ�������
 * 			2���Բ�ͬ�����ṩ��ͬ�Ľӿ� --------�������Ҫһ�������е�����----�ڲ���ܺý��
 * 	������ʹ��java��ʵ�ֱ���¼ģʽ���ǡ��ں�ʵ�֡�----ʹ�������ཫ���װ��
 * 								���������ʵ���᣿
 * 							��ʵ�ڲ������   Memento�����    ��������ṩһ����ǽӿ�---�������˽�ɫʹ��
 * 						������һ������������-----------��������ʷ��ģʽ
 * 
 */
public class Memento {
	//���Բ鿴main�������ֲ�û���Լ�����Memento����Ҳ����˵      ԭʼ����ֱ�Ӻͱ���¼�Ӵ�
	//��Ϊ�����ṩ�Ľӿ��޸����ڲ����ԣ�������ﱻ����������ʵ�֡�
	//ʵ���ϡ�����ʵ�֡��ƻ��˶���ķ�װ����Ϊ�����Կ��Ա����㣡
	//���ֿ���ʵ�ֱ���¼ģʽ����ؼ�����
	public static void main(String[] args) {
		//����ԭʼ����
		Original original = new Original("banana");
		//��������¼---------��Storage����¼������һ��original�����ı���
		Storage storage = new Storage(original.createMemento());
		System.out.println("��ʼ��״̬Ϊ------��" + original.getValue());
		//���޸�ԭʼ״̬
		original.setValue("apple");
		System.out.println("�޸ĺ��״̬Ϊ-------��" + original.getValue());
		//�ص�ԭʼ״̬
		original.restoreMemento(storage.getMemento());
		System.out.println("�ָ����״̬Ϊ------" + original.getValue());

	}
}
//ԭʼ����-------���Բ������������ҿ������õ�����
class Original {
	//��Ҫ����������
	private String value;

	public Original(String value) {
		this.value = value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
	//��������---����һ���µı���¼����
	public MementoDemo createMemento() {
		return new MementoDemo(value);
	}
	//�������˻ָ�������¼���������ص�״̬
	public void restoreMemento(MementoDemo memento) {
		this.value = memento.getValue();
	}
}
//��������---���Դ洢 ��Ҫ����������
class MementoDemo {
	private String value;

	public MementoDemo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}
}
//����¼------����һ������
class Storage {
	//���б���
	private MementoDemo memento;

	public Storage(MementoDemo memento) {
		this.memento = memento;
	}

	public MementoDemo getMemento() {
		return memento;
	}

	public void setMemento(MementoDemo memento) {
		this.memento = memento;
	}
}

/*
 * ****************************************************************************************************************************
 * ͬʱʵ�֡���ӿڡ���խ�ӿڡ�
 */
//�����ӿ�
interface Wide{
	void operation1();
	void operation2();
}
interface Narrow{
	//����ӿ��ڱ���¼ģʽ�д������Memento�����ı�ʾ�ӿ�    ����� ���ڲ��� Memento��ʵ�֣�����װ
}
/*
 * ��һ�ֿ���
 * 
 * 									User------------------> interface        	interface<-----------------Other
 * 																		Wide				Narrow
 * 																	operation1()     	��ǽӿ�
 * 																	operation2()
 * 																			^							^
 * 																			|							|
 * 																			|							|
 * 																					ConcertClass   ʵ�ֶ�������һ����
 * 																					operation1()
 * 																					operation2()
 * 								���Կ���ConcertClass�������ش�
 * 
 */																
 
class User{
	//�ڶ��ֿ���
	//һ���ڲ�������,�ڲ���ConcreteClass�����Wide����ӿ�    ���仰˵���ǿ���ʡ��Wide�ӿ�
	//�����������õĽ��������������������Ҳ����˵ConcerteClass����౻�ɹ���װ
	class ConcreteClass implements Narrow {
		private void operation1(){
			System.out.println("operation1()");
		}
		private void operation2(){
			System.out.println("operation2()");
		}
	}
	//�������������ṩ�ڲ����ʵ��
	public Narrow getConcreteClass(){
		return (Narrow) new ConcreteClass();
	}
}








