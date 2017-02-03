package com.manifestcorp;

public class PokerHandComparator {

	public boolean isFlush(Hand hand){
		//all same suit
		for(Card card: hand.getCards()){
			
		}
		return false;
	}
	
	public boolean isStraight(Hand hand){
		//all consecutive cards
		return false;
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
