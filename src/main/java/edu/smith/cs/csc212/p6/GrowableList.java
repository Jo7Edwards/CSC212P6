package edu.smith.cs.csc212.p6;

import edu.smith.cs.csc212.p6.errors.EmptyListError;
//import edu.smith.cs.csc212.p6.errors.P6NotImplemented;
import edu.smith.cs.csc212.p6.errors.RanOutOfSpaceError;

public class GrowableList<T> implements P6List<T> {
	public static final int START_SIZE = 32;
	private Object[] array;
	private int fill;
	
	public GrowableList() {
		this.array = new Object[START_SIZE];
		this.fill = 0;
	}

	@Override
	public T removeFront() {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		return removeIndex(0);
	}

	@Override
	public T removeBack() {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		T value = this.getIndex(fill - 1);
		fill--;
		this.array[fill] = null;
		return value;
	}

	@Override
	public T removeIndex(int index) {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		T removed = this.getIndex(index);
		fill--;
		for (int i=index; i<fill; i++) {
			//Sets current equal to next! 
			this.array[i] = this.array[i+1];
		}
		this.array[fill] = null;
		return removed;
	}

	@Override
	public void addFront(T item) {
		//You don't want to have an error if it's an empty list, because you could 
		//want to add to an empty list! 
		//test that it's not going over it's length limit
		if (fill >= this.array.length) { 
			throw new RanOutOfSpaceError();
		}
		addIndex(item, 0);
	}

	@Override
	public void addBack(T item) {
		// I've implemented part of this for you.
		if (fill >= this.array.length) { 
			throw new RanOutOfSpaceError();
		}
		this.array[fill++] = item;
	}

	@Override
	/*
	 * This one is cool. You need to make a copy of the list from the point of index
	 * onward, so you end up of a duplicate of the object at the desired index, 
	 * and then you overwrite at the desired index with the desired item
	 * You make the copy list with a for loop that goes backwards 
	 */
	public void addIndex(T item, int index) {
		if (fill >= array.length) {
			throw new RanOutOfSpaceError();
		}
		// loop backwards, shifting items to the right.
		for (int j=fill; j>index; j--) {
			array[j] = array[j-1];
		}
		array[index] = item;
		fill++;
	}
	
	@Override
	public T getFront() {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		return this.getIndex(0);
	}

	@Override
	public T getBack() {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		return this.getIndex(this.fill-1);
	}

	/**
	 * Do not allow unchecked warnings in any other method.
	 * Keep the "guessing" the objects are actually a T here.
	 * Do that by calling this method instead of using the array directly.
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T getIndex(int index) {
		if (this.size() == 0) {
			throw new EmptyListError();
		}
		return (T) this.array[index];
	}

	@Override
	public int size() {
		return fill;
	}

	@Override
	public boolean isEmpty() {
		return fill == 0;
	}


}
