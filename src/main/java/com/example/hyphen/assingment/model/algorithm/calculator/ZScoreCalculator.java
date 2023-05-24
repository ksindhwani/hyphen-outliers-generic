package com.example.hyphen.assingment.model.algorithm.calculator;

public class ZScoreCalculator {
    private int count;
    private double mean;
    private double m2;

    private ZScoreCalculator() {
        count = 0;
        mean = 0.0;
        m2 = 0.0;
    } 

    public static ZScoreCalculator newZScoreCalculator() {
        return new ZScoreCalculator();
    }


    public void addDataPoint(double value) {
        count++;
        double delta = value - mean;
        mean += delta / count;
        double delta2 = value - mean;
        m2 += delta * delta2;
    }

    public double getZScore(double value) {
        return Math.abs((value-getMean())/getStandardDeviation());
    }

    private double getStandardDeviation() {
        if (count < 2) {
            return Double.NaN;
        }
        return Math.sqrt(m2 / (count - 1));
    }

    private double getMean() {
        return mean;
    }
}
