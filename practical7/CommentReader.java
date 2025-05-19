package practical7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CommentReader {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Comment Line Reader");
        System.out.println("------------------");

        System.out.print("Enter the path to the file: ");
        String filePath = scanner.nextLine();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            System.out.println("\nComment lines in the file:");
            System.out.println("------------------------");

            String line;
            int lineNumber = 0;
            boolean foundComments = false;

            while ((line = reader.readLine()) != null) {
                lineNumber++;

                if (line.trim().startsWith("//")) {
                    System.out.println("Line " + lineNumber + ": " + line);
                    foundComments = true;
                }
            }

            if (!foundComments) {
                System.out.println("No comment lines found in the file.");
            }

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}
