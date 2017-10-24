package me.modedesign.structure.decorate;

/*
 * װ��ģʽ
 * װ��ģʽ����ʹ�ñ�װ�����һ�������ʵ�����ڿͻ��˽���������ʵ������װ����--------�Ǽ̳е������ʽ
 * 
 * �е㣺ʹ��װ��ģʽ�������ṩ�ȼ̳и���������չ����Ĺ��ܣ����Զ�̬����Ӷ���Ĺ��ܣ�Ҳ��������������Щ����
 * ȱ�㣺����Ϊ����������ϣ����Ծͻ����һЩ��������߼�
 * ͨ���������ú��˽���װ��ģʽ----------jdk��ʹ��װ��ģʽ�ľ������ǵ�IO��
 */
public class Decorate {
	public static void main(String[] args) {
		//��̬
		Phone p = new IPhone();
		p.call();
		System.out.println("**********************************");
		//�������ڽӵ绰֮ǰ��������
		PhoneDecorate pd = new RingPhoneDecorate(p);//�������װ����p����
		pd.call();
		System.out.println("**********************************");
		//��������ӵ绰֮������ѧ
		pd = new MusicPhoneDecorate(p);
		pd.call();
		System.out.println("**********************************");
		//���������ռ��ڽ���ǰ�����ᣬ�Ӻ�������
		//������ᣬ�����Լ�ʹ��װ�Σ�Ȼ��װ�� ----�Ѿ�װ�εĶ���
		pd = new RingPhoneDecorate(new MusicPhoneDecorate(pd));
		pd.call();
		System.out.println("**********************************");
//		����IO�еĲ�����io����ʹ�õ���װ��ģʽ������װ�Σ���ǿ����
//
//		InputStream is = System.in;
//		InputStreamReader isr = new InputStreamReader(is);
//		BufferedReader br = new BufferedReader(isr);
	}
}

// ����ӿ�
interface Phone {
	void call();
}

// �ӿ�ʵ����
class IPhone implements Phone {

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("IPhone�ֻ����Դ�绰��");
	}

}

// ����װ����----���������һ��װ����
// װ�������ӵ�� ��װ����Ķ���-----------Ȼ�����Ӧ�ķ��������޸�
abstract class PhoneDecorate implements Phone {

	private Phone e;

	public PhoneDecorate(Phone e) {
		this.e = e;
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		this.e.call();
	}

}

// �����װ����
class RingPhoneDecorate extends PhoneDecorate {

	public RingPhoneDecorate(Phone e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		System.out.println("����ֻ����������� ");
		super.call();
	}

}

// �����װ����
class MusicPhoneDecorate extends PhoneDecorate {

	public MusicPhoneDecorate(Phone e) {
		super(e);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		super.call();
		System.out.println("����ֻ�����������");
	}

}