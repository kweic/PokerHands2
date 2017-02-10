package com.manifestcorp;

import java.util.Scanner;

public class PokerHandMain {

	public static void main(String[] args) {
		PokerGame pokerGame = new PokerGame();
		Scanner reader = new Scanner(System.in);
//		int player1Win = 0;
		String nextLine = reader.nextLine();
		while(!nextLine.isEmpty()){
			pokerGame.passInput(nextLine);
			String printWin = pokerGame.printWinner();
			System.out.println(printWin);
//			if(printWin.contains("Black win")){
//				player1Win++;
//			}
			
			nextLine = reader.nextLine();
		}
		//System.out.println(player1Win);
		//376
	}

}
