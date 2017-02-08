package com.manifestcorp;

import java.util.Scanner;

public class PokerHandMain {

	public static void main(String[] args) {
		PokerGame pokerGame = new PokerGame();
		Scanner reader = new Scanner(System.in);
		
		while(reader.hasNext()){
			pokerGame.passInput(reader.nextLine());
			System.out.println(pokerGame.printWinner());
		}

	}

}
