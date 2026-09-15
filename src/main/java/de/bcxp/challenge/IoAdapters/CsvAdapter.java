package de.bcxp.challenge.IoAdapters;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.bcxp.challenge.Readers.Csv.CountryCsvReader;

public class CsvAdapter {

	private static Logger logger = LoggerFactory.getLogger(CsvAdapter.class);
	
	public static <T> List<T> read(Path file, Function<CSVRecord, T> rowMapper, String delimiter) throws IOException, FileNotFoundException {
		List<T> result = new ArrayList<>();
		
		if(!file.toFile().exists()) {
			logger.error("CSV file '" + file.toString() + "'");
			throw new FileNotFoundException();
		}
		
		try (Reader reader = Files.newBufferedReader(file);
				CSVParser parser = CSVFormat.DEFAULT.builder()
						.setHeader()
						.setDelimiter(delimiter)
						.setSkipHeaderRecord(true)
						.get()
						.parse(reader)) {
			for (CSVRecord record : parser) {
				result.add(rowMapper.apply(record));
			}
        }
        return result;
    }
}
