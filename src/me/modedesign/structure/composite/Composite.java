package me.modedesign.structure.composite;

import java.util.Enumeration;
import java.util.Vector;

/*
 * ���ģʽ----�ϳ�ģʽ----����-����ģʽ
 * �������������νṹ�������ʱ��ȽϷ��㡣�����������������벿�ֵĹ�ϵ
 * �ص㣺�ϳ�ģʽ����ʹ�ͻ��˽�����Ԫ���븴��Ԫ��ͬ�ȿ���
 * 
 * 
 * uml                                           Component(�ڵ�ĳ���)
 * 																�����ķ���()
 * 													|										|
 * 												ʵ��									  ʵ��
 * 												Leaf								Composite--ӵ��-Component
 * 												��������---add---remove---��
 * 									��������������Ĺ���-----����͸��ģʽ------��ΪLeaf��Composite�����в�����������ȫ
 * 									Composite������Ĺ���-----���ǰ�ȫģʽ----��ΪLeafû�в�������---Composite���������
 * 
 * ʹ�ó����������������ϵ�һ����в��������������νṹ�У����������������
 *�ļ�ϵͳ-----���͵ĺϳ�ģʽϵͳ
 *
 *java    AWT���ʹ�õ������ģʽ(��ȫ��ʽ�ĺϳ�ģʽ)------Component
 *															�ֳ�Container�ຬ��Component��
 *															������Button��Checkbox��������
 *																		   
 */
public class Composite {
	public static void main(String[] args) {
		Tree tree = new Tree("A");
		TreeNode nodeB=new TreeNode("B");
		TreeNode nodeC=new TreeNode("C");
		nodeB.add(nodeC);
		tree.root.add(nodeB);
		System.out.println("build the tree finished     A---->B----->C");
	}
}
//��֦
class TreeNode{
	private String name;
	private TreeNode parent;
	private Vector<TreeNode> children = new Vector<TreeNode>();
	public TreeNode(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setName(String name){
		this.name=name;
	}
	public TreeNode getParent(){
		return parent;
	}
	public void setParent(TreeNode parent){
		this.parent=parent;
	}
	//��Ӻ���
	public void add(TreeNode node){
		children.add(node);
	}
	//ɾ������
	public void remove(TreeNode node){
		children.remove(node);
	}
	//ȡ�ú��ӽڵ�
	public Enumeration<TreeNode> getChildren(){
		return children.elements();
	}
}
//���ģʽ������---ͬʱ������ĸ����Ǹ���
class Tree{
	TreeNode root = null;//ӵ�и���
	public Tree(String name){
		root = new TreeNode(name);
	}
}