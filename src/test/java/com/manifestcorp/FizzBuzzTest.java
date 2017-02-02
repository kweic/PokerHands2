package com.manifestcorp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class FizzBuzzTest {
    private int FIZZ = 3;
    private int BUZZ = 5;
	private FizzBuzzer fizzBuzzer;
	private final String COUNT_TO_20 = "1\n2\nFizz\n4\nBuzz\nFizz\n7\n8\nFizz\nBuzz\n11\nFizz\n13\n14\nFizzBuzz\n16\n17\nFizz\n19\nBuzz";

	@Before
	public void init(){
		fizzBuzzer = new FizzBuzzer();
	}
	
	@Test
	public void countNumberOfOutputLines(){
		int lineCount = fizzBuzzer.printFizzBuzzToNumber(100).split("\n").length;
		assertEquals("testing line count of printed list ", 100, lineCount);
	}
	
	@Test
	public void testUpToTwentyIsCorrect(){
		assertEquals("testing to twenty from sample output ", COUNT_TO_20, fizzBuzzer.printFizzBuzzToNumber(20));
	}
	
	@Test
	public void test0ShouldReturn0(){
		assertEquals("0 should return 0 ", "0", fizzBuzzer.fizzBuzzForDivisibleNumbers(FIZZ, BUZZ, 0));
	}
	@Test
	public void test3isFizz() {
		assertEquals("3 should be Fizz ", "Fizz", fizzBuzzer.fizzBuzzForDivisibleNumbers(FIZZ, BUZZ, 3));
	}
	
	@Test
	public void test5isBuzz(){
		assertEquals("5 should be Buzz ", "Buzz", fizzBuzzer.fizzBuzzForDivisibleNumbers(FIZZ, BUZZ, 5));
	}
	
	@Test
	public void testDivisibleByBothIsFizzBuzz(){
		assertEquals("15 should be fizzbuzz ", "FizzBuzz", fizzBuzzer.fizzBuzzForDivisibleNumbers(FIZZ, BUZZ, 15));
	}
	
	@Test
	public void testEmptyStringIfNotDivisibleBy3or5(){
		assertEquals("non divisible should be number", "4", fizzBuzzer.fizzBuzzForDivisibleNumbers(FIZZ, BUZZ, 4));
	}

}
