package edu.smith.cs.csc212.p6;

//import edu.smith.cs.csc212.p6.SinglyLinkedList.Node;
//import edu.smith.cs.csc212.p6.SinglyLinkedList.Node;
import edu.smith.cs.csc212.p6.errors.BadIndexError;
//import edu.smith.cs.csc212.p6.SinglyLinkedList.Node;
import edu.smith.cs.csc212.p6.errors.EmptyListError;
import edu.smith.cs.csc212.p6.errors.P6NotImplemented;




public class DoublyLinkedList<T> implements P6List<T> {
	private Node<T> start;
	private Node<T> end;
	
	/**
	 * A doubly-linked list starts empty.
	 */
	public DoublyLinkedList() {
		this.start = null;
		this.end = null;
	}
	

	@Override
	public T removeFront() {
		checkNotEmpty();
		Node<T> removed = new Node<T>(null);
		
		if (this.size() == 1) {
			removed = this.start;
			this.start = null;
			return removed.value;
		} else {
			removed = this.start;
			this.start = this.start.after;
			this.start.before = null;
			return removed.value;
		}	
		
	}

	@Override
	public T removeBack() {
		checkNotEmpty();
		Node<T> removed = new Node<T>(null);
		if (this.size() == 1) {
			removed = this.start;
			this.start = null;
			return removed.value;
		} else {
			removed = this.end;
			this.end = this.end.before;
			this.end.after = null;
			return removed.value;
		}
	}

	@Override
	public T removeIndex(int index) {
		checkNotEmpty();
		throw new P6NotImplemented();
	}

	@Override
	public void addFront(T item) {
		Node<T> newNode = new Node<T>(item);
		Node<T> beforeNode = new Node<T>(null);
		//if the list is empty
		if (this.start == null) {
			this.start = newNode;
			this.end = newNode;		
		} else {
			beforeNode = this.start;
			this.start = newNode;
			this.start.after = beforeNode;
			
		}
	}

	@Override
	public void addBack(T item) {
		
		//Make a new node that has value of item
		Node<T> newNode = new Node<T>(item);
		//if list is empty
		if (this.end == null) {
			this.start = newNode;
			this.end = newNode;
			
		} else {
			//NEED TO SET PREV TO NEXT NEWNODE, THEN SET
			//NEWNODE BEFORE, AFTER, AND ITSELF
			this.end.after = newNode;
			
			//set newNode's before to the current end node, and after to null
			newNode.before = this.end;
			newNode.after = null;
			//now make the end of this list equal to this new node
			this.end = newNode;
		}
		
	}

	@Override
	public void addIndex(T item, int index) {
		if (index > this.size()) {
			throw new BadIndexError();
		}
		
		Node<T> newNode = new Node<T>(item);
		int at = 0;
		for (Node<T> current = start; current != null; current = current.after) {
			if (at == 0 && index == 0) {
				this.addFront(item);
			} else if (at == index -1) {
				if (current.after == null) {
					newNode.before = current;
					this.end = newNode;
				} else {
					newNode.after = current.after;
					current.after.before = newNode;
					newNode.before = current;
				}
			}
		}
	
	}
	

	@Override
	public T getFront() {
		checkNotEmpty();
		return this.start.value;
	}

	@Override
	public T getBack() {
		checkNotEmpty();
		return this.end.value;
	}
	
	@Override
	public T getIndex(int index) {
		checkNotEmpty();
		int at = 0;
		for (Node<T> current = start; current != null; current = current.after) {
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
		for (Node<T> n = this.start; n != null; n = n.after) {
			count++;
		}
		return count;
	}

	@Override
	public boolean isEmpty() {
		return this.size() == 0;
	}
	
	private void checkNotEmpty() {
		if (this.isEmpty()) {
			throw new EmptyListError();
		}
	}
	
	/*private Node<T> NewNode(T item) {
		Node<T> newNode = null;
		newNode.value = item;
		return newNode;
	}*/
	
	/**
	 * The node on any linked list should not be exposed.
	 * Static means we don't need a "this" of DoublyLinkedList to make a node.
	 * @param <T> the type of the values stored.
	 */
	private static class Node<T> {
		/**
		 * What node comes before me?
		 */
		public Node<T> before;
		/**
		 * What node comes after me?
		 */
		public Node<T> after;
		/**
		 * What value is stored in this node?
		 */
		public T value;
		/**
		 * Create a node with no friends.
		 * @param value - the value to put in it.
		 */
		public Node(T value) {
			this.value = value;
			this.before = null;
			this.after = null;
		}
	}
}
