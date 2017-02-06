package com.manifestcorp;


public class PokerGame {
	String player1;
	String player2;
	Hand player1Hand;
	Hand player2Hand;
	public PokerGame(){
		
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
	
	
}
