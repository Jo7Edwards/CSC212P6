package edu.smith.cs.csc212.p6;

import org.junit.Test;

import edu.smith.cs.csc212.p6.errors.P6NotImplemented;
import org.junit.Assert;

public class DoublyLinkedListTest {
	
	@Test
	public void testRemoveFront() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		data.addBack("b");
		
		data.removeFront();
		
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("b", data.getFront());
	}
	
	@Test
	public void testRemoveBack() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		
		data.removeBack();
		
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("a", data.getFront());
	}
	
	@Test
	public void testSize() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		Assert.assertEquals(1, data.size());
		
		data.addBack("b");
		Assert.assertEquals(2, data.size());	
	}
	
	@Test
	public void testGetFront() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		data.addBack("b");
		
		Assert.assertEquals("a", data.getFront());
	}
	
	@Test
	public void testGetBack() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		data.addBack("b");
		Assert.assertEquals("b", data.getBack());
		data.addBack("c");
		Assert.assertEquals("c", data.getBack());
	}
	
	@Test 
	public void testGetIndex() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		
		Assert.assertEquals("a", data.getIndex(0));
		data.addBack("b");
		Assert.assertEquals("b", data.getIndex(1));
		
	}
	
	
	@Test
	public void testAddFront() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		data.addFront("b");
		data.addFront("c");//c, b, a
		
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("c", data.getFront());
		Assert.assertEquals("b",  data.getIndex(1));
		
	}
	
	@Test
	public void testAddBack() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		Assert.assertEquals("a", data.getIndex(0));
		data.addBack("b");
		Assert.assertEquals("b", data.getIndex(1));
		Assert.assertEquals(2, data.size());
	}
	
	@Test 
	public void testAddIndex() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addBack("a");
		data.addBack("b");//a, b
		//Should be able to add in the middle and everything move over
		data.addIndex("c", 1); //a, c, b, 
		Assert.assertEquals("c",  data.getIndex(1));
		Assert.assertEquals("b",  data.getIndex(2));
		
		//Should be able to add to end
		data.addIndex("d", 3);//a, c, b, d
		
		Assert.assertEquals("d", data.getIndex(3));
		//Should be able to add to beginning and everything move over
		data.addIndex("1", 0);//1, a, c, b, d
		
		Assert.assertEquals("1",  data.getIndex(0));
		Assert.assertEquals("a",  data.getIndex(1));
		Assert.assertEquals("d",  data.getIndex(4));
	}

}
