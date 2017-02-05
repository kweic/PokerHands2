package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PokerHandsTest {

	private PokerHandComparator pokerHandComparator = new PokerHandComparator();
	private Hand hand;
	
	private String CARDS_FLUSH = "2H 4H 6H 8H JH";
	private String CARDS_STRAIGHT = "3D 4H 5S 6D 7C";
	private String CARDS_FULLHOUSE = "3C 3S 3D KD KH";
	private String CARDS_PAIR = 	    "QD 2D TD QH 8D"; //queen pair
	private String CARDS_THREEOFAKIND = "QD QH TD 5D QS"; //3 queens
	private String CARDS_FOUROFAKIND =  "QD QH QS 5D QC"; //4 queens
	private String CARDS_STRAIGHTFLUSH = "8D 9D TD JD QD";

	//error cards
	private String CARDS_TOOMANY = "3D 4H 5S 6D 7C TH";
	private String CARDS_TOO_FEW = "3D 4H 5S 6D";
	
	private String CARDS_UNSORTED = "QD 2D TD 5D 8D";
	private String CARDS_SORTED =   "2D 5D 8D TD QD";

	private String CARDS_HIGHCARDISKING = "QS KD TH 5C 8D";
	private Object CARD_KING = "KD";
	private String CARDS_TWOPAIR = "QS QD 5H 3C 5D";
	private String CARDS_ROYALFLUSH = "AH KH QH JH TH";
	
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
		hand = new Hand(CARDS_THREEOFAKIND);
		assertTrue(pokerHandComparator.isThreeOfAKind(hand));
	}
	
	@Test
	public void testIsPair() {
		hand = new Hand(CARDS_PAIR);
		assertTrue(pokerHandComparator.isTwoPair(hand));
	}
	
	@Test
	public void testHighCardIsKing(){
		hand = new Hand(CARDS_HIGHCARDISKING);
		assertEquals(CARD_KING, hand.getCards().get(hand.getCards().size()-1).toString());
	}
	
	
	@Test
	public void test3isHigherThan2(){
		Card two = new Card(CardValue.permissiveValueOf('2'), Suit.permissiveValueOf('H'));
		Card three = new Card(CardValue.permissiveValueOf('3'), Suit.permissiveValueOf('H'));
		assertTrue(0 < three.compareTo(two));
	}
	
	@Test
	public void testHandToStringMatches(){
		hand = new Hand(CARDS_FLUSH);
		assertEquals(CARDS_FLUSH, hand.toString());
	}
	
	@Test
	public void testHandIsSorted(){
		hand = new Hand(CARDS_UNSORTED);
		assertEquals(CARDS_SORTED, hand.toString());
	}
	
	@Test
	public void testHandRankRoyalFlushAssigned(){
		hand = new Hand(CARDS_ROYALFLUSH);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.ROYALFLUSH, hand.getRank());
	}
	
	@Test
	public void testHandRankStraightFlushAssigned(){
		hand = new Hand(CARDS_STRAIGHTFLUSH);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.STRAIGHTFLUSH, hand.getRank());
	}
	
	@Test
	public void testHandFourOfAKindAssigned(){
		hand = new Hand(CARDS_FOUROFAKIND);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.FOUROFAKIND, hand.getRank());
	}
	
	@Test
	public void testHandFullHouseAssigned(){
		hand = new Hand(CARDS_FULLHOUSE);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.FULLHOUSE, hand.getRank());
	}
	
	@Test
	public void testHandFlushAssigned(){
		hand = new Hand(CARDS_FLUSH);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.FLUSH, hand.getRank());
	}
	
	@Test
	public void testHandStraightAssigned(){
		hand = new Hand(CARDS_STRAIGHT);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.STRAIGHT, hand.getRank());
	}
	
	@Test
	public void testHandThreeOfAKindAssigned(){
		hand = new Hand(CARDS_THREEOFAKIND);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.THREEOFAKIND, hand.getRank());
	}
	
	@Test
	public void testHandTwoPairAssigned(){
		hand = new Hand(CARDS_TWOPAIR);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.TWOPAIR, hand.getRank());
	}
	
	@Test
	public void testHandOnePairAssigned(){
		hand = new Hand(CARDS_PAIR);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.ONEPAIR, hand.getRank());
	}
	
	@Test
	public void testHandHighCardAssigned(){
		hand = new Hand(CARDS_HIGHCARDISKING);
		pokerHandComparator.rankHand(hand);
		assertEquals(HandRank.HIGHCARD, hand.getRank());
	}
	
	@Test
	public void testStraightFlushBeatsFourOfAKind(){
		//how to assert one hand beats another..
		//what to pass back..
		//pass two into method, return true for winner
		Hand hand1 = new Hand(CARDS_STRAIGHTFLUSH);
		Hand hand2 = new Hand(CARDS_FOUROFAKIND);
		assertTrue(pokerHandComparator.firstHandWins(hand1, hand2));
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
