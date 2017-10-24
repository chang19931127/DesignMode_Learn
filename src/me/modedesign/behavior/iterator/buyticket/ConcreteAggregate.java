package me.modedesign.behavior.iterator.buyticket;

import java.util.ArrayList;
import java.util.List;

public class ConcreteAggregate extends Aggregate {

	private List<Object> items = new ArrayList<Object>();
	
	
	@Override
	public Iterator creatIterator() {	
		return new ConcreteIterator(this);
	}
	
	public int count(){
		return items.size();
	}

	public Object index(int indes){
		return items.get(indes);
	}

	public void setItems(List<Object> items) {
		this.items = items;
	}
	
	
	
}
