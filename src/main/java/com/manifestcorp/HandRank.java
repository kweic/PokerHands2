package com.manifestcorp;

public enum HandRank {
	UNRANKED("Not Ranked"),
	HIGHCARD("High Card"),
	ONEPAIR("One Pair"),
	TWOPAIR("Two Pair"),
	THREEOFAKIND("Three of a Kind"),
	STRAIGHT("Straight"),
	FLUSH("Flush"),
	FULLHOUSE("Full House"),
	FOUROFAKIND("Four of a Kind"),
	STRAIGHTFLUSH("Straight Flush"),
	ROYALFLUSH("Royal Flush");

	private String handRank;
	
	HandRank(String rank){
		this.handRank = rank;
	}
	
	public String rank(){
		return handRank;
	}
	
	public static HandRank permissiveValueOf(char rankCompare){
		for(HandRank r: values()){
			if(r.handRank.equals(rankCompare)){
				return r;
			}
		}
		return null;
	}
}
