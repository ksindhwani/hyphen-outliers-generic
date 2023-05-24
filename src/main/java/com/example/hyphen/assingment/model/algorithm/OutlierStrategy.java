package com.example.hyphen.assingment.model.algorithm;

import java.util.List;

import com.example.hyphen.assingment.model.Point;

public interface OutlierStrategy {
    
    public List<Point> detectOutliersPoints(List<Point> points);
}
