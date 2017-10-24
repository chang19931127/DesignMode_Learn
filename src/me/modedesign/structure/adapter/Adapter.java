package me.modedesign.structure.adapter;

/*
 * ������ģʽ��
 * ��ĳ����Ľӿ�ת���ɿͻ�������������һ���ӿڡ�
 * Ŀ�ģ����������ڽӿڲ�ƥ������ɵ���ļ������⡣
 * ��Ҫ��Ϊ���ࣺ
 * 				-----���������ģʽ 
 * 											��ϣ����һ����ת����������һ���½ӿڵ���ʱ����ʹ�����������ģʽ������һ�����࣬�̳�ԭ�е��࣬ʵ���µĽӿ�
 * 				-----�����������ģʽ
 * 											��ϣ����һ������ת����������һ���½ӿڵĶ���ʱ�����Դ���һ��Wrapper�����ԭ���һ��ʵ������Wrapper��ķ����е��ø�ʵ���ķ���
 * 				-----�ӿڵ�������ģʽ
 * 											����ϣ��ʵ��һ���ӿ��е����з�����ʱ�����ǿ��Դ���һ�������Wrapper�࣬��ʵ�����з�����������д������ʱ�򣬼̳г�����Ϳ�����
 * ������ģʽ�������ǽ��ӿڲ�ͬ��������ͬ��������������ӿڼ���ת��
 * 
 * ʲô�����ʹ��������ģʽ
 * 		1��ϵͳ��Ҫʹ�����е��࣬������Ľӿڲ�����ϵͳ����Ҫ
 * 		2����Ҫ����һ�������ظ�ʹ�õ��࣬������һЩ�˴�֮��û��̫�������һЩ�࣬����һЩ�����ڽ�����������������������ЩԴ�಻һ���кܸ��ӵĽӿڡ�
 * 		3�����Զ����������ģʽ���ԣ���������Ҫ�ı������е�����ӿڣ����ʹ�����������ģʽ����Ҫ���ÿһ��������һ���������࣬�������̫ʵ��
 * 
 * Iterator ������ʹ���� ������ģʽ-------���䵽Enumeration     	ʹ�õ��Ƕ����������ģʽ
 * 
 * 
 * 
 * ����һ��ģʽȱʡ����ģʽ---------����������˵��        				
 * 	WindowAdapter			 �¼�������ʹ�õ�Ҳ�ǱȽ϶��				ʹ�õ��ǽӿڵ�������ģʽ
 * xml��������    XMLProperties��xml�ӿ������java.util.Properties����    SAX
 * 
 */
public class Adapter {
	public static void main(String[] args) {
		//���������ģʽ����
		Targetable target = new Adapter1();
		target.method1();
		target.method2();
		//�����������ģʽ����
		Source source = new Source();
		Targetable target2 = new Wrapper(source);
		target2.method1();
		target2.method2();
		//�ӿڵ�������ģʽ����
		Targetable target3A = new SourceSub1();
		Targetable target3B= new SourceSub2();
		target3A.method1();
		target3A.method2();
		target3B.method1();
		target3B.method2();
	}
}
//�������࣬ӵ��һ������
class Source{
	public void method1(){
		System.out.println("this is original method");
	}
}
//����Ŀ��ӿ�
interface Targetable{
	//��Ԫ�෽����ͬ
	public void method1();
	//����ķ���
	public void method2();
}
//�������࣬�̳д������࣬ʵ������ӿ�-----------------���������ģʽ
//����Targetable�ӿڵ�ʵ����;�����Source��Ĺ���
class Adapter1 extends Source implements Targetable{
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetable method");
	}
}
class Wrapper implements Targetable{
	private Source source;
	public Wrapper(Source source) {
		super();
		this.source = source;
	}
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		source.method1();
	}
	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("this is targetable method");
	}
}
//��������ͨ��һ�������࣬��ԭ�ӿڵķ��� �ȿ�ʵ��
abstract class Wrapper2 implements Targetable{
	@Override
	public void method1() {System.out.println("method1()��ʵ��");}
	@Override
	public void method2() {System.out.println("method2()��ʵ��");}	
}
class SourceSub1 extends Wrapper2{
	@Override
	public void method1() {
		System.out.println("thr sourceable interface's first sub1");
	}	
}
class SourceSub2 extends Wrapper2{
	@Override
	public void method2() {
		System.out.println("thr sourceable interface's second sub2");
	}	
}