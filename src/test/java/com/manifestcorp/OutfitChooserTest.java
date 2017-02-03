package com.manifestcorp;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.manifestcorp.weather.WeatherStation;
import com.manifestcorp.weather.WeatherStationImpl;

public class OutfitChooserTest {

	private OutfitChooser outfitChooser;
	private WeatherStation mockWeatherStation; //interface to mock
	private String PARKA_RECOMMEND = "Wear a Parka, it's less than 50 degrees";
	private String LONGSLEEVE_RECOMMEND = "Wear Long Sleeves, it's between 50 and 70";
	private String SHORTSLEEVE_RECOMMEND = "Wear Short Sleeves, it's between 70 and 95";
	private String BATHINGSUIT_RECOMMEND = "Wear a Bathing Suit, it's over 95";
	
	@Before
	public void init(){
		outfitChooser = new OutfitChooser();
		mockWeatherStation = createMock(WeatherStation.class);
		outfitChooser.station = mockWeatherStation;
	}
	
	@After
	public void after() throws Exception{
		verify(mockWeatherStation);
	}
	
	@Test
	public void testTempLessThan50ForParka() {
		expect(mockWeatherStation.getTemperature()).andReturn(10);
		replay(mockWeatherStation);
		assertEquals(PARKA_RECOMMEND, outfitChooser.recommendClothingBasedOnWeather());
		
	}
	
	@Test
	public void testTempFrom50to70ForLongSleeves() {
		expect(mockWeatherStation.getTemperature()).andReturn(60);
		replay(mockWeatherStation);
		assertEquals(LONGSLEEVE_RECOMMEND, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	@Test
	public void testTempFrom70to95ForShortSleeves() {
		expect(mockWeatherStation.getTemperature()).andReturn(75);
		replay(mockWeatherStation);
		assertEquals(SHORTSLEEVE_RECOMMEND, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	@Test
	public void testTempOver95ForBathingSuit() {
		
		expect(mockWeatherStation.getTemperature()).andReturn(100);
		replay(mockWeatherStation);
		assertEquals(BATHINGSUIT_RECOMMEND, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	//todo, edge cases for each temperature
	//test temperature not found

}
