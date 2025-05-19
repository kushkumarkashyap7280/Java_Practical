package P;

import P1.TwoDim;
import P2.ThreeDim;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Demonstration of TwoDim and ThreeDim classes");
        System.out.println("-------------------------------------------");

        TwoDim point2D1 = new TwoDim();
        ThreeDim point3D1 = new ThreeDim();

        System.out.println("Default 2D point: " + point2D1);
        System.out.println("Default 3D point: " + point3D1);

        System.out.println("\nEnter coordinates for a 2D point:");
        System.out.print("Enter x-coordinate: ");
        double x = scanner.nextDouble();
        System.out.print("Enter y-coordinate: ");
        double y = scanner.nextDouble();

        TwoDim point2D2 = new TwoDim(x, y);

        System.out.println("\nEnter coordinates for a 3D point:");
        System.out.print("Enter x-coordinate: ");
        x = scanner.nextDouble();
        System.out.print("Enter y-coordinate: ");
        y = scanner.nextDouble();
        System.out.print("Enter z-coordinate: ");
        double z = scanner.nextDouble();

        ThreeDim point3D2 = new ThreeDim(x, y, z);

        System.out.println("\nUser-defined 2D point: " + point2D2);
        System.out.println("User-defined 3D point: " + point3D2);

        System.out.println("\nDemonstrating dynamic method dispatch:");

        TwoDim ref1 = point2D2;
        ref1.display();

        TwoDim ref2 = point3D2;
        ref2.display();

        scanner.close();
    }
}
