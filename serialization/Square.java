package serialization;

public class Square implements Figure {
    public String name;
    private int a;
    public double square;

    public Square(String name, int a) {
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
