package com.manifestcorp;

import java.util.ArrayList;

class AwesomeList{
	private ArrayList<String> myList;
	private int listSize;
	
	public AwesomeList(int size){
		this.listSize = size;
		myList = new ArrayList();
	}
	
	public String getItem(int n){
		//todo: make this, out of index returns "not found"
		try{
			return myList.get(n);
		}catch (Exception e){
			return "not found";
		}
	}
	
	public void fillList(){
		String[] animals = new String[]{"cat", "dog", "bird", "fish", "unicorn"};
		int animalIndex = 0;
		for(int i = 0; i <= listSize; i++){
			if(animalIndex >= animals.length)animalIndex = 0;
			myList.add(animals[animalIndex]);
		}
	}
	
	public int getDefaultSize(){
		myList = new ArrayList();
		return myList.size();
	}
}