package com.manifestcorp;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	
	public Hand(String cards_String){
		String[] cards_arr = cards_String.split(" ");
		if(cards_String.isEmpty() || cards_arr.length != 5){
			throw new IllegalArgumentException();
		}
		
		cards = new ArrayList<Card>();
		
		for(String card: cards_arr){
			cards.add(new Card(CardValue.permissiveValueOf(card.charAt(0)), Suit.permissiveValueOf(card.charAt(1))));
		}
	}
	
	public ArrayList<Card> getCards() {
		// TODO Auto-generated method stub
		return cards;
	}
	
}
