package com.manifestcorp;

public class NumberPrinter{
	
	public static void main(String[] args){
		
		int n;
		
		try{
			n = Integer.parseInt(args[0]);
			printNumbersWithStar(n);
		}catch (Exception e){
			System.out.println("No number passed in argument..");
			return;
		}
	
	}
	
	static void printNumbers(int n){
		for(int i = 0; i <= n; i++){
			System.out.println(i);
		}
	}
	
	static void printNumbersWithStar(int n){
		int starSpaceMax = 20;
		int starSpaceCount = 0;
		boolean addingGap = true;
			
		for(int i = 0; i <= n; i++){
			
			if(i % 3 == 0){
				if(addingGap){
					starSpaceCount++;
					if(starSpaceCount > starSpaceMax)addingGap = !addingGap;
				}else{
					starSpaceCount--;
					if(starSpaceCount < 0)addingGap = !addingGap;
				}
			}
			
			System.out.println(i+appendStarWithGap(starSpaceCount));
			try{
				Thread.sleep(10);
			}catch(Exception e){
				//ignore
			}
			
		}
	}
	
	
	static String appendStarWithGap(int gapSize){
		StringBuilder sb = new StringBuilder();
		int i = 0;
		while(i < gapSize){
			sb.append(" ");
			i++;
		}
		sb.append("*");
		return sb.toString();
	}

}