package me.modedesign.behavior.iterator.buyticket;

public class ConcreteIterator extends Iterator {

	private ConcreteAggregate aggregate;
	private int current = 0;
	
	
	
	public ConcreteIterator(ConcreteAggregate aggregate) {
		super();
		this.aggregate = aggregate;
	}

	@Override
	public Object first() {
		return aggregate.index(current);
	}

	@Override
	public Object next() {
		Object ret = null;
		current++;
		if(current < aggregate.count()){
			ret = aggregate.index(current);
		}
		return ret ;
	}

	@Override
	public boolean isDone() {
		return current >= aggregate.count() ? true : false;
	}

	@Override
	public Object currentItem() {
		return aggregate.index(current);
	}

}
