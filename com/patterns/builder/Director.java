package com.patterns.builder;

public class Director {
    private HouseBuilder houseBuilder;

    public void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    public void buildHouse() {
        houseBuilder.createNewHouse();
        houseBuilder.useRowMaterial();
        houseBuilder.buildWalls();
        houseBuilder.buildDoors();
        houseBuilder.buildWindows();
        houseBuilder.buildRoof();
        houseBuilder.buildGarage();
    }

    public House getHouse() {
        return houseBuilder.getResult();
    }
}
