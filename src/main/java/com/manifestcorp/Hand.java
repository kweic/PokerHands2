package com.manifestcorp;

import java.util.ArrayList;

public class Hand {
	ArrayList<Card> cards;
	boolean isBlack; //black or white
	
	public Hand(boolean isBlack, ArrayList<Card> cards){
		this.cards = cards;
		this.isBlack = isBlack;
	}
	
}
