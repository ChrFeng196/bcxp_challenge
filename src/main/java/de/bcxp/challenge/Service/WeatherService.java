package de.bcxp.challenge.Service;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

import de.bcxp.challenge.DataStructure.Weather;
import de.bcxp.challenge.Readers.Csv.WeatherCsvReader;

public class WeatherService {
	
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
		return -1;
	}
}
