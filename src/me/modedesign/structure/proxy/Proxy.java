package me.modedesign.structure.proxy;

/*
 * ������
 * ��ʵÿ��ģʽ���ƾͱ����˸�ģʽ�����ã�����ģʽ���Ƕ�һ���������������Ԫ�������һЩ�������������ǳ�ȥ�ҷ��ӵ�ʱ���ҵ����н飬�н���Ǵ���
 * 
 * ����ģʽ��Ӧ�ó���
 * ������еķ�����ʹ�õ�ʱ����Ҫ��ԭ�еķ������иĽ�����ʱ�����ַ�����
 * 				-----1���޸�ԭ�еķ�������Ӧ������Υ���ˡ�����չ���ţ����޸Ĺرա���ԭ��
 * 				-----2�����ǲ���һ�����������ԭ�еķ������ҶԲ����Ľ�����п��ƣ����ַ������Ǵ���ģʽ
 * ʹ�ô���ģʽ���Խ����ܻ��ֵ������������ں���ά��
 * ����˵����ģʽ�ǶԱ��������   ʩ�ӿ��ƣ���������ǿ�书��(�����װ��ģʽ�ָ��)
 * 
 * jdk��̬����  Proxy    InvocationHandler  ��
 */
public class Proxy {
	public static void main(String[] args) {
		Sourceable source = new Proxy2();
		source.method();
	}
}
//������ͱ�������Ĺ����ӿڣ����߳�����---------��ͨ��Ҳ����
interface Sourceable{
	public void method();
}
//����Ǳ������࣬��Ҫ�������������չ����-------------------�����ಢû��ӵ�б��������-------װ��ģʽ��ӵ�еı�װ�ζ���
class Source implements Sourceable{
	@Override
	public void method() {
		System.out.println("this orginal method!");
	}
}
//����Ǵ����࣬�����������չ
class Proxy2 implements Sourceable{
	private Source source;
	public Proxy2() {
		super();
		this.source = new Source();
	}
	@Override
	public void method() {
		before();
		source.method();
		after();
	}
	private void before() {
		System.out.println("before proxy!");
	}
	private void after() {
	System.out.println("after proxy!");
	}
}