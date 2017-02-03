package com.manifestcorp;

public enum Clothing{
	PARKA("Parka"),
	SHORTSLEEVE("Short Sleeves"),
	LONGSLEEVE("Long Sleeves"),
	BATHINGSUIT("Bathing Suit");
	
	private String clothing;
	
	Clothing(String clothing){
		this.clothing = clothing;
	}
	public String clothing(){
		return clothing;
	}
}
