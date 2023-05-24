package com.example.hyphen.assingment.datasource;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.csv.CSVRecord;
import com.example.hyphen.assingment.model.Point;
import com.example.hyphen.assingment.parser.CSVParser;

public class CSVDataSource extends DataSource {

    private CSVParser parser;

    public CSVDataSource(String filePath) throws FileNotFoundException {
        parser = CSVParser.newCSVParser(filePath);
    }

    // private static final Logger logger =
    // LogManager.getLogger(CSVDataSource.class);

    @Override
    public List<Point> getDataFromSource() {

        List<Point> dataPoints = new ArrayList<>();
        try {
            Iterable<CSVRecord> records = parser.fetchRecords();
            for (CSVRecord csvRecord : records) {
                // Accessing values by column name
                Point dataPoint = new Point(csvRecord.get("Date"), csvRecord.get("Price"));
                dataPoints.add(dataPoint);
            }
            return dataPoints;
        } catch (IOException e) {
            // logger.info("No csv file found at configured path");
        }
        return new ArrayList<>(0);
    }

}
