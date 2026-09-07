package de.bcxp.challenge.Readers.Csv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.csv.CSVRecord;

import de.bcxp.challenge.DataStructure.Weather;
import de.bcxp.challenge.IoAdapters.CsvAdapter;
import de.bcxp.challenge.Utils.CsvColumnConfiguration;

public class WeatherCsvReader implements ICsvReader<Weather> {
	
	private static Logger logger = LoggerFactory.getLogger(WeatherCsvReader.class);
	
	@Override
	public List<Weather> fetchData(Path file) {
		
		try {
			return CsvAdapter.read(file, this::parseEntry);
		} catch (IOException e) {
			logger.error("Error occured while reading CSV file '" + file.getFileName() + "':", e);
			return new ArrayList<>();
		}
	}

	@Override
	public Weather parseEntry(CSVRecord record) {
		try {
			var day = Integer.parseInt(record.get(CsvColumnConfiguration.Weather.COL_NAME_DAY));
			var minTemp = Integer.parseInt(record.get(CsvColumnConfiguration.Weather.COL_NAME_MIN_TEMPERATURE));
			var maxTemp = Integer.parseInt(record.get(CsvColumnConfiguration.Weather.COL_NAME_MAX_TEMPERATURE));
			return new Weather(
					day,
					minTemp,
					maxTemp);
		} catch(NumberFormatException e) {
			logger.error("Error while parsing numbers in weather csv", e);
			return null;
		}
	}

}
