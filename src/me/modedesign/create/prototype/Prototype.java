package me.modedesign.create.prototype;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/*
 * ԭ��ģʽ
 * ԭ��ģʽ�����ֿ��Կ�������ģʽ��˼����ǽ�һ��������Ϊԭ�ͣ�������и��ƣ���¡������һ����ԭ�������Ƶ��¶���
 */
public class Prototype {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Prototypes pro = new Prototypes();
		pro.setString("����");
		SerializableObject obj= new SerializableObject("�ܳ�");
		pro.setObj(obj);
		System.out.println("pro:"+pro.getString()+"---"+pro.getObj());
		Prototypes pro2 =new Prototypes(); 
		pro2.setString("�ƺ�");
		SerializableObject obj2= new SerializableObject("�ܻ�");
		pro2.setObj(obj2);
		System.out.println("pro2:"+pro2.getString()+"---"+pro2.getObj());
		Prototypes pro3 = new Prototypes();
		pro2 = (Prototypes) pro.clone();
		//������ǳ���ƣ����Կ�����������ֱ�ӹ����ģ���û���ظ�����һ���µ�
		System.out.println("ǳ����֮��----pro2��String��"+pro2.getString()+"---obj:"+pro2.getObj().getName());
		pro3 = (Prototypes) pro.deepClone();
		//��������ƣ����Կ��������ö�����ڣ�ͬʱ�����ö��������¹����
		System.out.println("���֮��----pro3��String��"+pro3.getString()+"---obj:"+pro3.getObj().getName());
		//����Ϳ��Կ�������֮��� ���� --------����ѡ���޸�pro������setObj
		obj.setName("ǳ���Ʋ��ˣ����ƵĶ���pro��Ӧ�ö���obj��ֵ���޸���");
		System.out.println("ǳ����֮��----pro2��String��"+pro2.getString()+"---obj:"+pro2.getObj().getName());
		System.out.println("���֮��----pro3��String��"+pro3.getString()+"---obj:"+pro3.getObj().getName());
		//������Եó�һ�����۾��� ǳ���ƵĶ�������ö���û����ȫ���ƣ�ֻ�Ǹ��Ƶ�������
	}
}

//ԭ����
/*
 * �ܼ�һ��ԭ���ֻ࣬��Ҫʵ��CLoneable�ӿڣ���дclone����(���﷽��������ν���Խ� clone1��Ҳ���Խ�clone2������һ����Ҫ���� super.clone()�����������)
 * Object.clone()������native�����������࿼��
 * 
 * �������clone����һ���ռ�֪ʶ
 * ǳ���ƣ�
 * 		��һ�������ƺ󣬻����������͵ı����������´���(����)������������ָ��Ļ���ԭ������ָ���
 * ��ƣ�
 * 		��һ�������ƺ󣬲����ǻ����������ͻ����������ͣ��������´����ġ�
 * �򵥵���˵����ƾ�����ȫ���׵ĸ��ƣ���ǳ���Ʋ�����
 * 
 * java���������඼��̳�һ������clone()�����������������������ʽǳ����
 */
class Prototypes implements Cloneable,Serializable{

	private static final long serialVersionUID = 881922500265594229L;
	
	private String string;
	
	private SerializableObject obj;
	
	//ǳ����
	@Override
	public Object clone() throws CloneNotSupportedException {
		Prototypes proto = (Prototypes) super.clone();
//		������������ ���룬ͨ������ ���ö��󣬴Ӷ��ﵽ���------------------������û��漰���ã���ô���Ǵ��л���ƱȽ�����
//		SerializableObject obj = (SerializableObject) proto.getObj().clone();
//		proto.setObj(obj);
		return proto;
	}
	
	//���
	/*
	 * �Ѷ���д������Ĺ����Ǵ��л�(Serialization)���̣������䶳
	 * ���Ѷ�������ж������Ĳ��л�(Deserialization)�Ĺ��̣������ⶳ
	 * java���������һ�����󣬳���������ʹ�ö���ʵ��Serializable�ӿڣ�Ȼ��Ѷ���д��һ������
	 * �ڴ�������������Ϳ����ؽ�����
	 */
	public Object deepClone() throws CloneNotSupportedException, IOException, ClassNotFoundException{
		//д�뵱ǰ����Ķ�������
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		//������������������¶���
		ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois = new ObjectInputStream(bis);
		return ois.readObject();
	}
	public String getString() {
		return string;
	}
	public void setString(String string) {
		this.string = string;
	}
	public SerializableObject getObj() {
		return obj;
	}
	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}
}

class SerializableObject implements Serializable,Cloneable{
	
	private String name;
	public SerializableObject() {
		super();
	}
	public SerializableObject(String name) {
		this.name = name;
	}
	private static final long serialVersionUID = 1L;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}
}

