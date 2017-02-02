package com.manifestcorp;

import java.util.ArrayList;

public class CardsInputParser {
	
	public ArrayList<Card> makeCardArray(String string) {
		ArrayList<Card> cards = new ArrayList<Card>();
		String[] cards_str_arr = string.split(" ");
		
		for(String card: cards_str_arr){
			cards.add(makeCard(card));
		}
		return cards;
	}
	
	private Card makeCard(String card){
		return new Card(card.charAt(0), card.charAt(1));
	}

}
