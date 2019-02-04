package com.patterns.builder;

public class HouseBuilderTest {
    public static void main(String[] args) {
        Director director = new Director();
        HouseBuilder woodHouseBuilder = new WoodHouseBuilder();
        director.setHouseBuilder(woodHouseBuilder);
        director.buildHouse();

        House house = director.getHouse();
        house.setWindows(5);
        house.setDoors(1);
        house.setWalls(10);

        house.getHouseCharacteristics();
    }
}