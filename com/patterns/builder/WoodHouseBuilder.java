package com.patterns.builder;

public class WoodHouseBuilder extends HouseBuilder {
    @Override
    public void useRowMaterial() {
        house.setRowMaterial("wood");
        System.out.println("Row material is wood.");
    }

    @Override
    public void buildWalls() {
        System.out.println("Four wooden walls build.");
    }

    @Override
    public void buildDoors() {
        System.out.println("Wooden door build.");
    }

    @Override
    public void buildWindows() {
        System.out.println("Two wooden windows build.");
    }

    @Override
    public void buildRoof() {
        System.out.println("One wooden roof build.");
    }

    @Override
    public void buildGarage() {
        System.out.println("One wooden garage build.");
    }
}
