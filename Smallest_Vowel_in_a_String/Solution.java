import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();

        char smallestVowel = findSmallestVowel(input);
        System.out.println(smallestVowel);
    }

    public static char findSmallestVowel(String input) {
        char[] vowels = {'a', 'e', 'i', 'o', 'u'};
        char smallestVowel = 'z'; // Initialize with 'z', assuming no vowels are found
        for (char vowel : vowels) {
            if (input.indexOf(vowel) != -1 && vowel < smallestVowel) {
                smallestVowel = vowel;
            }
        }
        return smallestVowel;
    }
}
