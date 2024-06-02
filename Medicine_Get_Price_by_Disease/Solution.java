import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Medicine {
    private String MedicineName;
    private String batch;
    private String disease;
    private int price;

    // Constructor
    public Medicine(String medicineName, String batch, String disease, int price) {
        this.MedicineName = medicineName;
        this.batch = batch;
        this.disease = disease;
        this.price = price;
    }

    // Getters and setters
    public String getMedicineName() {
        return MedicineName;
    }

    public void setMedicineName(String medicineName) {
        MedicineName = medicineName;
    }

    public String getBatch() {
        return batch;
    }

    public void setBatch(String batch) {
        this.batch = batch;
    }

    public String getDisease() {
        return disease;
    }

    public void setDisease(String disease) {
        this.disease = disease;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Medicine[] medicines = new Medicine[4];

        // Read values for four Medicine objects
        for (int i = 0; i < 4; i++) {
            String medicineName = scanner.nextLine();
            String batch = scanner.nextLine();
            String disease = scanner.nextLine();
            int price = Integer.parseInt(scanner.nextLine());
            medicines[i] = new Medicine(medicineName, batch, disease, price);
        }

        // Read the disease
        String disease = scanner.nextLine();

        // Call getPriceByDisease method and print the result
        ArrayList<Integer> result = getPriceByDisease(medicines, disease);
        for (int price : result) {
            System.out.println(price);
        }

        scanner.close();
    }

    public static ArrayList<Integer> getPriceByDisease(Medicine[] medicines, String disease) {
        ArrayList<Integer> prices = new ArrayList<>();

        // Iterate through the Medicine objects and collect prices of medicines that match the given disease
        for (Medicine medicine : medicines) {
            if (medicine.getDisease().equalsIgnoreCase(disease)) {
                prices.add(medicine.getPrice());
            }
        }

        // Sort the collected prices
        prices.sort(null);

        return prices;
    }
}
