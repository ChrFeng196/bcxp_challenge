package de.bcxp.challenge;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import de.bcxp.challenge.Service.CountryService;
import de.bcxp.challenge.Service.WeatherService;

/**
 * The entry class for your solution. This class is only aimed as starting point and not intended as baseline for your software
 * design. Read: create your own classes and packages as appropriate.
 */
public final class App {

    /**
     * This is the main entry method of your program.
     * @param args The CLI arguments passed
     * @throws URISyntaxException 
     */
    public static void main(String... args) throws URISyntaxException {
    	
    	// Determine the file paths of the different CSV files
    	URL weatherUrl = App.class.getResource("/de/bcxp/challenge/weather.csv");
    	Path weatherFilePath = Paths.get(weatherUrl.toURI());
    	
    	URL countriesUrl = App.class.getResource("/de/bcxp/challenge/countries.csv");
    	Path countriesFilePath = Paths.get(countriesUrl.toURI());

        // Init services
    	WeatherService weatherService = new WeatherService();
    	CountryService countryService = new CountryService();

        String dayWithSmallestTempSpread = "" + weatherService.fetchDayWithSmallestTemperatureSpread(weatherFilePath);
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = countryService.fetchCountryWithHighestPopulationDensity(countriesFilePath);
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
