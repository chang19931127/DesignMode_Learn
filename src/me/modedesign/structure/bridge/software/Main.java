package me.modedesign.structure.bridge.software;

/*
 * ������������---------------���
 * 											�ֻ�Ʒ��
 * 						��ͬ���ֻ�Ʒ�ƣ�ӵ�е����Ҳ��ͬ����ˣ�����ͨ��
 * 		�Ž�ģʽ�������м̳еķ��룬��ʹ�� �ֻ�Ʒ��ӵ������������� �� ����ܶ�
 * 		����������һ���µ������ֻ��дһ������࣬�Ϳ�����
 * 		����������һ���µ��ֻ�Ʒ�ƣ�ͬ��дһ��Ʒ���࣬��û��������
 * 		�ܺ���չ
 * 
 * 
 * 		��Ҫ����ʹ�ü̳У��е�ʱ��ʹ����ϣ����߾ۺ����𵽸��õ����ã�����������
 * 
 * 	�Ž�ģʽ�������󲿷�������ʵ�ֲ��ַ��룬ʹ���Ƕ����Զ����ı仯��
 * 				���� �ֻ����ǳ��󲿷֣��������ʵ�ֲ���
 * 			
 */
public class Main {
	public static void main(String[] args) {
		HandSetBrand ab;
		ab = new HandSetBrandN();
		ab.setSoft(new HandSetGame());
		ab.run();
		ab.setSoft(new HandSetAddressList());
		ab.run();

		ab = new HandSetBrandM();
		ab.setSoft(new HandSetGame());
		ab.run();
		ab.setSoft(new HandSetAddressList());
		ab.run();
	}
}
