package com.example.hyphen.assingment;

import java.util.List;

import com.example.hyphen.assingment.model.Point;

public class OutlierRemover {

    public boolean removeOutliers(List<Point> dataPoints , List<Point> outliers) {
        return dataPoints.removeAll(outliers);

    }
}
