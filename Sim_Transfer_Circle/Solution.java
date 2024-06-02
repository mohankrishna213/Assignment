import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Sim {
    private int simId;
    private String customerName;
    private double balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int simId, String customerName, double balance, double ratePerSecond, String circle) {
        this.simId = simId;
        this.customerName = customerName;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getSimId() {
        return simId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getBalance() {
        return balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }

    public void setCircle(String circle) {
        this.circle = circle;
    }

    @Override
    public String toString() {
        return simId + " " + customerName + " " + circle + " " + ratePerSecond;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sim[] sims = new Sim[5];
        for (int i = 0; i < 5; i++) {
            int simId = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String customerName = scanner.nextLine();
            double balance = scanner.nextDouble();
            double ratePerSecond = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            String circle = scanner.nextLine();
            sims[i] = new Sim(simId, customerName, balance, ratePerSecond, circle);
        }
        String circle1 = scanner.nextLine();
        String circle2 = scanner.nextLine();
        scanner.close();

        Sim[] result = transferCircle(sims, circle1, circle2);
        for (Sim sim : result) {
            System.out.println(sim);
        }
    }

    public static Sim[] transferCircle(Sim[] sims, String circle1, String circle2) {
        Sim[] matched = Arrays.stream(sims)
                .filter(sim -> sim.getCircle().equals(circle1))
                .sorted(Comparator.comparing(Sim::getRatePerSecond).reversed())
                .toArray(Sim[]::new);
        for (Sim sim : matched) {
            sim.setCircle(circle2);
        }
        return matched;
    }
}
