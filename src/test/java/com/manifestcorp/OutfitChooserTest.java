package com.manifestcorp;
import static org.easymock.EasyMock.*;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.manifestcorp.weather.WeatherStation;

public class OutfitChooserTest {

	private OutfitChooser outfitChooser;
	private WeatherStation mockWeatherStation; //interface to mock
	
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
		assertEquals(Clothing.PARKA, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	@Test
	public void testTempFrom50to70ForLongSleeves() {
		expect(mockWeatherStation.getTemperature()).andReturn(60);
		replay(mockWeatherStation);
		assertEquals(Clothing.LONGSLEEVE, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	@Test
	public void testTempFrom70to95ForShortSleeves() {
		expect(mockWeatherStation.getTemperature()).andReturn(75);
		replay(mockWeatherStation);
		assertEquals(Clothing.SHORTSLEEVE, outfitChooser.recommendClothingBasedOnWeather());
	}
	
	@Test
	public void testTempOver95ForBathingSuit() {
		expect(mockWeatherStation.getTemperature()).andReturn(100);
		replay(mockWeatherStation);
		assertEquals(Clothing.BATHINGSUIT, outfitChooser.recommendClothingBasedOnWeather());
	}


}
