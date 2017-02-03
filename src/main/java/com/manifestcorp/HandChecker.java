package com.manifestcorp;

import java.util.HashSet;
import java.util.Map;

public class HandChecker {

	public boolean isPair(Hand cardHand1) {
		boolean hasPair = false;
		HashSet<Character> cardHash = new HashSet<Character>();
		for(Card card: cardHand1.cards){
			if(cardHash.contains(card.cardNumber)){
				hasPair = true;
				break;
			}else{
				cardHash.add(card.cardNumber);
			}
		}
		return hasPair;
	}

}
