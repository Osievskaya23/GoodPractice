package com.patterns.builder;

public class StoneHouseBuilder extends HouseBuilder {
    @Override
    public void useRowMaterial() {
        house.setRowMaterial("stone");
        System.out.println("Row material is stone.");
    }

    @Override
    public void buildWalls() {
        System.out.println("Four stone walls build.");
    }

    @Override
    public void buildDoors() {
        System.out.println("One stone door build.");
    }

    @Override
    public void buildWindows() {
        System.out.println("Two stone windows build.");
    }

    @Override
    public void buildRoof() {
        System.out.println("One stone roof build.");
    }

    @Override
    public void buildGarage() {
        System.out.println("One stone garage build.");
    }
}
