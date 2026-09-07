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

public class CsvAdapter {
	
	public static <T> List<T> read(Path file, Function<CSVRecord, T> rowMapper) throws IOException, FileNotFoundException {
		List<T> result = new ArrayList<>();
		
		if(!file.toFile().exists()) {
			throw new FileNotFoundException();
		}
		
		try (Reader reader = Files.newBufferedReader(file);
				CSVParser parser = CSVFormat.DEFAULT.builder()
						.setHeader()
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
