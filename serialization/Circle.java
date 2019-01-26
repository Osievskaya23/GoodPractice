package serialization;

public class Circle implements Figure {
    private static final double PI = 3.141_592_653_589_793;
    private String name;
    private int radius;
    private double square;

    Circle(String name, int radius) {
        this.name = name;
        this.radius = radius;
        this.square = calculateSquare();
    }

    public String getName() {
        return name;
    }

    public double getSquare() {
        return square;
    }

    @Override
    public double calculateSquare() {
        return PI * Math.pow(radius, 2);
    }
}
