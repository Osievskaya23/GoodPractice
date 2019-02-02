package com.serialization;

public class Triangle implements Figure {
    public String name;
    private int firstSideLength;
    private int secondSideLength;
    private int thirdSideLength;
    public double square;

    public Triangle(String name, int firstSideLength, int secondSideLength, int thirdSideLength) {
        this.name = name;
        this.firstSideLength = firstSideLength;
        this.secondSideLength = secondSideLength;
        this.thirdSideLength = thirdSideLength;
        this.square = calculateSquare();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public double calculateSquare() {
        double square = 0;
        if(firstSideLength + secondSideLength > thirdSideLength &&
                firstSideLength + thirdSideLength > secondSideLength &&
                secondSideLength + thirdSideLength > firstSideLength) {
            int p = (firstSideLength + secondSideLength + thirdSideLength) / 2;
            square = Math.sqrt(p * (p - firstSideLength) * (p - secondSideLength) * (p - thirdSideLength));
        } else {
            System.out.println("Triangle couldn't exist.");
        }
        return square;
    }
}
