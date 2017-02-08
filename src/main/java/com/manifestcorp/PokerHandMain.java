package com.manifestcorp;

import java.util.Scanner;

public class PokerHandMain {

	public static void main(String[] args) {
		PokerGame pokerGame = new PokerGame();
		Scanner reader = new Scanner(System.in);
		int player1Win = 0;
		String nextLine = reader.nextLine();
		while(!nextLine.isEmpty()){
			pokerGame.passInput(nextLine);
			String printWin = pokerGame.printWinner();
			if(printWin.contains("Black win")){
				player1Win++;
			}
			System.out.println(printWin);
			nextLine = reader.nextLine();
		}
		System.out.println(player1Win);
		//376
	}

}
