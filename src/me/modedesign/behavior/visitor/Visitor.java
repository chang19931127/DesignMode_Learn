package me.modedesign.behavior.visitor;

/*
 * ������ģʽ��Visitor��
 * 		�������Ϊģʽ��Ŀ�ľ���Ϊ�˷�װһЩʩ����ĳ�����ݽṹԪ��֮�ϵĲ��������ǲ����б仯���������ݽṹ���Բ��ܱ�
 * 		��Զ���ۼ����ֵ�ģʽ-----------	ͬһ����---����ģʽ                 			������ͬ
 * 																��ͬ����---���Ƿ�����ģʽ			��ͬ���������ͬ
 * 										������˵�����ݽṹ�����ǲ�ͬ��������ݽṹ��Subject ���� ������        �������˺�Ů��
 * 																							�ױ���㷨����Visitor������
 * 																							�����µĲ������������µ�Visitor
 * 	
 * 		������ģʽ�����ݽṹ�������ڽṹ�ϵĲ�������ϣ�ʹ�ò������Ͽ�������ɵ��ݻ���������ģʽ����������
 * �ṹ����ȶ��㷨���ױ仯��ϵͳ����Ϊ������ģʽʹ���㷨�������ӱ�����ס���ϵͳ���ݽṹ�������ڱ仯��������
 * �µ����ݶ������ӽ��������ʺ�ʹ�÷�����ģʽ��
 * �򵥵�˵��������ģʽ����һ����ɢ�������ݽṹ����Ϊ�ķ�����ͨ�����ַ��룬�ɴﵽΪһ���������߶�̬����µĲ���
 * ���������������޸ĵ�Ч����
 * 
 * 
 * 				Test------------------------------------------>O------------------------------------------------------------->O(���)
 * 																		Subject(���ݽṹ�ȶ�)											Visitor
 * 																		accept()																	visit()
 * 																	getSubject()																		|
 * 																			|																				|
 * 																			|																				|
 * 																		MySubject																MyVisit
 * 																accept(Visitor visitor)														visit()
 * 																		getSubject()				
 * 										��˼����һ������	����һ���������������Լ�,ִ��һ�ֲ���
 * 																		������һ���������������Լ�ִ����һ�ֲ���
 * 																		�������Visitor��һ���ۼ���������
 * 										������ģʽ����Subject�����ݽṹ�ȶ�������£�Visitor��visit���������ױ��ʱ��ʹ��
 * 
 * 
 * �ŵ㣺���Ӳ������ף���Ϊ���Ӳ�����ζ�������µķ����ߡ� ������ģʽ���й���Ϊ���е�һ�������߶����У���ı䲻Ӱ��ϵͳ���ݽṹ
 * ȱ�㣺�����µ����ݽṹ������
 * 
 * ��ģʽ�����ó��������������Ϊһ�����е��������¹��ܣ����ò����Ǽ������飺	
 * 						1���¹��ܻ᲻�������й��ܳ��ּ��������⣿
 * 						2���Ժ�᲻������Ҫ��ӣ�
 * 						3������಻�����޸Ĵ�����ô�죿
 * 		�����Щ���⣬��õĽ����������ʹ�÷�����ģʽ��������ģʽ�ʺ����ݽṹ����ȶ���ϵͳ�������ݽṹ���㷨����
 */
public class Visitor {
	public static void main(String[] args) {
		VisitorDemo visitor = new MyVistior();
		Subject sub = new MySubject();
		sub.accept(visitor);
	}
}
//Visitor�ӿ�
interface VisitorDemo{
	void visit(Subject sub);
	//�����ж��Visitor����   ֻ�� ���ʵ�Subject ��ͬ ���� �����������
	/*
	 void visit(SubjectA sub);
	 void visit(SubjectB sub);
	 void visit(SubjectC sub);
	 ����ķ��������ǹ̶���-------��Ϊ���ݽṹ�ȶ�
	 */
}
//Visitorʵ���࣬Ҫ��ŷ��ʵĶ���
class MyVistior implements VisitorDemo{
	@Override
	public void visit(Subject sub) {
		System.out.println("visit the subject : " +sub.getSubject());
		//������ǿɾ����䶯�Ĳ����ˣ�����׷���µ�Visitor������ ͨ������������չ�߼�
	}
}
//Subject�ӿ�
interface Subject{
	void accept(VisitorDemo visitor);
	String getSubject();
}
//Subject�࣬accept���������ܽ�Ҫ�������Ķ���getSubject()��ý�Ҫ�����ʵ�����
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










