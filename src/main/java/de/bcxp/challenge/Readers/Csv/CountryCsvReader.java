package de.bcxp.challenge.Readers.Csv;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.csv.CSVRecord;

import de.bcxp.challenge.DataStructure.Country;
import de.bcxp.challenge.IoAdapters.CsvAdapter;
import de.bcxp.challenge.Utils.CsvColumnConfiguration;
import de.bcxp.challenge.Utils.FormatterUtils;

public class CountryCsvReader implements ICsvReader<Country> {
	
	private static Logger logger = LoggerFactory.getLogger(CountryCsvReader.class);
	
	@Override
	public List<Country> fetchData(Path file) {
		
		try {
			return CsvAdapter.read(file, this::parseEntry, ";");
		} catch (IOException e) {
			logger.error("Error occured while reading CSV file '" + file.getFileName() + "':", e);
			return new ArrayList<>();
		}
	}

	@Override
	public Country parseEntry(CSVRecord record) {
		try {
			var country = record.get(CsvColumnConfiguration.Country.COL_NAME_COUNTRY);
			var population = (long)Double.parseDouble(FormatterUtils.normalizeStringNumberInEuropeanFormat(record.get(CsvColumnConfiguration.Country.COL_NAME_POPULATION)));
			var areaInKm2 = Double.parseDouble(FormatterUtils.normalizeStringNumberInEuropeanFormat(record.get(CsvColumnConfiguration.Country.COL_NAME_AREA)));
			return new Country(
					country,
					population,
					areaInKm2);
		} catch(NumberFormatException e) {
			logger.error("Error while parsing numbers in country csv", e);
			return null;
		}
	}
}
