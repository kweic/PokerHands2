package com.manifestcorp;

import java.util.ArrayList;
import java.util.Collections;

public class Hand implements Comparable<Hand>{
	private ArrayList<Card> cards;
	private HandRank handRank;
	
	public Hand(String cards_String){
		String[] cards_arr = cards_String.split(" ");
		if(cards_String.isEmpty() || cards_arr.length != 5){
			throw new IllegalArgumentException();
		}
		
		cards = new ArrayList<Card>();
		handRank = handRank.UNRANKED;
		
		for(String card: cards_arr){
			cards.add(new Card(CardValue.permissiveValueOf(card.charAt(0)), Suit.permissiveValueOf(card.charAt(1))));
		}
		
		Collections.sort(cards);
	}
	
	public void setHandRank(HandRank rank){
		this.handRank = rank;
	}
	
	public HandRank getRank(){
		return handRank;
	}
	
	public ArrayList<Card> getCards() {
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

	@Override
	public int compareTo(Hand compare) {
		return this.handRank.ordinal() - compare.getRank().ordinal();
	}
	
}
