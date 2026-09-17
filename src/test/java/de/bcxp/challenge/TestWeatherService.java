package de.bcxp.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import de.bcxp.challenge.Readers.Csv.WeatherCsvReader;
import de.bcxp.challenge.Service.WeatherService;

public class TestWeatherService {
	
	private Path weatherFilePath;
	private Path weatherEmptyFilePath;
    private WeatherCsvReader weatherCsvReader;
    private WeatherService weatherService;

    @BeforeEach
    void setUp() throws URISyntaxException {
    	//For simplicity, we keep the test data in the same resource folder
		URL url = App.class.getResource("/de/bcxp/challenge/weather_test.csv");
    	weatherFilePath = Paths.get(url.toURI());
    	
    	URL urlEmptyFile = App.class.getResource("/de/bcxp/challenge/weather_test_empty.csv");
    	weatherEmptyFilePath = Paths.get(urlEmptyFile.toURI());
    	
    	weatherCsvReader = new WeatherCsvReader();
    	weatherService = new WeatherService();
    }
	
    /**
     * This test makes sure that the CSV reader is reading the CSV file and parsing the content into the Weather object correctly
     */
	@Test
	public void TestWeatherCsvReader() {
		//Check empty file
		var weatherDataEmpty = weatherCsvReader.fetchData(weatherEmptyFilePath);
		assertTrue(weatherDataEmpty.size() == 0);
		
    	var weatherData = weatherCsvReader.fetchData(weatherFilePath);
    	
    	//Check whether all data were read
    	assertTrue(weatherData.size() == 3, "Reading CSV weather data failed because of incorrect amount of weather data");
    	
    	//Test correct parsing
    	for(var weather : weatherData) {
    		var day = weather.getDay();
    		assertTrue(day > 0, "Incorrect day number");
    		
    		var minTemp = weather.getMinimumTemperature();
    		var maxTemp = weather.getMaximumTemperature();
    		assertTrue(maxTemp >= minTemp, "Wrong maximum and minimum temperature order");
    	}
	}
	
	/**
	 * This test makes sure that the function to determine the day with the smallest temperature spread works properly
	 */
	@Test
	public void TestDeterminingDayWithSmallestSpread() {
		var dayWithSmallestSpread = weatherService.fetchDayWithSmallestTemperatureSpread(weatherFilePath);
		
		assertTrue(dayWithSmallestSpread == 2);
	}
}
