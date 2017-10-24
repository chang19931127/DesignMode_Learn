package me.modedesign.behavior.strategy;

import javax.xml.stream.events.StartElement;

/*
 * ��Ϊģʽ
 * 		����������Ĺ�ϵ
 * 				����ģʽ��strategy��
 * ����ģʽ������һϵ���㷨������ÿ���㷨��װ������ʹ���ǿ����໥ת�������㷨�ı仯����Ӱ�쵽ʹ���㷨���û���
 * ��Ҫ���һ���ӿڣ�Ϊһϵ��ʵ�����ṩͳһ�ķ��������ʵ����ʵ�ָýӿڣ����һ��������(���п��ޣ����ڸ�����),�ṩ��������
 * 
 * 													�ͻ���---------------->�����Ĳ��Խӿ�-----(�����Ĳ�����)
 * 																			|					|					|
 * 																			|					|					|
 * 																			|					|					|
 * 																	ʵ�ֲ���һ  ʵ�ֲ��Զ�  ʵ�ֲ�����
 * 
 * 
 * ����ģʽ�ľ���Ȩ���û���ϵͳ�����ṩ��ͬ�Ĳ���ʵ�֣���ɾ�ȣ����Բ��Խ��з�װ����˲���ģʽ�������㷨����ϵͳ�У��ⲿ�û�ֻ��Ҫ�����Ǹ��㷨�ͺ�
 * ����ģʽ�������ڿͻ����ڼ����㷨��ѡ��һ�ֵ����Ρ�
 * 
 * ���ӣ� ���ﳵ�е��ۿۼ���---����ʹ�ò���ģʽ
 * 				java��AWT�е�LayoutManager
 * 											BorderLayout
 * 											FlowLayout
 * 											GridBagLayout	
 * 											CardLayout��������
 * 
 * �ŵ㣺
 * 			1������ģʽ�ṩ�˹���ϵ�Ǹ��ܵ��㷨�������
 * 			2������ģʽ�ṩ�˿����滻�̳й�ϵ�İ취������ӵ�в��������У�
 * 			3�����ò���ģʽ���Ա���ʹ�ö�������ת�����
 * ȱ�㣺
 * 			1���ͻ��˱���֪�����еĲ����࣬�����о���ʹ����һ��������
 * 			2������ģʽ��ɺܶ�Ĳ�����
 */
public class Strategy {
	public static void main(String[] args) {
		String exp="2+8";
		ICalulator cal = new Plus();
		int result = cal.calculate(exp);
		System.out.println("\t"+result);
		// ת��б��"\"
	}
}
//ͳһ�Ľӿ�
interface ICalulator{
	public int calculate(String exp);
}
//�����࣬Ϊ��ĳЩ�㷨����һЩ����
abstract class AbstractCalculate{
	public int[] spilt(String exp,String opt){
		String[] array= exp.split(opt);
		int[] arrayInt = new int [2];
		arrayInt[0]=Integer.parseInt(array[0]);
		arrayInt[1]=Integer.parseInt(array[1]);
		return arrayInt;
	}
}
//������������ʵ����---���û���ô������
class Plus extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt =spilt(exp, "\\+");
		return arrayInt[0] + arrayInt[1];
	}
}
class Minus extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt =spilt(exp, "-");
		return arrayInt[0] - arrayInt[1];
	}
}
class Multiply extends AbstractCalculate implements ICalulator{
	@Override
	public int calculate(String exp) {
		int[] arrayInt = spilt(exp, "\\*");
		return arrayInt[0] * arrayInt[1];
	}
}


//��������������������������������������������������������������������������������������������������������������

//һ��ӵ�л����Ĳ���ģʽ
//����
class Context{
	private Strategy1 strategy;
	//���Է���
	public void contextInterface(){
		strategy.strategyInterface();
	}
}
//����ͳһ����ӿ�
abstract class Strategy1{
	//���Է���
	public abstract void strategyInterface();
}
//����ʵ�ֲ���
class ConcreteStrategy1 extends Strategy1{
	@Override
	public void strategyInterface() {
	//����Ĳ���	
	}
}
