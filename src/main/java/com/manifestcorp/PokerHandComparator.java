package com.manifestcorp;

public class PokerHandComparator {

	public boolean isFlush(Hand hand){
		//all same suit
		boolean flush = true;
		for(int i = 0; i < hand.getCards().size()-1; i++){
			if(hand.getCards().get(i).getSuit() != hand.getCards().get(i+1).getSuit()){
				flush = false;
				break;
			}
		}
		return flush;
	}
	
	private boolean twoCardsAreConsecutive(Card card1, Card card2){
		return card2.getValue().ordinal() == (card1.getValue().ordinal() +1);
	}
	
	public boolean isStraight(Hand hand){
		//all consecutive cards
		boolean consecutive = true;
		for(int i = 0; i < hand.getCards().size()-1; i++){
			if(!twoCardsAreConsecutive(hand.getCards().get(i), hand.getCards().get(i+1))){
				consecutive = false;
			}
		}
		return consecutive;
	}
	
	public boolean isStraightFlush(Hand hand){
		return isStraight(hand) && isFlush(hand);
	}
	
	public boolean isFourOfAKind(Hand hand){
		return false;
	}
	
	public boolean isThreeOfAKind(Hand hand){
		return false;
	}
	
	public boolean isFullHouse(Hand hand){
		//3 pair and 2 pair
		return false;
	}
	
	public boolean isTwoPair(Hand hand){
		return false;
	}
	
	
}
