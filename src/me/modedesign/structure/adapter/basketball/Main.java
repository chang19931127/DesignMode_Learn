package me.modedesign.structure.adapter.basketball;

/*
 * �ͻ��˵���
 */
public class Main {
	public static void main(String[] args) {
		Player b = new Forwards("�͵ٶ�");
		b.Attrack();
		//������ԥҦ�� ����Ӣ�����Ա����������
		/*
		 * 
		 * ʵ���У����Ƕ���ͨ�������������죬Ҳ���������ǵĴ�ϵͳ�У�ͨ��adapter��������չ��
		 * ֻҪ ʵ�ֵķ�����ͨ��������õľ��п���
		 * 
		 * 
		 */
		Player m = new TranslatorAdapter("Ҧ��");
		m.Defense();
		
	}
}
