package com.manifestcorp;

public enum CardValue {
	ONE("Parka"),
	TWO("Short Sleeves"),
	THREE("Long Sleeves"),
	FOUR("Bathing Suit"),
	FIVE(""),
	SIX(""),
	SEVEN(""),
	EIGHT(""),
	NINE(""),
	TEN(""),
	JACK(""),
	QUEEN(""),
	KING(""),
	ACE("");
	
	private String cardValue;
	
	CardValue(String cardValue){
		this.cardValue = cardValue;
	}
	public String value(){
		return cardValue;
	}
}
