package com.manifestcorp;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	
	public Hand(String cardsStr){
		if(cardsStr == null || cardsStr.isEmpty()) throw new IllegalArgumentException();
		cards = new ArrayList<Card>();
		String[] cards_str_arr = cardsStr.split(" ");
		
		//wrong number of cards
		if(cards_str_arr.length != 5)throw new IllegalArgumentException();
		
		for(String card: cards_str_arr){
			cards.add(new Card(card.charAt(0), card.charAt(1)));
		}
	}
	
}
