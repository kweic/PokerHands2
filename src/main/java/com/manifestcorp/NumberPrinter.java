package com.manifestcorp;

public class NumberPrinter{
	
	public static void main(String[] args){
		System.out.println("Number printing started");
		
		int n;
		
		try{
			n = Integer.parseInt(args[0]);
		}catch (Exception e){
			return;
		}
			
		for(int i = 0; i <= n; i++){
			System.out.println(i);
		}
	}

}