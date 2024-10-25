import java.util.Scanner;

public class PasswordStrengthChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user to enter a password
        System.out.print("Enter a password: ");
        String password = scanner.nextLine();

        // Analyze password strength
        int strengthScore = calculateStrength(password);

        // Provide feedback based on password strength
        if (strengthScore <= 2) {
            System.out.println("Password strength: Weak");
            System.out.println("Try using a longer password with mixed characters.");
        } else if (strengthScore == 3) {
            System.out.println("Password strength: Moderate");
            System.out.println("Consider adding special characters and numbers for extra security.");
        } else if (strengthScore == 4) {
            System.out.println("Password strength: Strong");
            System.out.println("Good job! Your password is strong.");
        } else {
            System.out.println("Password strength: Very Strong");
            System.out.println("Your password is very secure.");
        }

        scanner.close();
    }

    public static int calculateStrength(String password) {
        int score = 0;

        // Check for length (minimum 8 characters)
        if (password.length() >= 8) {
            score++;
        }

        // Check for uppercase letter
        if (password.matches(".*[A-Z].*")) {
            score++;
        }

        // Check for lowercase letter
        if (password.matches(".*[a-z].*")) {
            score++;
        }

        // Check for digit
        if (password.matches(".*[0-9].*")) {
            score++;
        }

        // Check for special character
        if (password.matches(".*[!@#$%^&*(),.?\":{}|<>].*")) {
            score++;
        }

        return score;
    }
}
