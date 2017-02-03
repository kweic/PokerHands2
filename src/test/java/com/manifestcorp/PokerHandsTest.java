package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {


	private Hand cardHand1;
	private char KING = 'K';
	private  char TWO = '2';
	private HandChecker handChecker;
	private String CARDS1 = "2H 3D 5S 9C KD";
	private String BAD_INPUT_TOO_MANY_CARDS = CARDS1+" 4H";
	private String BAD_INPUT_TOO_FEW_CARDS = "2H 3D 5S 9C";
	private String CARDS_PAIR = "9C 3D 5S 9C KD";
	private String CARDS_STRAIGHTFLUSH = "2H 3H 4H 5H 6H";
	private String CARDS_STRAIGHT = "3D 4D 5D 6D 7D";
	private String CARDS_FLUSH = "2H 3H 5H 8H AH";
	
	@Before public void initialize() {
	       handChecker = new HandChecker();
	}
	
	@After
	public void after(){
		handChecker = null;
	}

	//tests to write
	//card is higher than other
	@Test
	public void testCardIsGreater() throws Exception {
		//iterate through cards and check all of them
		assertTrue(handChecker.isGreaterCard(KING, TWO));
	}
	
	@Test
	public void testCardIsLess() throws Exception {
		assertFalse(handChecker.isGreaterCard(TWO, KING));
	}
	//card is equal to other
	@Test
	public void testCardsAreEqual() throws Exception {
		assertTrue(handChecker.isEqualCards(KING, KING));
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
	
	//hand is a pair
	@Test
	public void testHandHasAPair() throws Exception {
		cardHand1 = new Hand(CARDS_PAIR);
		assertTrue(handChecker.isPair(cardHand1));
	}
	
	@Test
	public void testHandIsStraightFlush() throws Exception{
		cardHand1 = new Hand(CARDS_STRAIGHTFLUSH);
		assertTrue(handChecker.isStraightFlush(cardHand1));
	}
	
	@Test
	public void testHandisStraight() throws Exception{
		cardHand1 = new Hand(CARDS_STRAIGHT);
		assertTrue(handChecker.isStraight(cardHand1));
	}
	
	@Test
	public void testHandisFlush() throws Exception{
		//same suit
		cardHand1 = new Hand(CARDS_FLUSH);
		assertTrue(handChecker.isFlush(cardHand1));
	}
	//hand is two pair
	//hand is three of a kind
	//hand is a straight
	//hand is a flush
	//input is valid for hands
	

}
