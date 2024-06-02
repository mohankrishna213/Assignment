import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        int[] counts = countSpacesAndCharacters(input);
        System.out.println("No of spaces: " + counts[0] + " and characters: " + counts[1]);
    }

    public static int[] countSpacesAndCharacters(String input) {
        int spaces = 0;
        int characters = 0;

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch) || ch == ' ') {
                if (ch == ' ') {
                    spaces++;
                } else {
                    characters++;
                }
            }
        }

        return new int[]{spaces, characters};
    }
}
