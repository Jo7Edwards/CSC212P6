package edu.smith.cs.csc212.p6;

import org.junit.Assert;
import org.junit.Test;

public class SinglyLinkedListTest {
	
	@Test 
	public void testAddFront() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addFront("b");
		data.addFront("a");
		
		Assert.assertEquals("b", data.getIndex(1));
	}
	
	@Test
	public void testRemoveBack() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addFront("b");
		data.addFront("a");
		
		Assert.assertEquals("b", data.removeBack());
		Assert.assertEquals(1, data.size());
	}
	
	@Test
	public void testGetIndex() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addFront("b");
		data.addFront("a");
		
		Assert.assertEquals("b", data.getIndex(1));
	}
	
	@Test 
	public void testAddIndex() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addBack("a");
		data.addBack("b"); //a, b
		
		data.addIndex("c", 1); //a, c, b
		Assert.assertEquals("c",  data.getIndex(1));
		Assert.assertEquals("b",  data.getIndex(2));
		
		data.addIndex("d", 3);//a, c, b, d
		
		Assert.assertEquals("d", data.getIndex(3));
		
		data.addIndex("1", 0);//1, a, c, b, d
		
		Assert.assertEquals("1",  data.getIndex(0));
		Assert.assertEquals("a",  data.getIndex(1));
		Assert.assertEquals("d",  data.getIndex(4));
	}
	
	@Test
	public void testaddBack() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addBack("a");
		Assert.assertEquals("a",  data.getIndex(0));
		Assert.assertEquals(1,  data.size());
		data.addBack("b");
		
		Assert.assertEquals("b",  data.getIndex(1));
		Assert.assertEquals(2,  data.size());
	}
	
	@Test
	public void testGetBack() {
		P6List<String> data = new SinglyLinkedList<String>();
		data.addBack("a"); //a
		Assert.assertEquals("a",  data.getBack());
		data.addBack("b"); //a, b
		Assert.assertEquals("b", data.getBack());
	}
	
	

}
