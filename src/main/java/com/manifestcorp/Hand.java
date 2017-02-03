package com.manifestcorp;

import java.util.ArrayList;
import java.util.Collections;

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
		
		Collections.sort(cards);
	}
	
	public ArrayList<Card> getCards() {
		// TODO Auto-generated method stub
		return cards;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for(Card card: cards){
			sb.append(card.getValue().value()+""+card.getSuit().suit()+" ");
		}
		return sb.toString().substring(0, sb.toString().length()-1);
	}
	
}
