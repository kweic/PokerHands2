package com.manifestcorp;


public class FizzBuzzer {
	
	static String printTo(int n){
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <= n; i++){
			sb.append(fizzBuzzForDivisibleNumbers(3,5,i));
			if(i!=n)sb.append("\n");
		}
		return sb.toString();
	}
	
	static String fizzBuzzForDivisibleNumbers(int fizz, int buzz, int i) {
		if(i == 0)return "0";
		if(i % (fizz*buzz) == 0)return "FizzBuzz";
		if(i % fizz == 0)return "Fizz";
		if(i % buzz == 0)return "Buzz";
		return i+"";
	}

}
