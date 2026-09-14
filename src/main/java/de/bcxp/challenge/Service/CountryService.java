package de.bcxp.challenge.Service;

import java.nio.file.Path;
import java.util.Comparator;
import java.util.Optional;

import de.bcxp.challenge.DataStructure.Country;
import de.bcxp.challenge.Readers.Csv.CountryCsvReader;

public class CountryService {
	
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
		return "None";
	}
}
