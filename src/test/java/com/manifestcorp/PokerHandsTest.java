package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {

	private PokerHandComparator pokerHandComparator = new PokerHandComparator();
	private String CARDS_FLUSH = "2H 4H 6H 8H JH";
	private String CARDS_STRAIGHT = "3D 4H 5S 6D 7C";
	private Hand hand;
	
	@Before
	public void init(){
		
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
	public void testIsStraightFlush() {
		fail("not impl");
	}
	
	@Test
	public void testFourOfAKind() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testIsFullHouse() {
		//3 of same value and 2 pair
		fail("Not yet implemented");
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
	public void testHandIsSorted(){
		fail("not implemented");
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
