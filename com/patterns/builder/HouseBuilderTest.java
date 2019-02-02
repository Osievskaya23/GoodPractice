package builder;

class House {
    private String rowMaterial;
    private int walls;
    private int doors;
    private int windows;
    private int roof;
    private int garage;

    House() {
        rowMaterial = "something";
        walls = 4;
        doors = 1;
        windows = 2;
        roof = 1;
        garage = 0;
    }
    void setRowMaterial(String rowMaterial) {
        this.rowMaterial = rowMaterial;
    }

    void setWalls(int walls) {
        this.walls = walls;
    }

    void setDoors(int doors) {
        this.doors = doors;
    }

    void setWindows(int windows) {
        this.windows = windows;
    }

    void setRoof(int roof) {
        this.roof = roof;
    }

    void setGarage(int garage) {
        this.garage = garage;
    }

    void getHouseCharacteristics() {
        System.out.print("\nHouse is finally built!\n\nCharacteristics: ");
        System.out.printf("\n%-15s: %s", "row material", rowMaterial);
        System.out.printf("\n%-15s: %s", "walls", walls);
        System.out.printf("\n%-15s: %s", "doors", doors);
        System.out.printf("\n%-15s: %s", "windows", windows);
        System.out.printf("\n%-15s: %s", "roof", roof);
        System.out.printf("\n%-15s: %s", "garage", garage);
    }

}

abstract class HouseBuilder {
    protected House house;

    House getResult() {
        return house;
    }
    void createNewHouse() {
        house = new House();
    }

    abstract void useRowMaterial();
    abstract void buildWalls();
    abstract void buildDoors();
    abstract void buildWindows();
    abstract void buildRoof();
    abstract void buildGarage();
}

class WoodHouseBuilder extends HouseBuilder {
    @Override
    void useRowMaterial() {
        house.setRowMaterial("wood");
        System.out.println("Row material is wood.");
    }

    @Override
    void buildWalls() {
        System.out.println("Four wooden walls build.");
    }

    @Override
    void buildDoors() {
        System.out.println("Wooden door build.");
    }

    @Override
    void buildWindows() {
        System.out.println("Two wooden windows build.");
    }

    @Override
    void buildRoof() {
        System.out.println("One wooden roof build.");
    }

    @Override
    void buildGarage() {
        System.out.println("One wooden garage build.");
    }
}

class StoneHouseBuilder extends HouseBuilder {
    @Override
    void useRowMaterial() {
        house.setRowMaterial("stone");
        System.out.println("Row material is stone.");
    }

    @Override
    void buildWalls() {
        System.out.println("Four stone walls build.");
    }

    @Override
    void buildDoors() {
        System.out.println("One stone door build.");
    }

    @Override
    void buildWindows() {
        System.out.println("Two stone windows build.");
    }

    @Override
    void buildRoof() {
        System.out.println("One stone roof build.");
    }

    @Override
    void buildGarage() {
        System.out.println("One stone garage build.");
    }
}

class Director {
    private HouseBuilder houseBuilder;

    void setHouseBuilder(HouseBuilder houseBuilder) {
        this.houseBuilder = houseBuilder;
    }

    void buildHouse() {
        houseBuilder.createNewHouse();
        houseBuilder.useRowMaterial();
        houseBuilder.buildWalls();
        houseBuilder.buildDoors();
        houseBuilder.buildWindows();
        houseBuilder.buildRoof();
        houseBuilder.buildGarage();
    }

    House getHouse() {
        return houseBuilder.getResult();
    }
}

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