package com.manifestcorp;

import com.manifestcorp.weather.WeatherStation;

public class OutfitChooser{
	WeatherStation station;
	private String PARKA_RECOMMEND = "Wear a Parka, it's less than 50 degrees";
	private String LONGSLEEVE_RECOMMEND = "Wear Long Sleeves, it's between 50 and 70";
	private String SHORTSLEEVE_RECOMMEND = "Wear Short Sleeves, it's between 70 and 95";
	private String BATHINGSUIT_RECOMMEND = "Wear a Bathing Suit, it's over 95";
	
	public OutfitChooser(){
		
	}

	public String recommendClothingBasedOnWeather() {
		if(station == null)return PARKA_RECOMMEND;
		int temperature = station.getTemperature();
		if(temperature < 50)return LONGSLEEVE_RECOMMEND;
		if(temperature >= 50 && temperature <= 70)return "Wear Long Sleeves, it's between 50 and 70";
		if(temperature > 70 && temperature <= 95)return "Wear Short Sleeves, it's between 70 and 95";
		return "Wear a Bathing Suit, it's over 95";
	}
}
