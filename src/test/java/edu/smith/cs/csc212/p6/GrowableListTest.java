package edu.smith.cs.csc212.p6;

import org.junit.Assert;
import org.junit.Test;

public class GrowableListTest {
	///if it gets to the end successfully, then thats a pass. if it gets an exception 
	//during, then that's a fail. 
	
	//NEED TO PUT @ and Test for JUnit to test the method 
	
	//assertEquals is like, does the left Equal the right? 
	
	//Growable use original fixedSizeList, for single linked use last weeks lab, for double
	//linked, figure it out! 
	
	@Test
	public void testEmpty() {
		/*
		 * MAKE A P6List data. CHECK IF IT IS EMPTY. YAY THAT WORKS. NOW, 
		 * ADD SOMETHING TO data. CHECK THAT IT IS NOT EMPTY. IF THAT 
		 * WORKS THEN isEmpty() works 
		 */
		P6List<String> data = new GrowableList<String>();
		Assert.assertEquals(0, data.size()); //Should be true
		Assert.assertEquals(true, data.isEmpty()); //should be true
		
		data.addBack("1"); //This assumes that addBack is working, though
		Assert.assertEquals(false,  data.isEmpty()); // should overall be true, since isEmpty() should == false
		
	}
	
	@Test
	public void testRemoveFront() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		
		data.removeFront();
		
		Assert.assertEquals("b", data.getIndex(0));	
	}
	
	/*
	 * Test that after removeBack the size is 1
	 */
	@Test
	public void testRemoveBack() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		data.removeBack();
		Assert.assertEquals(1, data.size());
	}
	
	@Test
	public void testRemoveIndex() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		data.addBack("c");
		Assert.assertEquals("c", data.getIndex(2)); //c should be at index 2
		Assert.assertEquals("b", data.removeIndex(1)); //b should be at index 1, AND we're removing it
		Assert.assertEquals("c", data.getIndex(1));//Now c should be moved back by one to index 1
	}
	
	@Test
	public void testAddFront() {
		P6List<String> data = new GrowableList<String>();
		data.addFront("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		data.addFront("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(0));
		Assert.assertEquals("1", data.getIndex(1));
		data.addFront("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(0));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(2));
		data.addFront("-2");
		Assert.assertEquals("-2", data.getIndex(0));
		Assert.assertEquals("-1", data.getIndex(1));
		Assert.assertEquals("0", data.getIndex(2));
		Assert.assertEquals("1", data.getIndex(3));	
	}
	
	
	
	@Test
	public void testAddBack() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("1");
		Assert.assertEquals(1, data.size());
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("0");
		Assert.assertEquals(2, data.size());
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-1");
		Assert.assertEquals(3, data.size());
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		data.addBack("-2");
		Assert.assertEquals("-2", data.getIndex(3));
		Assert.assertEquals("-1", data.getIndex(2));
		Assert.assertEquals("0", data.getIndex(1));
		Assert.assertEquals("1", data.getIndex(0));
		
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
	public void testGetFront() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		Assert.assertEquals("a", data.getIndex(0));
	}
	
	@Test
	public void testGetBack() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		Assert.assertEquals("a",  data.getBack());
		data.addBack("b");
		Assert.assertEquals("b", data.getBack());
	}
	@Test
	public void testGetIndex() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		
		Assert.assertEquals("b",  data.getIndex(1));
	}
	
	@Test
	public void testSize() {
		P6List<String> data = new GrowableList<String>();
		data.addBack("a");
		data.addBack("b");
		
		Assert.assertEquals(2, data.size());
	}


}
