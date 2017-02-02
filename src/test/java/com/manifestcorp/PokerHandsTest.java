package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PokerHandsTest {

	private CardComparator cardComparator;
	
	@Before public void initialize() {
	       cardComparator = new CardComparator();
	}

	
	//tests to write
	//card is higher than other
	@Test
	public void testCardsAreRankedInOrder() throws Exception {
		//iterate through cards and check all of them
		assertTrue(cardComparator.isGreaterCard('K', '2'));
	}
	//card is equal to other
	//hand is a pair
	//hand is two pair
	//hand is three of a kind
	//hand is a straight
	//hand is a flush
	

}
