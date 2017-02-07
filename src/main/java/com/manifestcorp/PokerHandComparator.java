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
		//todo: simplify this, no calls to ordinal from here
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
	
	private boolean cardCounter(Hand hand, int count, boolean checkFullHouse, boolean check2Pair){
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
		if(check2Pair){
			return cardCount.size() == 3;
		}
		return hasCount;
	}
	
	public Card highCardFromFullHand(Hand hand){
		return hand.getCards().get(hand.getCards().size()-1);
	}
	
	public boolean isASetOf(int n, Hand hand){
		return cardCounter(hand, n, false, false);
	}
	
	public boolean isFullHouse(Hand hand){ //3 pair and 2 pair
		return cardCounter(hand, 3, true, false);
	}
	
	public boolean isTwoPair(Hand hand){
		return cardCounter(hand, 2, false, true);
	}
	
	
	private boolean isRoyalFlush(Hand hand){
		if(!isStraightFlush(hand))return false;
		return (highCardFromFullHand(hand).getValue().value() == 'A' &&
				hand.getCards().get(0).getValue().value() == 'T');
	}
	
	public void organizeTieBreakerCards(Hand hand){
		
	}
	
	public void rankHand(Hand hand){
		HandRank rank = HandRank.HIGHCARD;
		if(isStraightFlush(hand)){
			if(isRoyalFlush(hand)){
				rank = HandRank.ROYALFLUSH;
			}else{
				rank = HandRank.STRAIGHTFLUSH;
			}
		}else if(isASetOf(4, hand)){
			rank = HandRank.FOUROFAKIND;
		}else if(isFullHouse(hand)){
			rank = HandRank.FULLHOUSE;
		}else if(isFlush(hand)){
			rank = HandRank.FLUSH;
		}else if(isStraight(hand)){
			rank = HandRank.STRAIGHT;
		}else if(isASetOf(3, hand)){
			rank = HandRank.THREEOFAKIND;
		}else if(isTwoPair(hand)){
			rank = HandRank.TWOPAIR;
		}else if(isASetOf(2, hand)){
			rank = HandRank.ONEPAIR;
		}
		hand.setHandRank(rank);
	}

	public boolean firstHandWins(Hand hand1, Hand hand2) {
		boolean firstHandWins = false;
		if(hand1.compareTo(hand2) > 0){
			firstHandWins = true;
		}
		return firstHandWins;
	}
	
	
}
