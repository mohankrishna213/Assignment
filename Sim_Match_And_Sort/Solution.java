import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Sim {
    private int id;
    private String company;
    private int balance;
    private double ratePerSecond;
    private String circle;

    public Sim(int id, String company, int balance, double ratePerSecond, String circle) {
        this.id = id;
        this.company = company;
        this.balance = balance;
        this.ratePerSecond = ratePerSecond;
        this.circle = circle;
    }

    public int getId() {
        return id;
    }

    public String getCompany() {
        return company;
    }

    public int getBalance() {
        return balance;
    }

    public double getRatePerSecond() {
        return ratePerSecond;
    }

    public String getCircle() {
        return circle;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sim[] sims = new Sim[4];
        for (int i = 0; i < 4; i++) {
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String company = scanner.nextLine();
            int balance = scanner.nextInt();
            double ratePerSecond = scanner.nextDouble();
            scanner.nextLine(); // Consume newline
            String circle = scanner.nextLine();
            sims[i] = new Sim(id, company, balance, ratePerSecond, circle);
        }
        String search_circle = scanner.nextLine();
        double search_rate = scanner.nextDouble();
        scanner.close();

        Sim[] result = matchAndSort(sims, search_circle, search_rate);
        for (Sim sim : result) {
            System.out.println(sim.getId());
        }
    }

    public static Sim[] matchAndSort(Sim[] sims, String search_circle, double search_rate) {
        Sim[] matched = Arrays.stream(sims)
                .filter(sim -> sim.getCircle().equals(search_circle) && sim.getRatePerSecond() < search_rate)
                .sorted(Comparator.comparing(Sim::getBalance).reversed())
                .toArray(Sim[]::new);
        return matched;
    }
}
