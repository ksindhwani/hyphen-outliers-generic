package com.example.hyphen.assingment.model;

public class Point {
    String date;
    double price;
    public Point() {}
    public Point(String date, String price) {
        this.date = date;
        this.price = Double.parseDouble(price);
    }

    
    public String getDate() {
        return date;
    }
    public double getPrice() {
        return price;
    }
    
    /*@Override
    public String toString() {
        return "Point [date=" + date + ", price=" + price + "]";
    }*/

    public String toString() {
        return date + "," + price;
    }
}
