import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class PrimeNumberSequence {

    // Method to check if a number is prime
    public static boolean isPrime(int num) {
        if (num <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input sequence which ends with a semicolon
        String input = scanner.nextLine();
        // Remove the trailing semicolon
        input = input.replace(";", "").trim();

        // Split the input into individual numbers
        String[] numbers = input.split(" ");
        ArrayList<Integer> primeNumbers = new ArrayList<>();

        // Iterate through each number and check if it is prime
        for (String numberStr : numbers) {
            int number = Integer.parseInt(numberStr);
            if (isPrime(number)) {
                primeNumbers.add(number);
            }
        }

        // Sort the list of prime numbers
        Collections.sort(primeNumbers);

        // Find the total number of prime numbers
        int totalPrimes = primeNumbers.size();

        // Find the second largest prime number
        int secondLargestPrime = primeNumbers.get(totalPrimes - 2);

        // Calculate the result
        int result = totalPrimes + secondLargestPrime;

        // Print the result
        System.out.println(result);

        scanner.close();
    }
}
