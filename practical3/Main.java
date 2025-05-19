package practical3;

import practical3.P1.Shape;
import practical3.P2.Rectangle;
import practical3.P3.Circle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Shape shape = null;

        System.out.println("Shape Area Calculator");
        System.out.println("--------------------");
        System.out.println("1. Rectangle");
        System.out.println("2. Circle");
        System.out.print("Enter your choice (1 or 2): ");

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                shape = new Rectangle();
                break;
            case 2:
                shape = new Circle();
                break;
            default:
                System.out.println("Invalid choice! Exiting program.");
                System.exit(1);
        }

        shape.readData();
        System.out.println("The area is: " + shape.area());

        scanner.close();
    }
}
