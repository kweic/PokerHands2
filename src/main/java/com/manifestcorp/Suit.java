package com.manifestcorp;

public enum Suit {
	DIAMOND("Diamond"),
	CLUB("Club"),
	HEART("Heart"),
	SPADE("Spade");

	private String suit;
	
	Suit(String suit){
		this.suit = suit;
	}
	public String suit(){
		return suit;
	}
}
