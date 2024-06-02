import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().toLowerCase();
        int vowelsCount = 0;
        int consonantsCount = 0;

        for (char c : input.toCharArray()) {
            if (Character.isLetter(c)) {
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowelsCount++;
                } else {
                    consonantsCount++;
                }
            }
        }

        System.out.println("Vowels count - " + vowelsCount);
        System.out.println("Consonants count - " + consonantsCount);

        scanner.close();
    }
}
