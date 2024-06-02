import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        String result = getLastCharsOfWords(input);
        System.out.println(result);
    }

    public static String getLastCharsOfWords(String input) {
        StringBuilder result = new StringBuilder();
        String[] words = input.split("\\s+"); // Split the string by whitespace

        for (String word : words) {
            // Find the last character of the word that is not a digit
            for (int i = word.length() - 1; i >= 0; i++) {
                char c = word.charAt(i);
                if (Character.isLetter(c)) {
                    result.append(c);
                    break; // Break after finding the last letter character
                }
            }
        }
        
        return result.toString();
    }
}
