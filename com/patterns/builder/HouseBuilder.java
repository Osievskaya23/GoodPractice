package com.patterns.builder;

public abstract class HouseBuilder {
    protected House house;

    public House getResult() {
        return house;
    }
    public void createNewHouse() {
        house = new House();
    }

    abstract void useRowMaterial();
    abstract void buildWalls();
    abstract void buildDoors();
    abstract void buildWindows();
    abstract void buildRoof();
    abstract void buildGarage();
}
