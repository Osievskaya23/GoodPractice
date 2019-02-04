package com.patterns.builder;

public class House {
    private String rowMaterial;
    private int walls;
    private int doors;
    private int windows;
    private int roof;
    private int garage;

    public House() {
        rowMaterial = "something";
        walls = 4;
        doors = 1;
        windows = 2;
        roof = 1;
        garage = 0;
    }

    public void setRowMaterial(String rowMaterial) {
        this.rowMaterial = rowMaterial;
    }

    public void setWalls(int walls) {
        this.walls = walls;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public void setRoof(int roof) {
        this.roof = roof;
    }

    public void setGarage(int garage) {
        this.garage = garage;
    }

    public void getHouseCharacteristics() {
        System.out.print("\nHouse is finally built!\n\nCharacteristics: ");
        System.out.printf("\n%-15s: %s", "row material", rowMaterial);
        System.out.printf("\n%-15s: %s", "walls", walls);
        System.out.printf("\n%-15s: %s", "doors", doors);
        System.out.printf("\n%-15s: %s", "windows", windows);
        System.out.printf("\n%-15s: %s", "roof", roof);
        System.out.printf("\n%-15s: %s", "garage", garage);
    }

}
