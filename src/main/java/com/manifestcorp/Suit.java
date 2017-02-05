package com.manifestcorp;

public enum Suit {
	DIAMOND('D'),
	CLUB('C'),
	HEART('H'),
	SPADE('S');

	private char suit;
	
	Suit(char suit){
		this.suit = suit;
	}
	public char suit(){
		return suit;
	}
	
	public static Suit permissiveValueOf(char suitCompare){
		//used for easy assignment of card by char to appropriate enum
		for(Suit s: values()){
			if(s.suit == suitCompare){
				return s;
			}
		}
		return null;
	}
}
