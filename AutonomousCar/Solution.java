
import java.util.Scanner;

public class Solution {

    public static int findTestPassedByEnv(AutonomousCar[] cars, String environment) {
        int totalTestsPassed = 0;
        for (AutonomousCar car : cars) {
            if (car.getEnvironment().equalsIgnoreCase(environment)) {
                totalTestsPassed += car.getNoOfTestsPassed();
            }
        }
        return totalTestsPassed;
    }

    public static AutonomousCar updateCarGrade(String brand, AutonomousCar[] cars) {
        for (AutonomousCar car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                int rating = (car.getNoOfTestsPassed() * 100) / car.getNoOfTestsConducted();
                if (rating >= 80) {
                    car.setGrade("A1");
                } else {
                    car.setGrade("B2");
                }
                return car;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        AutonomousCar[] cars = new AutonomousCar[4];

        // Reading input for four AutonomousCar objects
        for (int i = 0; i < 4; i++) {
            int carId = Integer.parseInt(scanner.nextLine());
            String brand = scanner.nextLine();
            int noOfTestsConducted = Integer.parseInt(scanner.nextLine());
            int noOfTestsPassed = Integer.parseInt(scanner.nextLine());
            String environment = scanner.nextLine();
            cars[i] = new AutonomousCar(carId, brand, noOfTestsConducted, noOfTestsPassed, environment);
        }

        // Reading environment and brand for the methods
        String environment = scanner.nextLine();
        String brand = scanner.nextLine();

        // Call findTestPassedByEnv method
        int totalTestsPassed = findTestPassedByEnv(cars, environment);
        if (totalTestsPassed > 0) {
            System.out.println(totalTestsPassed);
        } else {
            System.out.println("There are no tests passed in this particular environment");
        }

        // Call updateCarGrade method
        AutonomousCar car = updateCarGrade(brand, cars);
        if (car != null) {
            System.out.println(car.getBrand() + "::" + car.getGrade());
        } else {
            System.out.println("No Car is available with the specified brand");
        }

        scanner.close();
    }
}

