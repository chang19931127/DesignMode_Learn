package me.modedesign.create.builder.buildpeople;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;

//��Ϊ�ǽ���ģʽ�������Ҫһ��ָ�ӹ������н���
public class PersonDirector extends Frame{
	private PersonBuilder pb;

	public PersonDirector(PersonBuilder pb) {
		this.pb = pb;
	}
	
	/*
	 *	����������Լ����廭ͼ˳��
	 * java ��   ���Graphics �Ƚ�����
	 * 
	 */
	@Override
	public void paint(Graphics g) {
		pb.g = (Graphics2D) g;
		pb.buildHead();
		pb.buildBody();
		pb.buildArmLeft();
		pb.buildArmRight();
		pb.buildLegLeft();
		pb.buildLegRight();
	}
	
	public void createPerson(){
		this.setBounds(800, 800, 200, 200);
		this.setVisible(true);
	}
}
