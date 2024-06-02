import java.util.Scanner;

class TravelAgencies {
    private int regNo;
    private String agencyName;
    private String packageType;
    private int price;
    private boolean flightFacility;

    // Constructor
    public TravelAgencies(int regNo, String agencyName, String packageType, int price, boolean flightFacility) {
        this.regNo = regNo;
        this.agencyName = agencyName;
        this.packageType = packageType;
        this.price = price;
        this.flightFacility = flightFacility;
    }

    // Getters and Setters
    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }

    public String getAgencyName() {
        return agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isFlightFacility() {
        return flightFacility;
    }

    public void setFlightFacility(boolean flightFacility) {
        this.flightFacility = flightFacility;
    }
}

public class Solution {

    public static void main(String[] args) {
        // Read input
        TravelAgencies[] agencies = readInput();

        // Call methods
        int highestPackagePrice = findAgencyWithHighestPackagePrice(agencies);
        System.out.println(highestPackagePrice);

        TravelAgencies agency = agencyDetailsforGivenIdAndType(agencies, 987, "Diamond");
        if (agency != null) {
            System.out.println(agency.getAgencyName() + ":" + agency.getPrice());
        }
    }

    // Method to read input
    public static TravelAgencies[] readInput() {
        Scanner scanner = new Scanner(System.in);
        int n = 4; // Assuming 4 travel agencies for input
        TravelAgencies[] agencies = new TravelAgencies[n];
        for (int i = 0; i < n; i++) {
            int regNo = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            String agencyName = scanner.nextLine();
            String packageType = scanner.nextLine();
            int price = scanner.nextInt();
            boolean flightFacility = scanner.nextBoolean();
            agencies[i] = new TravelAgencies(regNo, agencyName, packageType, price, flightFacility);
        }
        scanner.close();
        return agencies;
    }

    // Method to find highest package price
    public static int findAgencyWithHighestPackagePrice(TravelAgencies[] agencies) {
        int highestPackagePrice = Integer.MIN_VALUE;
        for (TravelAgencies agency : agencies) {
            highestPackagePrice = Math.max(highestPackagePrice, agency.getPrice());
        }
        return highestPackagePrice;
    }

    // Method to find agency details for given id and type
    public static TravelAgencies agencyDetailsforGivenIdAndType(TravelAgencies[] agencies, int regNo, String packageType) {
        for (TravelAgencies agency : agencies) {
            if (agency.getRegNo() == regNo && agency.getPackageType().equalsIgnoreCase(packageType) && agency.isFlightFacility()) {
                return agency;
            }
        }
        return null;
    }
}
