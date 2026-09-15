package de.bcxp.challenge.Service;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bcxp.challenge.DataStructure.Weather;
import de.bcxp.challenge.Readers.Csv.WeatherCsvReader;

public class WeatherService {
	
	private static Logger logger = LoggerFactory.getLogger(WeatherService.class);
	
	private WeatherCsvReader weatherCsvReader;
	
	public WeatherService() {
		this.weatherCsvReader = new WeatherCsvReader();
	}
	
	public int fetchDayWithSmallestTemperatureSpread(Path file) {
		var weatherData = this.weatherCsvReader.fetchData(file);
		
		Optional<Weather> smallestSpreadWeather = weatherData.stream().min(Comparator.comparingInt(Weather::getTemperatureSpread));
		if(smallestSpreadWeather.get() != null) {
			return smallestSpreadWeather.get().getDay();
		}
		logger.warn("No day with smallest temperature spread could be found");
		return -1;
	}
}
