package com.manifestcorp;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	boolean isBlack; //black or white
	
	public Hand(boolean isBlack, String cardsStr){
		cards = new ArrayList<Card>();
		String[] cards_str_arr = cardsStr.split(" ");
		
		for(String card: cards_str_arr){
			cards.add(new Card(card.charAt(0), card.charAt(1)));
		}
		
		this.isBlack = isBlack;
	}
	
}
