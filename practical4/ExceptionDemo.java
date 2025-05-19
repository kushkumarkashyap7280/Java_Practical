package practical4;

import java.util.Scanner;

public class ExceptionDemo {

    public void test(int age) throws UnderAge {
        if (age < 18) {
            throw new UnderAge(age);
        } else {
            System.out.println("Age is valid: " + age);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ExceptionDemo demo = new ExceptionDemo();

        System.out.println("Age Verification System");
        System.out.println("----------------------");

        try {
            System.out.print("Enter your age: ");
            int age = scanner.nextInt();

            demo.test(age);
            System.out.println("You are eligible.");
        } catch (UnderAge e) {
            System.out.println("Exception caught: " + e);
            System.out.println("You are not eligible as you are underage.");
        } catch (Exception e) {
            System.out.println("Invalid input: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
