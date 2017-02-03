package com.manifestcorp;

import com.manifestcorp.weather.WeatherStation;

public class OutfitChooser{
	WeatherStation station;
	

	public Clothing recommendClothingBasedOnWeather() {
		int temperature = station.getTemperature();
		Clothing recommended = Clothing.PARKA;

		if(temperature > 95){
			recommended = Clothing.BATHINGSUIT;
		}else if(temperature > 70){
			recommended = Clothing.SHORTSLEEVE;
		}else if(temperature > 50){
			recommended = Clothing.LONGSLEEVE;
		}
		
		
		return recommended;
	}
}
