package com.manifestcorp;

import java.util.ArrayList;
import java.util.Arrays;

public class CardComparator {
	ArrayList<Character> sortedCardValues;
	public CardComparator(){
		sortedCardValues = new ArrayList(Arrays.asList('2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A'));
	}
	
	public boolean isGreaterCard(char cardGreater, char cardLess){
		return sortedCardValues.indexOf(cardGreater) > sortedCardValues.indexOf(cardLess);
	}

	public boolean isEqualCards(char card1, char card2) {
		// TODO Auto-generated method stub
		return card1 == card2;
	}
	
	
	
	
	
	
	
	
}
