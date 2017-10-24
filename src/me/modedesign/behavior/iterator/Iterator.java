package me.modedesign.behavior.iterator;

/*
 * iterator 迭代器模式 -----又叫做迭代子模式----又叫做游标模式
 * 对象的行为模式
 * -----类与类之间的关系
 * 
 * 迭代器模式，顾名思义就是顺序访问聚集中的对象，一般来说，集合中非常常见，如果对集合类比较
 * 熟悉的话，理解本模式会十分轻松
 * 主要包含两层意思:
 * 							1，需要遍历的对象，即聚集对象
 * 							2，迭代器对象，用于对聚集对象进行遍历访问。
 * 								Iterator                                        Collection
 * 								previous()									iterator()
 * 								next()											get()
 * 								hasNext()										size()
 * 								first()												|
 * 									|													|
 * 									|													|
 * Test------------>		MyIterator	--------------->			MyCollection
 * 								Collection collection					String[] string
 * 								int pos                        				
 * 													对应的实现方法
 * 
 * 宽接口：聚集的接口提供修改聚集元素的方法
 * 窄接口：聚集的接口没有提供修改聚集元素的方法
 * 
 * 白箱聚集：提供宽接口的聚集就是白箱聚集（会破坏聚集对象的封装）
 * 黑箱聚集：同时保证聚集对象的封装和迭代子功能的实现
 * 游标迭代子：聚集自己实现迭代逻辑-并向外提供接口，使得迭代子可以从外部控制聚集元素的控制。也就仅仅是一个游标
 * 外禀迭代子：迭代子是在聚集结构之外的。（就是说聚集结构中没有迭代子）
 * 内禀迭代子：迭代子在聚集结构内部，（也就是所有迭代子可以自行实现迭代功能）
 * 
 * 客户端控制迭代子的进程就是-----主动迭代子-否则就是被动迭代子
 * 
 * 于是乎 迭代器模式就有很多种实现方式了
 * 					白箱聚集和外禀迭代子
 * 					黑箱聚集和内禀迭代子
 * 
 * Fail Fast：当一个动态迭代器迭代的时候，集合被修改了，这个时候迭代过程就会崩溃，就会抛出异常 checkForComodification方法
 * 
 * 迭代子就是中介层
 * 我们模拟下集合和迭代器	
 * 下面这个例子就模拟了一个集合类的过程，其中的奥妙自己慢慢发现把
 * 
 * java对迭代子模式的支持
 * Collection接口 List接口 Set接口 Map接口
 * Iterator接口ListIterator接口
 * 
 */
public class Iterator {
	public static void main(String[] args) {
		Collection collection = new MyCollection();
		Iterator1 it = collection.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}
}
//迭代器接口
interface Iterator1{
	//前移
	public Object previous();
	//后移
	public Object next();
	public boolean hasNext();
	//获取第一个元素
	public Object first();
}
//集合接口
//如果一个聚集的接口提供了可以用来修改聚集元素的方法，这个接口就是所谓的宽接口
//否则就是窄接口
interface Collection{
	public Iterator1 iterator();
	//获取集合元素
	public Object get(int i);
	public int size();
}
//集合实现类
class MyCollection implements Collection{
	public String[] string= {"A","B","C","D","E"};
	@Override
	public Iterator1 iterator() {
		return new MyIterator(this);
	}
	@Override
	public Object get(int i) {
		return string[i];
	}
	@Override
	public int size() {
		return string.length;
	}
}
//迭代器实现类
class MyIterator implements Iterator1{
	private Collection collection;
	private int pos = -1;
	public MyIterator(){};
	public MyIterator(Collection collection) {
		this.collection=collection;
	}
	@Override
	public Object previous() {
		if(pos >0){
			pos--;
		}
		return collection.get(pos);
	}
	@Override
	public Object next() {
		if(pos < collection.size()-1){
			pos++;
		}
		return collection.get(pos);
	}
	@Override
	public boolean hasNext() {
		if(pos < collection.size()-1){
			return true;
		}
		return false;
	}
	@Override
	public Object first() {
		pos = 0;
		return collection.get(pos);
	}	
}