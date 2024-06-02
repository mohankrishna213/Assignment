import java.util.Scanner;
import java.util.ArrayList;

class Inventory {
    private String inventoryId;
    private int maximumQuantity;
    private int currentQuantity;
    private int threshold;

    public Inventory(String inventoryId, int maximumQuantity, int currentQuantity, int threshold) {
        this.inventoryId = inventoryId;
        this.maximumQuantity = maximumQuantity;
        this.currentQuantity = currentQuantity;
        this.threshold = threshold;
    }

    public String getInventoryId() {
        return inventoryId;
    }

    public void setInventoryId(String inventoryId) {
        this.inventoryId = inventoryId;
    }

    public int getMaximumQuantity() {
        return maximumQuantity;
    }

    public void setMaximumQuantity(int maximumQuantity) {
        this.maximumQuantity = maximumQuantity;
    }

    public int getCurrentQuantity() {
        return currentQuantity;
    }

    public void setCurrentQuantity(int currentQuantity) {
        this.currentQuantity = currentQuantity;
    }

    public int getThreshold() {
        return threshold;
    }

    public void setThreshold(int threshold) {
        this.threshold = threshold;
    }
}

public class Solution {

    public static Inventory[] replenish(Inventory[] inventories, int limit) {
        ArrayList<Inventory> filteredInventories = new ArrayList<>();
        for (Inventory inv : inventories) {
            if (inv.getThreshold() <= limit) {
                filteredInventories.add(inv);
            }
        }
        return filteredInventories.toArray(new Inventory[filteredInventories.size()]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        Inventory[] inventories = new Inventory[4];
        
        for (int i = 0; i < 4; i++) {
            String inventoryId = scanner.nextLine();
            int maximumQuantity = Integer.parseInt(scanner.nextLine());
            int currentQuantity = Integer.parseInt(scanner.nextLine());
            int threshold = Integer.parseInt(scanner.nextLine());
            inventories[i] = new Inventory(inventoryId, maximumQuantity, currentQuantity, threshold);
        }
        
        int limit = Integer.parseInt(scanner.nextLine());
        Inventory[] result = replenish(inventories, limit);
        
        for (Inventory inv : result) {
            String fillingType;
            if (inv.getThreshold() > 75) {
                fillingType = "Critical Filling";
            } else if (inv.getThreshold() >= 50 && inv.getThreshold() <= 75) {
                fillingType = "Moderate Filling";
            } else {
                fillingType = "Non-Critical Filling";
            }
            System.out.println(inv.getInventoryId() + " " + fillingType);
        }
        
        scanner.close();
    }
}
