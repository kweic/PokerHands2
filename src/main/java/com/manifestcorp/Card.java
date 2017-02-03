package com.manifestcorp;

public class Card implements Comparable<Card>{
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
	
	@Override
	public String toString(){
		return value.value()+""+suit.suit();
	}

	@Override
	public int compareTo(Card compare) {
		return this.value.ordinal() - compare.getValue().ordinal();
	}

}
