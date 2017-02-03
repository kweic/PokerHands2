package com.manifestcorp;

public class Card {
	private Suit suit;
	private CardValue value;
	
	public Card(CardValue value, Suit suit) {
		this.value = value;
		this.suit = suit;
	}
	
	public Suit getSuit(){
		return suit;
	}
	
	public CardValue getValue(){
		return value;
	}

}
