package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {

	private CardComparator cardComparator;
	private Hand cardHand1;
	private char KING = 'K';
	private  char TWO = '2';
	private HandChecker handChecker;
	private String CARDS1 = "2H 3D 5S 9C KD";
	private String BAD_INPUT_TOO_MANY_CARDS = CARDS1+" 4H";
	private String BAD_INPUT_TOO_FEW_CARDS = "2H 3D 5S 9C";
	private String CARDS_PAIR = "9C 3D 5S 9C KD";
	
	@Before public void initialize() {
	       cardComparator = new CardComparator();
	       handChecker = new HandChecker();
	}
	
	@After
	public void after(){
		cardComparator = null;
		handChecker = null;
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
		cardHand1 = new Hand(CARDS_PAIR);
		assertTrue(handChecker.isPair(cardHand1));
	}
	
	@Test
	public void testHandCreatesCards() throws Exception {
		cardHand1 = new Hand(CARDS1); //black
		assertEquals("char value of card number should be equal", CARDS1.charAt(0), cardHand1.cards.get(0).cardNumber); 
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHandThrowsExceptionIfBadInput_TooManyCards() throws Exception {
		cardHand1 = new Hand(BAD_INPUT_TOO_MANY_CARDS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHandThrowsExceptionIfBadInput_TooFewCards() throws Exception {
		cardHand1 = new Hand(BAD_INPUT_TOO_FEW_CARDS);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHandThrowsExceptionIfBadInput_NullInput() throws Exception {
		cardHand1 = new Hand(null);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testHandThrowsExceptionIfBadInput_EmptyInput() throws Exception {
		cardHand1 = new Hand("");
	}
	//hand is two pair
	//hand is three of a kind
	//hand is a straight
	//hand is a flush
	//input is valid for hands
	

}
