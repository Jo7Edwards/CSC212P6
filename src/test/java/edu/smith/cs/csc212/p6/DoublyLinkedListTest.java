package edu.smith.cs.csc212.p6;

import org.junit.Test;

import edu.smith.cs.csc212.p6.errors.P6NotImplemented;
import org.junit.Assert;

public class DoublyLinkedListTest {
	
	
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
	public void testAddBack() {
		P6List<String> data = new DoublyLinkedList<>();
		data.addBack("a");
		Assert.assertEquals("a", data.getIndex(0));
		data.addBack("b");
		Assert.assertEquals("b", data.getIndex(1));
		Assert.assertEquals(2, data.size());
	}

}
