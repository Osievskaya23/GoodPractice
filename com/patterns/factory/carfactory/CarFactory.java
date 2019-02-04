package com.patterns.factory.carfactory;

public class CarFactory {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Car toyota = factory.create("Toyota");
        Car audi = factory.create("Audi");
        toyota.drive();
        audi.drive();
    }
}
