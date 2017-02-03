package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {

	private PokerHandComparator pokerHandComparator = new PokerHandComparator();
	private String CARDS_FLUSH = "2H 4H 6H 8H JH";
	private String CARDS_STRAIGHT = "3D 4H 5S 6D 7C";
	private Hand hand;
	private String CARDS_STRAIGHTFLUSH = "8D 9D TD JD QD";
	private String CARDS_FOUROFAKIND;
	private String CARDS_FULLHOUSE;
	private String CARDS_TOOMANY = "3D 4H 5S 6D 7C TH";
	private String CARDS_TOO_FEW = "3D 4H 5S 6D";
	private String CARDS_UNSORTED = "QD 2D TD 5D 8D";
	
	@Before
	public void init(){
		
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNoCardInput(){
		hand = new Hand("");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testNotEnoughCards(){
		hand = new Hand(CARDS_TOO_FEW);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void testTooManyCards(){
		hand = new Hand(CARDS_TOOMANY);
	}
	
	@Test
	public void testIsFlush() {
		//all same suit
		hand = new Hand(CARDS_FLUSH);
		assertTrue(pokerHandComparator.isFlush(hand));
	}
	
	@Test
	public void testIsStraight() {
		//all consecutive values
		hand = new Hand(CARDS_STRAIGHT);
		assertTrue(pokerHandComparator.isStraight(hand));
	}
	
	@Test
	public void testIsNotFlush(){
		hand = new Hand(CARDS_STRAIGHT);
		assertFalse(pokerHandComparator.isFlush(hand));
	}
	
	@Test
	public void testIsNotStraight(){
		hand = new Hand(CARDS_FLUSH);
		assertFalse(pokerHandComparator.isStraight(hand));
	}
	
	@Test
	public void testFourOfAKind() {
		hand = new Hand(CARDS_FOUROFAKIND);
		assertTrue(pokerHandComparator.isFourOfAKind(hand));
	}
	
	@Test
	public void testIsFullHouse() {
		hand = new Hand(CARDS_FULLHOUSE);
		assertTrue(pokerHandComparator.isFullHouse(hand));
	}
	
	@Test
	public void testIsThreeOfAKind() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIsPair() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testHighCardIsKing(){
		fail("not implemented");
	}
	
	@Test
	public void test3isHigherThan2(){
		fail("not implemented");
	}
	
	@Test
	public void testHandToStringMatches(){
		hand = new Hand(CARDS_FLUSH);
		assertEquals(CARDS_FLUSH, hand.toString());
	}
	
	@Test
	public void testHandIsSorted(){
		hand = new Hand(CARDS_UNSORTED);
		System.out.println(hand);
		assertEquals(1, hand.getCards().toArray());
	}
	
	@Test
	public void testStraightFlushBeatsFourOfAKind(){
		fail("not implemented");
	}
	
	@Test
	public void testHandWithHighCardWins(){
		fail("not implemented");
	}
	
	@Test
	public void testHandsTie(){
		fail("not implemented");
	}
	
	@Test
	public void testTwoPairTieHighWins(){
		fail("not implemented");
	}
	
	@Test
	public void testThreeOfAKindHighTripletWins(){
		fail("not implemented");
	}
	
	@Test
	public void testBothFullHouseHigherThreeWins(){
		fail("not implemented");
	}

}
