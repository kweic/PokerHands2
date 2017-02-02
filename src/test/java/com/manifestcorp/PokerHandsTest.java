package com.manifestcorp;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {

	private CardComparator cardComparator;
	private Hand cardHand1;
	private char KING = 'K';
	private  char TWO = '2';
	private HandChecker handChecker;
	private String CARDS1 = "2H 3D 5S 9C KD";
	private CardsInputParser inputParser;
	private String BAD_INPUT_TOO_MANY_CARDS = CARDS1+" 4H";
	
	@Before public void initialize() {
	       cardComparator = new CardComparator();
	       handChecker = new HandChecker();
	       inputParser = new CardsInputParser();
	       ArrayList<Card> cardsArray1 = inputParser.makeCardArray(CARDS1);
	       cardHand1 = new Hand(true, cardsArray1); //black
	       
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
		assertTrue(handChecker.isPair(cardHand1));
	}
	
	@Test
	public void cardParserCreatesCardArray() throws Exception {
		fail("not implemented");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testInputParserThrowsExceptionIfBadInput() throws Exception {
		inputParser.makeCardArray(BAD_INPUT_TOO_MANY_CARDS);
	}
	//hand is two pair
	//hand is three of a kind
	//hand is a straight
	//hand is a flush
	//input is valid for hands
	

}
