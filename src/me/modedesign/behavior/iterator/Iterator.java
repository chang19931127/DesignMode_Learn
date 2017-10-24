package me.modedesign.behavior.iterator;

/*
 * iterator ������ģʽ -----�ֽ���������ģʽ----�ֽ����α�ģʽ
 * �������Ϊģʽ
 * -----������֮��Ĺ�ϵ
 * 
 * ������ģʽ������˼�����˳����ʾۼ��еĶ���һ����˵�������зǳ�����������Լ�����Ƚ�
 * ��Ϥ�Ļ�����Ȿģʽ��ʮ������
 * ��Ҫ����������˼:
 * 							1����Ҫ�����Ķ��󣬼��ۼ�����
 * 							2���������������ڶԾۼ�������б������ʡ�
 * 								Iterator                                        Collection
 * 								previous()									iterator()
 * 								next()											get()
 * 								hasNext()										size()
 * 								first()												|
 * 									|													|
 * 									|													|
 * Test------------>		MyIterator	--------------->			MyCollection
 * 								Collection collection					String[] string
 * 								int pos                        				
 * 													��Ӧ��ʵ�ַ���
 * 
 * ��ӿڣ��ۼ��Ľӿ��ṩ�޸ľۼ�Ԫ�صķ���
 * խ�ӿڣ��ۼ��Ľӿ�û���ṩ�޸ľۼ�Ԫ�صķ���
 * 
 * ����ۼ����ṩ��ӿڵľۼ����ǰ���ۼ������ƻ��ۼ�����ķ�װ��
 * ����ۼ���ͬʱ��֤�ۼ�����ķ�װ�͵����ӹ��ܵ�ʵ��
 * �α�����ӣ��ۼ��Լ�ʵ�ֵ����߼�-�������ṩ�ӿڣ�ʹ�õ����ӿ��Դ��ⲿ���ƾۼ�Ԫ�صĿ��ơ�Ҳ�ͽ�����һ���α�
 * ���������ӣ����������ھۼ��ṹ֮��ġ�������˵�ۼ��ṹ��û�е����ӣ�
 * ���������ӣ��������ھۼ��ṹ�ڲ�����Ҳ�������е����ӿ�������ʵ�ֵ������ܣ�
 * 
 * �ͻ��˿��Ƶ����ӵĽ��̾���-----����������-������Ǳ���������
 * 
 * ���Ǻ� ������ģʽ���кܶ���ʵ�ַ�ʽ��
 * 					����ۼ�������������
 * 					����ۼ�������������
 * 
 * Fail Fast����һ����̬������������ʱ�򣬼��ϱ��޸��ˣ����ʱ��������̾ͻ�������ͻ��׳��쳣 checkForComodification����
 * 
 * �����Ӿ����н��
 * ����ģ���¼��Ϻ͵�����	
 * ����������Ӿ�ģ����һ��������Ĺ��̣����еİ����Լ��������ְ�
 * 
 * java�Ե�����ģʽ��֧��
 * Collection�ӿ� List�ӿ� Set�ӿ� Map�ӿ�
 * Iterator�ӿ�ListIterator�ӿ�
 * 
 */
public class Iterator {
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator1 it = collection.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//�������ӿ�
interface Iterator1{
	//ǰ��
	public Object previous();
	//����
	public Object next();
	public boolean hasNext();
	//��ȡ��һ��Ԫ��
	public Object first();
}
//���Ͻӿ�
//���һ���ۼ��Ľӿ��ṩ�˿��������޸ľۼ�Ԫ�صķ���������ӿھ�����ν�Ŀ�ӿ�
//�������խ�ӿ�
interface Collection{
	public Iterator1 iterator();
	//��ȡ����Ԫ��
	public Object get(int i);
	public int size();
}
//����ʵ����
class MyCollection implements Collection{
	public String[] string= {"A","B","C","D","E"};
	@Override
	public Iterator1 iterator() {
		return new MyIterator(this);
	}
	@Override
	public Object get(int i) {
		return string[i];
	}
	@Override
	public int size() {
		return string.length;
	}
}
//������ʵ����
class MyIterator implements Iterator1{
	private Collection collection;
	private int pos = -1;
	public MyIterator(){};
	public MyIterator(Collection collection) {
		this.collection=collection;
	}
	@Override
	public Object previous() {
		if(pos >0){
			pos--;
		}
		return collection.get(pos);
	}
	@Override
	public Object next() {
		if(pos < collection.size()-1){
			pos++;
		}
		return collection.get(pos);
	}
	@Override
	public boolean hasNext() {
		if(pos < collection.size()-1){
			return true;
		}
		return false;
	}
	@Override
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}	
}