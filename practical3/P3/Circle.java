package practical3.P3;

import practical3.P1.Shape;
import java.util.Scanner;

public class Circle extends Shape {
    private double radius;
    private Scanner scanner;

    public Circle() {
        this.radius = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public Circle(double radius) {
        this.radius = radius;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void readData() {
        System.out.print("Enter radius of circle: ");
        this.radius = scanner.nextDouble();
    }

    @Override
    public double area() {
        return Math.PI * radius * radius;
    }
}
