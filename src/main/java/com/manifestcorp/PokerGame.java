package com.manifestcorp;


public class PokerGame {
	String player1;
	String player2;
	Hand player1Hand;
	Hand player2Hand;
	PokerHandComparator comparator;
	String MESSAGE_TIE = "Tie.";
	String MESSAGE_PLAYER1WIN = "Black wins.";
	String MESSAGE_PLAYER2WIN = "White wins.";
	//private CardValue tieBreakCard;
	
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
		String result = MESSAGE_TIE;
		while(tieBreak <= hand1.getCards().size()-1){
			CardValue hand1Card = hand1.getHighTieBreakCard(tieBreak);
			CardValue hand2Card = hand2.getHighTieBreakCard(tieBreak);

			tieBreak++;

			int tieBreakDifference = hand1Card.compareTo(hand2Card);
			
				
			if(tieBreakDifference > 0){
				result = MESSAGE_PLAYER1WIN;
				hand1.setTieBreakCard(hand1Card);
				break;
			}else if(tieBreakDifference < 0){
				result = MESSAGE_PLAYER2WIN;
				hand2.setTieBreakCard(hand2Card);
				break;
			}
		}
		return result;
	}
	
	public String determineWinner(){
		rankHands();
		String result = "";
		int playerScoreDifference = player1Hand.compareTo(player2Hand);

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
			details = handRank.rank()+": "+hand.getTieBreakCard();
		}else{
			details = handRank.rank();
		}
		return details;
	}

	public String printWinner() {
		String winPrint = determineWinner();
		if(winPrint.equals(MESSAGE_PLAYER1WIN)){
			winPrint += " - with "+winnerDetails(true);
		}else if(winPrint.equals(MESSAGE_PLAYER2WIN)){
			winPrint += " - with "+winnerDetails(false);
		}

		return winPrint;
	}
}
