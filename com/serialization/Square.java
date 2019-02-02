package com.serialization;

public class Square implements Figure {
    public String name;
    private int sideLength;
    public double square;

    public Square(String name, int sideLength) {
        this.name = name;
        this.sideLength = sideLength;
        this.square = calculateSquare();
    }

    public String getName() {
        return name;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public double calculateSquare() {
        return Math.pow(sideLength, 2);
    }
}
