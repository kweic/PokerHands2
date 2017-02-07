package com.manifestcorp;


public class PokerGame {
	String player1;
	String player2;
	Hand player1Hand;
	Hand player2Hand;
	PokerHandComparator comparator;
	public PokerGame(){
		comparator = new PokerHandComparator();
	}
	
	public void passInput(String input){
		String[] inputArr = input.split("  ");
		String[] player1Arr = inputArr[0].split(": ");
		String[] player2Arr = inputArr[1].split(": ");
		
		player1 = player1Arr[0];
		player2 = player2Arr[0];
		player1Hand = new Hand(player1Arr[1]);
		player2Hand = new Hand(player2Arr[1]);
	}
	
	public String determineWinner(){
		comparator.rankHand(player1Hand); //black
		comparator.rankHand(player2Hand); //white
		String result = "";
		int playerScoreDifference = player1Hand.compareTo(player2Hand);
		if(playerScoreDifference == 0){
			result = "Tie.";
		}else if(playerScoreDifference > 0){
			result = "Black wins.";
		}else{
			result = "White wins.";
		}
		
		return result;
	}
}
