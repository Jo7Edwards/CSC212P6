package edu.smith.cs.csc212.p6;

import java.util.Iterator;

import edu.smith.cs.csc212.p6.errors.BadIndexError;
import edu.smith.cs.csc212.p6.errors.EmptyListError;
//import edu.smith.cs.csc212.p6.errors.P6NotImplemented;
//import edu.smith.cs.csc212.testlab.Node;

public class SinglyLinkedList<T> implements P6List<T>, Iterable<T> {
	/*
	 * Why does addFront have no problem adding to front and then moving 
	 * whatever else was there back, but then add index it doesn't work like that? 
	 */
	/**
	 * The start of this list. Node is defined at the bottom of this file.
	 */
	Node<T> start;

	@Override
	public T removeFront() {
		checkNotEmpty();
		T before = start.value;
		start = start.next;
		return before;
	}

	@Override
	public T removeBack() {
		checkNotEmpty();
		//if this Slist's size is 2 or greater...
		if (this.size() >= 2) {
			Node<T> lastInList = null;
			Node<T> beforeLast = null;
			for (Node<T> current = start; current != null; current = current.next) {
				//will end up being second to last node in list
				beforeLast = lastInList;
				//will end up being last node in list
				lastInList = current;
			}
			//erase the last node in the SList
			beforeLast.next = null; 
			//return what the value of the last in the list was 
			return lastInList.value; 

			//If this Slist's size is only 1
		} else if (this.size() == 1) {
			/* Only one value in this SList, and that's "start" (it's both the
			 * beginning and the end of the list). So erase start by setting 
			 * it to null, and then return the original value of start
			 */
			Node<T> first = start;
			start = null;
			return first.value;
		} 
		//Only happens if this Slist's size is empty, in which case it should be null
		throw new EmptyListError();
	}

	/*
	 *Iterate through nodes. If index is 0 and you're at the start, just remove front and 
	 *return current value (saved in last). If index !=0, then when at == index save that value
	 *to before and then from now on, for every node set the value of the node you're on to 
	 *the one after it. At the end, you'll have two nodes in a row at the end of your list
	 * w/ the same value so you delete the last one in the list.
	 */
	@Override
	public T removeIndex(int index) {
		if (index >= this.size()) {
			throw new BadIndexError();
		}
		int at = 0;
		Node<T> last = null;
		T before = null;

		for (Node<T> current = start; current != null; current = current.next) {
			
			last = current;
			if (index == 0 && at == 0) {
				this.removeFront();
				return last.value; 
			} else if (at == index) {
				before = last.value;
				current.value = current.next.value;
			} else if (at > index) {

				if (current.next != null) {
					current.value = current.next.value;

				} else {
					this.removeBack();
				}
			}
			at++;
		}
		return before;
	}

	@Override
	public void addFront(T item) {
		this.start = new Node<T>(item, start);
	}

	@Override
	public void addBack(T item) {
		Node<T> last = null;
		for (Node<T> current = start; current != null; current = current.next) {
			last = current;
		}
		//if last was set to something....
		if (last != null) {	
			last.next = new Node<T>(item, last.next); //DIFFICULT, WHY last.next
		} else {
			//If the list was empty
			start = new Node<T>(item, start);
		}
		
	}

	@Override
	public void addIndex(T item, int index) {//DIFFICULT
		int at = 0;
		if (index > this.size()) {
			throw new BadIndexError();
		}
		for(Node<T> current = start; current != null; current = current.next) {
			//if the index is 0 and we're currently at the beginning...
			if (index == 0 && at == 0) {
				//add item to front and make the next node the one that was originally there
				this.addFront(item);
				start.next = new Node<T>(current.value, current.next);
			}
			//If the index is anything other than 0
			if (at == index-1) {
				current.next = new Node<T>(item, current.next); //WHY current.next
			}
			at++;
			}	
		}
		
		
		
	

	@Override
	public T getFront() {
		return start.value;
	}

	@Override
	public T getBack() {
		Node<T> last = null;
		for (Node<T> current = start; current != null; current = current.next) {
			last = current;
		}
		//if last was set to something....
		if (last != null) {	
			return last.value; 
		} else {
			//If the list was empty
			throw new EmptyListError();
		}
	}

	@Override
	public T getIndex(int index) {
		int at = 0;
		for (Node<T> current = start; current != null; current = current.next) {
			if (at == index) {
				return current.value;
			}
			at++;
		}
		throw new BadIndexError();	
	}

	@Override
	public int size() {
		int count = 0;
		for (Node<T> n = this.start; n != null; n = n.next) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}

	/**
	 * Helper method to throw the right error for an empty state.
	 */
	private void checkNotEmpty() {
		if (this.isEmpty()) {
			throw new EmptyListError();
		}
	}

	/**
	 * The node on any linked list should not be exposed. Static means we don't need
	 * a "this" of SinglyLinkedList to make a node.
	 * 
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes after me?
		 */
		public Node<T> next;
		/**
		 * What value is stored in this node?
		 */
		public T value;

		/**
		 * Create a node with no friends.
		 * 
		 * @param value - the value to put in it.
		 */
		public Node(T value, Node<T> next) {
			this.value = value;
			this.next = next;
		}
	}

	/**
	 * I'm providing this class so that SinglyLinkedList can be used in a for loop
	 * for {@linkplain ChunkyLinkedList}. This Iterator type is what java uses for
	 * {@code for (T x : list) { }} lops.
	 * 
	 * @author jfoley
	 *
	 * @param <T>
	 */
	private static class Iter<T> implements Iterator<T> {
		/**
		 * This is the value that walks through the list.
		 */
		Node<T> current;

		/**
		 * This constructor details where to start, given a list.
		 * @param list - the SinglyLinkedList to iterate or loop over.
		 */
		public Iter(SinglyLinkedList<T> list) {
			this.current = list.start;
		}

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public T next() {
			T found = current.value;
			current = current.next;
			return found;
		}
	}
	
	/**
	 * Implement iterator() so that {@code SinglyLinkedList} can be used in a for loop.
	 * @return an object that understands "next()" and "hasNext()".
	 */
	public Iterator<T> iterator() {
		return new Iter<>(this);
	}
}
