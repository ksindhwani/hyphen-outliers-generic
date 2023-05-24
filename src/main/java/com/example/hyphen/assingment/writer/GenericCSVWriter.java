package com.example.hyphen.assingment.writer;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

public class GenericCSVWriter<T> {
    private static final String SAMPLE_CSV_FILE = "./cleanData.csv";
    private Writer writer;

    public GenericCSVWriter () throws IOException {
        writer = new FileWriter(SAMPLE_CSV_FILE);   
    }

    public void writeToCSV(List<T> dataPoints) throws IOException {
        String[] headers = { "Date", "Price"};
        List<String> data = convertToCSVFormatData(dataPoints);
        writeDataToCSV(data,headers );
    }

    private void writeDataToCSV(List<String> data, String[] headers) throws IOException {
        CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
        .setHeader(headers)
        .build();

        try (CSVPrinter printer = new CSVPrinter(writer, csvFormat)) {
            printer.printRecords(data);
            printer.flush();
        }
    }

    private List<String> convertToCSVFormatData(List<T> dataPoints) {
        return dataPoints.stream().map(dataPoint -> dataPoint.toString()).collect(Collectors.toList());
    }
}
