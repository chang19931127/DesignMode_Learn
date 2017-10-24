package me.modedesign.structure.flyweight;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Vector;

/*
 * Flyweightģʽ---��Ԫģʽ
 * 		��Ԫģʽ�Ƕ���Ľṹģʽ����Ԫģʽ�Թ���ķ�ʽ��Ч��֧�ִ�����ϸ���ȶ���
 * 		��Ԫ��������������Ĺؼ�����������״̬(Internal State)������״̬(External State)
 * 																			Ҳ�����ڲ�״̬���ⲿ״̬---������������
 * 		һ������״̬�Ǵ洢����Ԫ�����ڲ��ģ������ǲ����滷���ı�������ı�ģ����һ����Ԫ���Ծ�������״̬�����Թ���
 * 		һ������״̬���滷���ı���ı�ģ������Թ����״̬����Ԫ���������״̬�����ɿͻ��˱��棬������Ԫ���󱻴���֮��
 * ����Ҫʹ�õ�ʱ���ٴ��뵽��Ԫ�����ڲ���
 * ����״̬��Ӱ������״̬���������໥������
 * 
 * 
 * ��Ԫģʽ����ҪĿ����ʵ�ֶ���Ĺ���������أ���ϵͳ�ж�����ʱ����Լ����ڴ�Ŀ�����-----ͨ���빤��ģʽһ��ʹ��
 * 					FlyWeightFactor    ----------------------------->FlyWeight
 * 								|														|				|
 * 								|													|				         |
 * 							Client											FlyWeight   		 FlyWeight2
 * FlyWeightFactory���𴴽��͹�����Ԫ��Ԫ����һ���ͻ�������ʱ��������Ҫ��鵱ǰ��������Ƿ��з��������Ķ���
 * ����У��ͷ��ش��ڵĶ���
 * ���û�У��ʹ���һ���µĶ��� 						FlyWeight�ǳ���
 * һ�ᵽ����أ���Ȼ���뵽jdbc���ӳأ��Ϳ����ܽ���ص㣬���е����ԣ���˾��ʺ�����Ԫģʽ�����������Ϳ��Լ���ʵ��������
 * ����--------ģ�����ݿ����ӳص�����ConnectionPool
 * 
 * ����-java�����У�String���;���ʹ���ˣ���Ԫģʽ��
 * ��װ��     -128 ��127 Ҳʹ������Ԫģʽ   �Լ�boolean ��"true"��"false"
 * 
 * ��Ԫģʽ��ʹ������
 * 		һ��ϵͳ�д����Ķ���
 * 		��Щ����ķѴ������ڴ�
 * 		��Щ�����״̬�еĴ󲿷ֶ������ⲿ��
 * 		��Щ������԰�������״̬�ֳɺܶ��飬�������̶���Ӷ������޳�ʱ��ÿһ�鶼���Խ�����һ���������
 * 		���ϵͳ����������Щ�������ݣ�����֮����Щ��������ǲ��ɷֱ��
 * 
 * �ŵ㣺����ȵĽ����ڴ��ж��������
 * ȱ�㣺ʹϵͳ���Ӹ��ӣ�Ϊ��ʹ������Թ�����Ҫ��һЩ״̬�ⲿ����ʹ�ö�ȡ�ⲿ״̬����ʱ����΢�䳤
 */
public class Flyweight {
	public static void main(String[] args) {
		// ����һ����Ԫ��������
		FlyWeightFactory factory = new FlyWeightFactory();
		// ����Ԫ������������һ������״̬Ϊ"a"����Ԫ����
		FlyWeightDemo fly = factory.factory(new Character('a'));
		// �Բ�����ʽ����һ������״̬
		fly.operation("First Call");
		// ����Ԫ������������һ������״̬Ϊ'b'����Ԫ����
		fly = factory.factory(new Character('b'));
		// �Բ�����ʽ����һ������״̬
		fly.operation("Second Call");
		// ����Ԫ������������һ������״̬Ϊ'a'����Ԫ����
		fly = factory.factory(new Character('a'));
		// �Բ�����ʽ����һ������״̬
		fly.operation("Third Call");
		/*		
		 * ����������������Ԫ���󣬵���ʵ���ϴ�������Ԫ����ֻ������������ǹ���ĺ���
		 */
		factory.checkFlyWeight();
	}
}
// ����ӿ� FlyWeight
abstract class FlyWeightDemo {
	// һ��ʾ���Եķ���������state������״̬
	//����״̬     ������ε��ṩ����Ϊ������״̬
	public abstract void operation(String state);
}

// ������Ԫ��ɫ------------------��Ԫ������������ͨ����������
class ConcreteFlyWeight extends FlyWeightDemo {
	//������Ϊ������״̬�ṩ�洢�ռ�---------����������Ǵ洢���ڲ�״̬
	private Character intrinsicState = null;

	// ������������״̬��Ϊ��������
	public ConcreteFlyWeight(Character state) {
		this.intrinsicState = state;
	}

	@Override
	//�������state������״̬�����
	public void operation(String state) {
		System.out.println("\nIntrinsic State =" + intrinsicState
				+ ",Extrinsic State= " + state);
	}
}

class FlyWeightFactory {
	private HashMap files = new HashMap();
	private FlyWeightDemo lnkFlyWeight;
	// ������
	public FlyWeightFactory() {
	}
	//����״̬��Ϊ��������
	//�ֱ��浽���ϻ���������(��һ������洢����)��ʹ��keyֵ��ɸѡ�Ƿ��Ѿ�����
	public FlyWeightDemo factory(Character state) {
		if (files.containsKey(state)) {
			return (FlyWeightDemo) files.get(state);
		} else {
			FlyWeightDemo fly = new ConcreteFlyWeight(state);
			files.put(state, fly);
			return fly;
		}
	}

	// ��������
	public void checkFlyWeight() {
		FlyWeightDemo fly;
		int i = 0;
		System.out.println("\n=========checkFlyWeight()=======");
		for (Iterator it = files.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry e = (Entry) it.next();
			System.out.println("Item " + (++i) + ":" + e.getKey());
		}
		System.out.println("=============checkFlyWeight============");
	}
}

/*------------------------------------------------------------------------------------------------------------------------------------------------------------
 * �������
 * ���ӳع���ʵ�����������ӵĹ�������Ҫÿһ�ζ����´������ӣ���ʡ�����ݿ�����´����Ŀ���
 */
class ConnectionPool {
	private Vector<Connection> pool;
	// ��������-------------�ڲ�״̬������
	private String url = "jdbc:mysql://localhost:3306/test";
	private String username = "root";
	private String password = "root";
	private String driverClassName = "com.mysql.jdbc.Driver";
	private int poolSize = 100;
	private ConnectionPool instance = null;
	private Connection conn = null;

	// ���췽��-----��һЩ��ʼ������
	private ConnectionPool() {
		pool = new Vector<Connection>(poolSize);
		for (int i = 0; i < poolSize; i++) {
			try {
				Class.forName(driverClassName);
				conn = DriverManager.getConnection(url, username, password);
				pool.add(conn);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// �������ӳ�
	public synchronized Connection getConnection() {
		if (pool.size() > 0) {
			Connection conn = pool.get(0);
			pool.remove(conn);
			return conn;
		} else {
			return null;
		}
	}
}