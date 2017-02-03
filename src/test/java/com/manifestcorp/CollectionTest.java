package com.manifestcorp;
import static org.junit.Assert.*;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
	/**
	* <b>CollectionTest</b> Javadoc
	*/
public class CollectionTest{

	private List<Integer> numberList;
	
	@Before
	public void before(){
		numberList = new ArrayList<Integer>();
	}
	
	@After
	public void after(){
		numberList = null;
	}
	
	@Test
	public void testDefaultListSize(){
		assertEquals("Default size of list should be 0.", 0, (int)numberList.size());
	}
	
	private void fillList(int n){
		for(int i = 1; i <= n; i++){
			numberList.add(i);
		}
	}
	
	@Test
	public void testSecondIndexFromCollectionOfFive(){
		fillList(5);
		assertEquals("Second item from list", 2, (int)numberList.get(1));
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void testGetting100thItemFrom5ItemCollection(){
		numberList.get(99);
	}
}