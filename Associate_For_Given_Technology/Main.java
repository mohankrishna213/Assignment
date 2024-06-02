import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Associate[] associates = new Associate[5];

        // Read input values for five associate objects
        for (int i = 0; i < 5; i++) {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            String technology = scanner.nextLine();
            int experienceInYears = Integer.parseInt(scanner.nextLine());
            associates[i] = new Associate(id, name, technology, experienceInYears);
        }

        // Read the search technology
        String searchTechnology = scanner.nextLine();

        // Get the filtered associates
        List<Associate> filteredAssociates = Solution.associatesForGivenTechnology(associates, searchTechnology);

        // Print the ids of the filtered associates
        for (Associate associate : filteredAssociates) {
            System.out.println(associate.getId());
        }

        scanner.close();
    }
}
