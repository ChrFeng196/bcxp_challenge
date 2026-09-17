package de.bcxp.challenge;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import de.bcxp.challenge.DataStructure.Country;
import de.bcxp.challenge.Readers.Csv.CountryCsvReader;
import de.bcxp.challenge.Readers.Csv.WeatherCsvReader;
import de.bcxp.challenge.Service.CountryService;
import de.bcxp.challenge.Service.WeatherService;

public class TestCountryService {
	
	private Path countriesFilePath;
	private Path countriesEmptyFilePath;
    private CountryCsvReader countryCsvReader;
    private CountryService countryService;

    @BeforeEach
    void setUp() throws URISyntaxException {
    	//For simplicity, we keep the test data in the same resource folder
		URL url = App.class.getResource("/de/bcxp/challenge/countries_test.csv");
    	countriesFilePath = Paths.get(url.toURI());
    	
    	URL urlEmptyFile = App.class.getResource("/de/bcxp/challenge/countries_test_empty.csv");
    	countriesEmptyFilePath = Paths.get(urlEmptyFile.toURI());
    	
    	countryCsvReader = new CountryCsvReader();
    	countryService = new CountryService();
    }
    
    
    
    /*
     * Test calculating the population density
     */
    @Test
    public void TestCalculatingPopulationDensity() {
    	Country country = new Country("TestCountry", 1000, 500);
    	var populationDensity = country.calculatePopulationDensity();
    	
    	assertTrue(populationDensity == 2, "Population density calculation failed");
    }
	
    /**
     * This test makes sure that the CSV reader is reading the CSV file and parsing the content into the Weather object correctly
     */
	@Test
	public void TestCountryCsvReader() {
		//Check empty file
		var countryDataEmpty = countryCsvReader.fetchData(countriesEmptyFilePath);
		assertTrue(countryDataEmpty.size() == 0);
		
		//Test CSV contains different number formatting too so that we can check whether the string number parsing worked well
    	var countryData = countryCsvReader.fetchData(countriesFilePath);
    	
    	//Check whether all data were read
    	assertTrue(countryData.size() == 3, "Reading CSV country data failed because of incorrect amount of country data");
    	
    	//Test correct parsing
    	for(var country : countryData) {
    		var name = country.getName();
    		assertTrue(name != null && name.length() > 0, "Country name has to be not null and not blank");
    		
    		var population = country.getPopulation();
    		assertTrue(population > 0, "Population needs to be larger than 0");
    		
    		var area = country.getArea_inSquareKm();
    		assertTrue(area > 0, "Area needs to be larger than 0.0");
    	}
	}
	
	/**
	 * This test makes sure that the function to determine the country with the highest population density
	 */
	@Test
	public void TestDeterminingDayWithSmallestSpread() {
		var countryNameWithHighestPopulationDensity = countryService.fetchCountryWithHighestPopulationDensity(countriesFilePath);
		
		assertTrue(countryNameWithHighestPopulationDensity.equals("Belgium"));
	}
}
