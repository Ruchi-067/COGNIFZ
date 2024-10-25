
import java.io.*;
import java.util.Scanner;

public class FileEncryptDecrypt {
    private static final int SHIFT_KEY = 4; // Shift key for Caesar Cipher

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose an option: \n1. Encrypt \n2. Decrypt");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter the file path: ");
        String filePath = scanner.nextLine();

        System.out.print("Enter the output file path: ");
        String outputPath = scanner.nextLine();

        if (choice == 1) {
            processFile(filePath, outputPath, SHIFT_KEY, true);
            System.out.println("File encrypted successfully.");
        } else if (choice == 2) {
            processFile(filePath, outputPath, SHIFT_KEY, false);
            System.out.println("File decrypted successfully.");
        } else {
            System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Encrypt or decrypt the file
    private static void processFile(String inputPath, String outputPath, int shift, boolean encrypt) {
        try (BufferedReader reader = new BufferedReader(new FileReader(inputPath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputPath))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String processedLine = encrypt ? encrypt(line, shift) : decrypt(line, shift);
                writer.write(processedLine);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println("An error occurred while processing the file.");
            e.printStackTrace();
        }
    }

    // Simple Caesar Cipher encryption
    private static String encrypt(String text, int shift) {
        StringBuilder encrypted = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                c = (char) ((c - base + shift) % 26 + base);
            }
            encrypted.append(c);
        }
        return encrypted.toString();
    }

    // Simple Caesar Cipher decryption
    private static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift); // reverse shift for decryption
    }
}
