package me.modedesign.behavior.template;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * ģ��ģʽ--------һ����Ϊ��ģ�巽��ģʽ---ͨ���������㶨��
 * -----����������Ĺ�ϵ
 * ���ڳ������
 * ģ�巽��ģʽ���Ƕ���һ���㷨�ĹǼܣ�����������㷨���쵽��������ʵ��
 * ģ�巽��ģʽ�������Ϊģʽ��׼��һ�������࣬�������߼��Ծ��巽���Լ����幹��������ʽʵ��
 * Ȼ������һЩ���󷽷�����ʹ����ʵ��ʣ����߼�����ͬ����������Բ�ͬ�ķ�ʽʵ����Щ���󷽷�
 * �Ӷ���ʣ����߼��в�ͬ��ʵ�֣������ģ�巽��ģʽ������
 * 
 * һ���������У���һ�����������ڶ���1...n�������������ǳ���ģ�Ҳ������ʵ�ʵģ�����һ���࣬�̳иó����࣬����д���󷽷���ͨ�����ó����࣬ʵ�ֶ�����ĵ���
 * 											test--------------------------->AbstractCalculator(calculate(),split())
 * 																						/										\
 * 																					  /										  \
 *  * 																				/										        \
 * 																			Plus(calculate()							Minus(calculate())
 * ���ͣ�--������AbstractCalculator���ж���һ��������calculate,calculate()����split()   Plus��Minus�ֱ�̳�AbstractCalculator�࣬ͨ����AbstractCalculator
 * �ĵ���ʵ�ֶ�����ĵ���
 * 
 * HttpServlet������������ģ��ģʽ
 * AbstractTableModel��
 * ʹ�ó�����
 * 
 * 
 * �ŵ㣺ʹ��ģ�巽��ģʽ���ڶ����㷨�Ǽܵ�ͬʱ�����Ժ�����ʵ�־�����㷨�������û���������
 * ȱ�㣺����㷨�Ǽܽ����޸ĵĻ�����Ҫ�޸ĳ������� 
 */
public class Template {
	public static void main(String[] args) {
		/*
		 * �����ʹ����ģ��ģʽ----������һ����ŵ��㷨��������ͬ���㷨����ȥ����ʵ�־ͺ�
		 * ���õ�ʱ�򣬴���������޸ģ�ֱ�ӹ�����ǳ�����  ���е��ã������˶�̬����������
		 */
		GetTime  ct = new ForDemo();
		long getTime = ct.getTime();
		System.out.println(getTime);
		ct = new IODemo();
		getTime = ct.getTime();
		System.out.println(getTime);
	}
}

/*
 * �������󣺼���һ�δ��������ʱ��--------------Ҳ�����ṩ��ģ��(template)
 */
abstract class GetTime {
	//ģ�巽�����������������������һ���γ�һ�����㷨��һ������Ϊ�ķ���
	public long getTime() {
		long start = System.currentTimeMillis();
		code();
		long end = System.currentTimeMillis();
		return end - start;
	}
	//��������
	public abstract void code();
}

/*
 * ����̳���ģ�� �ĳ����࣬����д�˷���
 */
class ForDemo extends GetTime{

	@Override
	public void code() {
		// TODO Auto-generated method stub
		for (int i = 0; i <100000; i++) {
			System.out.println(i);
		}
	}	
}

/*
 * ����̳���ģ��ĳ����࣬ͬ����д�˷���
 */
class IODemo extends GetTime{

	@Override
	public void code() {
		// TODO Auto-generated method stub
		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		try {
			bis = new BufferedInputStream(new FileInputStream("c:/demo/I'm going home.mp3"));
			bos = new BufferedOutputStream(new FileOutputStream("c:/demo/a.txt"));
			byte[] bys = new byte[1024];
			int len;
			while((len = bis.read(bys))!=-1){
				bos.write(bys, 0, len);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(bis != null || bos != null){
				try {
					bis.close();
					bos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}