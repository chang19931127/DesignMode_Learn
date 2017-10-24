package me.modedesign.structure.bridge;

/*
 * �Ž�ģʽ-         ����ģʽ(Handle and Body)-�ӿ�ģʽ----Bridge
 * �������
 * 				���󻯣������ڶ��ʵ���еĹ�ͬ�ĸ�������ϵ�����ǳ���
 * 				ʵ�ֻ������󻯸����ľ���ʵ�֣�����ʵ�ֻ�
 * 				�������ʵ�����Ϊ��ĳ��ǿ�������������ǵ�ǿ����ȥ�������ǽ���
 * 							�̳���ǿ������ϵ���ۺ�ʱ��������ϵ���Ƽ�ʹ�þۺϣ�������
 * 
 * �Ž�ģʽ���ǰ�����;���ʵ�ַֿ���ʹ���ǿ��Ը��Զ����ı仯��
 * �Žӵ������ǣ���������ʵ�ֻ����ʹ�ö��߿��Զ����仯�������ǳ��õ�JDBC��DriverManagerһ����
 * JDBC�������ݿ����ӵ�ʱ���ڸ������ݿ�֮������л�����������Ҫ̫��Ĵ��룬����˿�����ö���
 * ԭ�����JDBC�ṩ��ͳһ�Ľӿڣ�ÿ�����ݿ��ṩ���Ե�ʵ�֣���һ���������ݿ������ĳ������ŽӾ����ˣ�
 * 
 * ����ģʽ��ʹ�ó�����
 * 			���һ��ϵͳ��Ҫ�ڹ����ĳ��󻯽�ɫ�;��廯��ɫ֮�����������
 * 			���Ҫ��ʵ�ֻ���ɫ���κθı䲻Ӱ��ͻ���
 * 			һ�������ж�����󻯽�ɫ��ʵ�ֻ���ɫ
 * 			
 * 
 * 
 * ���ӣ�
 * 			ͨ����Bridage1 �����ĵ��ã�ʵ���˶Խӿ�Sourceable��ʵ����SourceSub1��SourceSub2�ĵ���
 * 
 * ���������ӣ�JDBC��������ƹ���
 * 			Client------>DriverManager(�ӿڣ��������)-----�ۺ�---->Driver(�ӿ�)
 * 													
 * 												MysqlDriver          OracleDriver        DB2Driver
 */
public class Bridge {
	public static void main(String[] args) {
		Bridge1 bridge = new MyBridge();
		//���õ�һ������
		Sourceable source1 = new SourceSub1();
		bridge.setSource(source1);
		bridge.method();
		//���õڶ�������
		Sourceable source2 = new SourceSub2();
		bridge.setSource(source2);
		bridge.method();
	}
}
//����Ľӿ�-----------------ʵ�ֻ���ɫ�;���ʵ�ֻ���ɫ
interface Sourceable{
	void method();
}
//�ӿ�ʵ����1
class SourceSub1 implements Sourceable{
	@Override
	public void method() {
		System.out.println("this is the first sub!");
	}	
}
//�ӿ�ʵ����2
class SourceSub2 implements Sourceable{
	@Override
	public void method() {
		System.out.println("this is the second sub!");
	}	
}
//����--��----����Sourceable�ӿڵ�ʵ��(set,get)-------���󻯽�ɫ���������󻯽�ɫ
//���󻯽�ɫ������һ��ˮ�����ֱ�����ʵ�ֻ���ɫ������ˮ���ı���------------���Ǻ������塰������
abstract class Bridge1{
	private Sourceable source;//---������ھۺ�
	
	public Sourceable getSource() {
		return source;
	}

	public void setSource(Sourceable source) {
		this.source = source;
	}

	public void method(){
		source.method();
	}
}
//�������            ���������кܶ�
class MyBridge extends Bridge1{
	public void method(){
		getSource().method();
	}
}