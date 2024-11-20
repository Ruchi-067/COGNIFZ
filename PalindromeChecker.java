import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt user for input
        System.out.print("Enter a word or phrase to check if it's a palindrome: ");
        String input = scanner.nextLine();

        // Normalize the input (remove non-alphanumeric characters and convert to lowercase)
        String normalizedInput = normalizeString(input);

        // Check if the normalized string is a palindrome
        boolean isPalindrome = isPalindrome(normalizedInput);

        // Output the result
        if (isPalindrome) {
            System.out.println("The entered word or phrase is a palindrome.");
        } else {
            System.out.println("The entered word or phrase is NOT a palindrome.");
        }

        scanner.close();
    }

    // Method to normalize a string by removing spaces, punctuation, and making it lowercase
    public static String normalizeString(String str) {
        return str.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
    }

    // Method to check if a string is a palindrome
    public static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false; // If characters don't match, it's not a palindrome
            }
            left++;
            right--;
        }
        return true; // If all characters match, it's a palindrome
    }
}
