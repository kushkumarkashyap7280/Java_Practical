package practical3.P2;

import practical3.P1.Shape;
import java.util.Scanner;

public class Rectangle extends Shape {
    private double length;
    private double width;
    private Scanner scanner;

    public Rectangle() {
        this.length = 0.0;
        this.width = 0.0;
        this.scanner = new Scanner(System.in);
    }

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void readData() {
        System.out.print("Enter length of rectangle: ");
        this.length = scanner.nextDouble();
        System.out.print("Enter width of rectangle: ");
        this.width = scanner.nextDouble();
    }

    @Override
    public double area() {
        return length * width;
    }
}
