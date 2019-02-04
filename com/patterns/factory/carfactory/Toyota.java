package com.patterns.factory.carfactory;

public class Toyota implements Car {
    @Override
    public void drive() {
        System.out.println("drive Toyota");
    }
}
