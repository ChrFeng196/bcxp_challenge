package de.bcxp.challenge;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

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
    	URL url = App.class.getResource("/de/bcxp/challenge/weather.csv");
    	Path weatherFilePath = Paths.get(url.toURI());

        // Your preparation code …
    	WeatherService weatherService = new WeatherService();

        String dayWithSmallestTempSpread = "" + weatherService.fetchDayWithSmallestTemperatureSpread(weatherFilePath);
        System.out.printf("Day with smallest temperature spread: %s%n", dayWithSmallestTempSpread);

        String countryWithHighestPopulationDensity = "Some country"; // Your population density analysis function call …
        System.out.printf("Country with highest population density: %s%n", countryWithHighestPopulationDensity);
    }
}
