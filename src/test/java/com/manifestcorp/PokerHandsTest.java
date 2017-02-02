package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import junit.framework.TestCase;

public class PokerHandsTest {

	private CardComparator cardComparator;
	private Hand cardHand1;
	private char KING = 'K';
	private  char TWO = '2';
	
	@Before public void initialize() {
	       cardComparator = new CardComparator();
	       cardHand1 = new Hand();
	}

	
	//tests to write
	//card is higher than other
	@Test
	public void testCardIsGreater() throws Exception {
		//iterate through cards and check all of them
		assertTrue(cardComparator.isGreaterCard(KING, TWO));
	}
	
	@Test
	public void testCardIsLess() throws Exception {
		assertFalse(cardComparator.isGreaterCard(TWO, KING));
	}
	//card is equal to other
	@Test
	public void testCardsAreEqual() throws Exception {
		assertTrue(cardComparator.isEqualCards(KING, KING));
	}
	//hand is a pair
	@Test
	public void testHandHasAPair() throws Exception {
		assertTrue(cardHand1.isPair());
	}
	//hand is two pair
	//hand is three of a kind
	//hand is a straight
	//hand is a flush
	

}
