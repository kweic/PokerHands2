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
	
	public void rankHands(){
		comparator.rankHand(player1Hand); //Black
		comparator.rankHand(player2Hand); //White
	}
	
	private String tieBreak(Hand hand1, Hand hand2){
		int tieBreak = 0;
		String result = "Tie.";
		while(tieBreak <= hand1.getCards().size()-1){
			CardValue hand1Card = hand1.getHighTieBreakCard(tieBreak);
			CardValue hand2Card = hand2.getHighTieBreakCard(tieBreak);
			System.out.println();
			tieBreak++;
			System.out.println(hand1+" .. "+ hand2);
			System.out.println("comparing: "+hand1Card+" to "+hand2Card);
			int tieBreakDifference = hand1Card.compareTo(hand2Card);
			System.out.println("tie break diff: "+tieBreakDifference);
			if(tieBreakDifference > 0){
				result = "Black wins.";
				break;
			}else if(tieBreakDifference < 0){
				result = "White wins.";
				break;
			}
		}
		return result;
	}
	
	public String determineWinner(){
		rankHands();
		String result = "";
		int playerScoreDifference = player1Hand.compareTo(player2Hand);
		System.out.println(player1Hand.getRank()+" "+player2Hand.getRank());
		if(playerScoreDifference == 0){
			result = tieBreak(player1Hand, player2Hand);
		}else if(playerScoreDifference > 0){
			result = "Black wins.";
		}else{
			result = "White wins.";
		}
		
		return result;
	}
	
	public String winnerDetails(boolean player1){
		String winDetails = "";
		if(player1){
			winDetails = getDetails(player1Hand);
		}else{
			winDetails = getDetails(player2Hand);
		}
		return winDetails;
	}
	
	private String getDetails(Hand hand){
		HandRank handRank = hand.getRank();
		String details = "";
		if(handRank == handRank.HIGHCARD){
			details = handRank.rank()+": "+hand.getCards().get(hand.getCards().size()-1).getValue();
		}else{
			details = handRank.rank();
		}
		return details;
	}
}
