package me.modedesign.structure.facade;

/*
 * Facadeģʽ�����ģʽ������ģʽ��������
 * ���ģʽ����Ϊ�˽��������֮���������ϵ����springһ�������Խ������֮��Ĺ�ϵ���õ������ļ��У������ģʽ���ǽ����ǵĹ�ϵ����һ��Facade����
 * ����������֮�����϶ȣ���ģʽû���漰���ӿڣ��ṹ����(�Լ��������������Ϊ���Ӳ���������ģʽ)
 * 
 * ����ģʽ�Ƕ���Ľṹģʽ���ⲿ��һ����ϵͳ��ͨ�ű���ͨ��һ��ͳһ�ģ��������棡�����������-------------------���������ģʽ
 * ���ǽ����ӵ�ϵͳ�ֶ���֮�������ĺô������޸�һ����ϵͳ������Ӱ��������ϵͳ���������Ǵ򽻵��Ķ�������ϵͳ�˶������������
 * 
 * �����ɫ���ͻ��˿��Ե��������ɫ�ķ������˽�ɫ֪��(��ص�һ�����߶��)��ϵͳ�Ĺ��ܺ����Ρ�
 * 				����������£�����ɫ���ᱻ�ͻ��˷���������ί�ɵ���Ӧ����ϵͳ��
 * ��ϵͳ��ɫ������ͬʱ��һ�����߶����ϵͳ��ÿһ����ϵͳ������һ���������࣬����һ����ļ��ϡ�
 * 				ÿ����ϵͳ�����Ա��ͻ�ֱ�ӵ��ã����������ɫ���ã���ϵͳ����֪������Ĵ��ڣ�������ϵͳ��˵�����������һ���ͻ���
 * 
 * 
 * �ܽᣬ���û��Computer�࣬��ô��cpu��memory��disk������֮�佫�ụ�����ʵ����������ϵ������Computer����࣬����֮��Ĺ�ϵ��������Computer��
 * �����˽������ã�
 * 
 * �ŵ㣺
 * 			Ϊ������ϵͳ�ṩһ���򵥽ӿڣ�Facadeģʽ�ṩһ���򵥵�Ĭ����ͼ
 * 			��ϵͳ�Ķ����ԣ���ϵͳ֮��û��������
 * 			��λ��ṹ��Facaedģʽ������ϵͳ��ÿһ������
 */
public class Facade {
	public static void main(String[] args) {
		Computer computer = new Computer();
		computer.startUp();
		System.out.println("---------------------------------------------------");
		computer.shutDown();
	}
}
//�ܹ� computer
class Computer{
	private CPU cpu;
	private Memory memory;
	private Disk disk;
	public Computer(){
		//���й���
		cpu = new CPU();
		memory = new Memory();
		disk = new Disk();
	}
	public void startUp(){
		System.out.println("start up computer");
		cpu.startUp();
		memory.startUp();
		disk.startUp();
		System.out.println("start computer finished");
	}
	public void shutDown(){
		System.out.println("begin to close the computer");
		cpu.shutDown();
		memory.shutDown();
		disk.shutDown();
		System.out.println("computer closed");
	}
}
//���cpu
class CPU{
	public void startUp(){
		System.out.println("cpu start");
	}
	public void shutDown(){
		System.out.println("cpu shutdown");
	}
}
//���memory
class Memory{
	public void startUp(){
		System.out.println("memory start");
	}
	public void shutDown(){
		System.out.println("memory shutdown");
	}
}
//���disk
class Disk{
	public void startUp(){
		System.out.println("disk startup");
	}
	public void shutDown(){
		System.out.println("disk shutdown");
	}
}