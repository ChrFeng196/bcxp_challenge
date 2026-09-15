package de.bcxp.challenge.Service;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bcxp.challenge.DataStructure.Country;
import de.bcxp.challenge.Readers.Csv.CountryCsvReader;

public class CountryService {
	
	private static Logger logger = LoggerFactory.getLogger(CountryService.class);
	
	private CountryCsvReader countryCsvReader;
	
	public CountryService() {
		this.countryCsvReader = new CountryCsvReader();
	}
	
	public String fetchCountryWithHighestPopulationDensity(Path file) {
		var countryData = this.countryCsvReader.fetchData(file);
		
		Optional<Country> highestPopulationDensity = countryData.stream().max(Comparator.comparingDouble(Country::calculatePopulationDensity));
		if(highestPopulationDensity.get() != null) {
			return highestPopulationDensity.get().getName();
		}
		logger.warn("No country with highest population density could be found");
		return "None";
	}
}
