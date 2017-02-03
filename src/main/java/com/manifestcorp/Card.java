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
		return value.name()+""+suit.name();
	}

	@Override
	public int compareTo(Card o) {
		return o.getValue().ordinal() - value.ordinal();
	}

}
