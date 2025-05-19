package practical6;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Usage: java practical6.FileCopy <source-file> <destination-file>");
            System.exit(1);
        }

        String sourceFile = args[0];
        String destFile = args[1];

        try (
                FileInputStream fis = new FileInputStream(sourceFile);
                FileOutputStream fos = new FileOutputStream(destFile)) {
            System.out.println("Copying from " + sourceFile + " to " + destFile + "...");

            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = fis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }

            System.out.println("File copied successfully!");

        } catch (IOException e) {
            System.out.println("Error copying file: " + e.getMessage());
        }
    }
}
