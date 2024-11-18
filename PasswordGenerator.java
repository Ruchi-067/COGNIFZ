
import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Input for password length
        System.out.print("Enter the desired length of the password: ");
        int length = scanner.nextInt();

        // Input for character preferences
        System.out.print("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.print("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        // Building the character pool based on user preferences
        String numbers = "0123456789";
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String special = "!@#$%^&*()-_=+[]{}|;:',.<>?/";

        String characterPool = "";
        if (includeNumbers) characterPool += numbers;
        if (includeLowercase) characterPool += lowercase;
        if (includeUppercase) characterPool += uppercase;
        if (includeSpecial) characterPool += special;

        if (characterPool.isEmpty()) {
            System.out.println("No character types selected. Cannot generate password.");
            scanner.close();
            return;
        }

        // Generate password
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }

        // Display the generated password
        System.out.println("Generated password: " + password.toString());

        scanner.close();
    }
}
