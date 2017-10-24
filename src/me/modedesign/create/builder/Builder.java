package me.modedesign.create.builder;

/*
 * ������ģʽ
 * -----����ģʽ���Խ�һ����Ʒ���ڲ��������Ʒ�����ɹ��̷ָ�����Ӷ�����ʹһ�������������
 * 
 * ����ģʽ����һ���������߶��󣡺;��壡�����߶���һ��һ���ؽ�������е�������Ӷ������
 * ���е�������������������̣��ѶԽ�����̽���ָ�ӵ����κ;��彨������������ηָ����
 * �ﵽ���λ��ֺͷ�װ��Ŀ��
 * ��������Ƕ���Ҳ��������ɳɷ�
 * 
 * �漰�Ľ�ɫ
 * -----�������߽�ɫ
 * -----���彨���߽�ɫ
 * -----�����߽�ɫ-------------------��ͻ��˽�ͨ��
 * -----��Ʒ��ɫ
 * 
 * ʲôʱ��ʹ�ý�����ģʽ
 * 1����Ҫ���ɵĲ�Ʒ�����и��ӵ��ڲ��ṹ
 * 2����Ҫ���ɵĲ�Ʒ����������໥����
 * 3���ڶ��󴴽�������ʹ�õ�ϵͳ��������һЩ����
 * 
 * --------------����Ӧ�ý���С��
 * ������---��Ҫ���죨ͷ�����壬���֣����֡������������������Щ�������һ��(��)��Ʒ
 * ��������Ĳ�ͬ�����²�Ʒ��ͬ ������ǽ���ģʽ������
 * ��һ����Ʒ��Ҫ�ܶ�������빹���ʱ��---ʹ�ý����߾���һ�ֲ�Ʒ�����죬ʹ��ָ�ӹ������ý�����
 * 
 * JavaMail �е�Message ��MimeMessage���� �����˻��Ľ�����ģʽ��Ӧ��
 */
public class Builder {
	public static void main(String[] args) {
		//�ͻ���ֱ�Ӳ��� �����ߣ�Ȼ����õ����ߵ� �����Ʒ����
		Director director = new Director();
		director.construct();
		
		System.out.println("----------------------------------------");
		//Ҳ���Ժ��Ե�����
		Builders builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		Product product = builder.retrieveResult();
	}
}
//�����߽�ɫ
class Director{
	private Builders builder;
	//�����������Ҫ����������ǣ���Ʒ���췽����������ø������-������Ʒ
	public void construct(){
		builder = new ConcreteBuilder();
		builder.buildPart1();
		builder.buildPart2();
		builder.retrieveResult();
		//continue with other code
	}
}
//�������߽�ɫ
abstract class Builders{
	//���һ
	public abstract void buildPart1();
	//�����
	public abstract void buildPart2();
	public abstract Product retrieveResult();
}
//����Ľ����߽�ɫ----------�����ӵĻ������ߣ��������������Ҫ���죬������벻ͨ��
class ConcreteBuilder extends Builders{
	private Product product = new Product();

	@Override
	public void buildPart1() {
		// TODO Auto-generated method stub
		//builder the first part of the produce
		System.out.println("�������һ");
	}

	@Override
	public void buildPart2() {
		// TODO Auto-generated method stub
		//builder the second part of the produce
		System.out.println("���������");
	}

	@Override
	public Product retrieveResult() {
		// TODO Auto-generated method stub
		System.out.println("��Ʒ�Ѿ��õ�"+product);
		return product;
	}
	
}
//��Ʒ��ɫ-------------------��������ж����Ʒ���Ϳ��Գ�����ӿ�
class Product{
	//Anything pertaining to this product
	//builderPart1----builderPart2
	//������Ҫע����ǣ���Ʒ������������ģ���Щ���ȱһ����
}