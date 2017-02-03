package com.manifestcorp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;


public class HandChecker {

	ArrayList<Character> sortedCardValues = new ArrayList<Character>(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
	
	
	public boolean isPair(Hand hand) {
		boolean hasPair = false;
		HashSet<Character> cardHash = new HashSet<Character>();
		for(Card card: hand.cards){
			if(cardHash.contains(card.cardNumber)){
				hasPair = true;
				break;
			}else{
				cardHash.add(card.cardNumber);
			}
		}
		return hasPair;
	}
	
	public boolean isStraightFlush(Hand hand){
		return isStraight(hand) && isFlush(hand);
	}
	
	public boolean isStraight(Hand hand){
		return false;
	}
	
	public boolean isFlush(Hand hand){
		return false;
	}
	
	public boolean isGreaterCard(char cardGreater, char cardLess){
		return sortedCardValues.indexOf(cardGreater) > sortedCardValues.indexOf(cardLess);
	}

	public boolean isEqualCards(char card1, char card2) {
		return card1 == card2;
	}

}
