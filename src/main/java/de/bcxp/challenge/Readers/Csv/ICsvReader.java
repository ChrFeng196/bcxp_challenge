package de.bcxp.challenge.Readers.Csv;

import java.nio.file.Path;
import java.util.List;

import org.apache.commons.csv.CSVRecord;

public interface ICsvReader<T> {
	public List<T> fetchData(Path file);
	public T parseEntry(CSVRecord record);
}
