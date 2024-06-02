import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        String uniqueChars = getUniqueCharacters(input);
        System.out.println(uniqueChars);
        scanner.close();
    }

    public static String getUniqueCharacters(String input) {
        Set<Character> uniqueSet = new LinkedHashSet<>();
        StringBuilder result = new StringBuilder();

        for (char c : input.toCharArray()) {
            if (!uniqueSet.contains(c)) {
                uniqueSet.add(c);
                result.append(c);
            }
        }

        return result.toString();
    }
}
