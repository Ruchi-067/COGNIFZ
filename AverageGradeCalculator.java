
import java.util.Scanner;

public class AverageGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user for the number of grades
        System.out.print("Enter the number of grades to be entered: ");
        int numberOfGrades = scanner.nextInt();

        // Validate the number of grades
        if (numberOfGrades <= 0) {
            System.out.println("The number of grades must be greater than zero.");
            scanner.close();
            return;
        }

        // Create an array to store the grades
        double[] grades = new double[numberOfGrades];
        double sum = 0;

        // Input each grade using a loop
        for (int i = 0; i < numberOfGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextDouble();

            // Validate the grade
            if (grades[i] < 0 || grades[i] > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
                i--; // Retry the current iteration
                continue;
            }

            // Add the grade to the sum
            sum += grades[i];
        }

        // Calculate the average
        double average = sum / numberOfGrades;

        // Display the average to the user
        System.out.printf("The average grade is: %.2f%n", average);

        scanner.close();
    }
}
