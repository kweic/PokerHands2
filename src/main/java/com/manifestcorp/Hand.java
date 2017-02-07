package com.manifestcorp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Hand implements Comparable<Hand>{
	private ArrayList<Card> cards;
	private HandRank handRank;
	private Card highTieBreakCard;
	
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
	
	public Card getHighTieBreakCard(int n){
		Card tieBreakCard = null;
		if(handRank == handRank.ROYALFLUSH || 
				handRank == handRank.STRAIGHTFLUSH || 
				handRank == handRank.FLUSH || 
				handRank == handRank.STRAIGHT ||
				handRank == handRank.HIGHCARD){
			tieBreakCard = cards.get((cards.size()-1)-n);
		}else{
			tieBreakCard = cardSetTieBreaker(n);
		}
		return tieBreakCard;
	}
	
	private Card cardSetTieBreaker(int n) {
		ArrayList<Card> tieBreakerSets = new ArrayList<Card>();
		HashMap<Card, Integer> cardCounter = new HashMap<Card, Integer>();
		for(Card card: cards){
			if(cardCounter.containsKey(card)){
				cardCounter.put(card, cardCounter.get(card)+1);
			}else{
				cardCounter.put(card, 1);
			}
		}
		int setSize = cards.size();
		while(setSize > 0){
			for(Card card: cardCounter.keySet()){
				if(cardCounter.get(card) == setSize){
					tieBreakerSets.add(card);
				}
			}
			setSize--;
		}
		
		if(tieBreakerSets.size() < n){
			return tieBreakerSets.get(n);
		}
		return null;
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
