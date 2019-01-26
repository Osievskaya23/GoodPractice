package serialization;

public class Square implements Figure {
    private String name;
    private int a;
    private double square;

    Square(String name, int a) {
        this.name = name;
        this.a = a;
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
        return Math.pow(a, 2);
    }
}
