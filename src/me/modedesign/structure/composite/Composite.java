package me.modedesign.structure.composite;

import java.util.Enumeration;
import java.util.Vector;

/*
 * 组合模式----合成模式----整体-部分模式
 * 处理类似于树形结构的问题的时候比较方便。可以用来描述整体与部分的关系
 * 特点：合成模式可以使客户端将单纯元素与复合元素同等看待
 * 
 * 
 * uml                                           Component(节点的抽象)
 * 																公共的方法()
 * 													|										|
 * 												实现									  实现
 * 												Leaf								Composite--拥有-Component
 * 												操作子类---add---remove---等
 * 									公共方法有子类的管理-----就是透明模式------因为Leaf和Composite都含有操作方法不安全
 * 									Composite有子类的管理-----就是安全模式----因为Leaf没有操作能力---Composite有子类操作
 * 
 * 使用场景，将多个对象组合到一起进行操作，常用于树形结构中，例如二叉树，数等
 *文件系统-----典型的合成模式系统
 *
 *java    AWT库就使用的是组合模式(安全形式的合成模式)------Component
 *															分成Container类含有Component类
 *															其它类Button，Checkbox。。。。
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
//树枝
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
	//添加孩子
	public void add(TreeNode node){
		children.add(node);
	}
	//删除孩子
	public void remove(TreeNode node){
		children.remove(node);
	}
	//取得孩子节点
	public Enumeration<TreeNode> getChildren(){
		return children.elements();
	}
}
//组合模式的整体---同时，整体的根就是个体
class Tree{
	TreeNode root = null;//拥有个体
	public Tree(String name){
		root = new TreeNode(name);
	}
}