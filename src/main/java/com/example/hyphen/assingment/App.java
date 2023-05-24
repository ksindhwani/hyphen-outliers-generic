package com.example.hyphen.assingment;

import java.io.IOException;
import java.util.List;

import com.example.hyphen.assingment.config.ApplicationProperties;
import com.example.hyphen.assingment.datasource.DataSource;
import com.example.hyphen.assingment.model.Point;
import com.example.hyphen.assingment.writer.GenericCSVWriter;
import com.example.hyphen.assingment.writer.OutlierCSVWriter;

/**
 * Main Class to for the entry point of the program
 *
 */
public class App {
    // private static final Logger logger = LogManager.getLogger(App.class);

    public static void main(String[] args) {
        // BasicConfigurator.configure();
        try {
            ApplicationProperties properties = new ApplicationProperties();
            List<Point> dataPoints = getDataPoints(properties);
            List<Point> outliers = detectOutliers(dataPoints, properties.getAlgorithm());
            outliers.stream().map(outlier -> outlier.toString()).forEach(System.out::println);
            if(removeOutliers(dataPoints, outliers)) {
                writeCleanDataToCSV(dataPoints);
            }
        } catch (IOException ioEx) {
            // logger.info("Unable to fetch file - " + ioEx.getMessage());
        } catch (Exception ex) {
            // logger.info(ex.getMessage());
        }
    }

    private static void writeCleanDataToCSV(List<Point> dataPoints) throws IOException {
        //OutlierCSVWriter writer = new OutlierCSVWriter();
        GenericCSVWriter<Point> writer = new GenericCSVWriter<>();
        writer.writeToCSV(dataPoints);
    }

    private static boolean removeOutliers(List<Point> dataPoints, List<Point> outliers) {
        OutlierRemover remover = new OutlierRemover();
        return remover.removeOutliers(dataPoints, outliers);
    }

    private static List<Point> detectOutliers(List<Point> dataPoints, String algorithm) throws Exception {
        OutlierDetector detector = new OutlierDetector();
        return detector.detectOutliers(dataPoints, algorithm);
    }

    private static List<Point> getDataPoints(ApplicationProperties properties) throws Exception {
        DataSource datasource = DataSource.getDataSource(properties);
        return datasource.getDataFromSource();
    }

}
