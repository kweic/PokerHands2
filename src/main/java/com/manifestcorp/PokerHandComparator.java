package com.manifestcorp;

import java.util.HashMap;

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
	
	private boolean cardCounter(Hand hand, int count, boolean checkFullHouse){
		HashMap<CardValue, Integer> cardCount = new HashMap<CardValue, Integer>();
		boolean hasCount = false;
		
		for(Card card: hand.getCards()){
			if(cardCount.containsKey(card.getValue())){
				cardCount.put(card.getValue(), cardCount.get(card.getValue())+1);
				if(cardCount.get(card.getValue()) == count){
					hasCount = true;
				}
			}else{
				cardCount.put(card.getValue(), 1);
			}
		}
		
		if(checkFullHouse){
			return cardCount.size() == 2;
		}
		return hasCount;
	}
	
	public Card highCardFromFullHand(Hand hand){
		return hand.getCards().get(hand.getCards().size()-1);
	}
	
	public boolean isFourOfAKind(Hand hand){
		return cardCounter(hand, 4, false);
	}
	
	public boolean isThreeOfAKind(Hand hand){
		return cardCounter(hand, 3, false);
	}
	
	public boolean isFullHouse(Hand hand){ //3 pair and 2 pair
		return cardCounter(hand, 3, true);
	}
	
	public boolean isTwoPair(Hand hand){
		return false;
	}
	
	private boolean isSinglePair(Hand hand) {
		return cardCounter(hand, 2, false);
	}
	
	private int handScore(Hand hand){
		//todo: depricate this, use handranker
		int handScore = 0;
		if(isStraightFlush(hand)){
			handScore = 7;
		}else if(isFourOfAKind(hand)){
			handScore = 6;
		}else if(isFullHouse(hand)){
			handScore = 5;
		}else if(isFlush(hand)){
			handScore = 4;
		}else if(isThreeOfAKind(hand)){
			handScore = 3;
		}else if(isTwoPair(hand)){
			handScore = 2;
		}else if(isSinglePair(hand)){
			handScore = 1;
		}
		return handScore;
	}
	
	private void rankHand(Hand hand){
		HandRank rank = HandRank.HIGHCARD;
		if(isStraightFlush(hand)){
			rank = HandRank.STRAIGHTFLUSH;
		}else if(isFourOfAKind(hand)){
			rank = HandRank.FOUROFAKIND;
		}else if(isFullHouse(hand)){
			rank = HandRank.FULLHOUSE;
		}else if(isFlush(hand)){
			rank = HandRank.FLUSH;
		}else if(isThreeOfAKind(hand)){
			rank = HandRank.THREEOFAKIND;
		}else if(isTwoPair(hand)){
			rank = HandRank.TWOPAIR;
		}else if(isSinglePair(hand)){
			rank = HandRank.ONEPAIR;
		}
		hand.setHandRank(rank);
	}

	public boolean firstHandWins(Hand hand1, Hand hand2) {
		boolean firstHandWins = false;
		if(handScore(hand1) > handScore(hand2)){
			firstHandWins = true;
		}
		return firstHandWins;
	}
	
	
}
