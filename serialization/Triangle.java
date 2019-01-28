package serialization;

public class Triangle implements Figure {
    public String name;
    private int a;
    private int b;
    private int c;
    public double square;

    public Triangle(String name, int a, int b, int c) {
        this.name = name;
        this.a = a;
        this.b = b;
        this.c = c;
        this.square = calculateSquare();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public double getSquare() {
        return square;
    }

    @Override
    public double calculateSquare() {
        double square = 0;
        if(a + b > c && a + c > b && b + c > a) {
            int p = (a + b + c) / 2;
            square = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        } else {
            System.out.println("Triangle couldn't exist.");
        }
        return square;
    }
}
