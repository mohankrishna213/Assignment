import java.util.Scanner;

class Institution {
    private int institutionId;
    private String institutionName;
    private int noOfStudentsPlaced;
    private int noOfStudentsCleared;
    private String location;
    private String grade;

    // Parameterized constructor
    public Institution(int institutionId, String institutionName, int noOfStudentsPlaced, int noOfStudentsCleared, String location) {
        this.institutionId = institutionId;
        this.institutionName = institutionName;
        this.noOfStudentsPlaced = noOfStudentsPlaced;
        this.noOfStudentsCleared = noOfStudentsCleared;
        this.location = location;
    }

    // Getters and setters
    public int getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(int institutionId) {
        this.institutionId = institutionId;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public int getNoOfStudentsPlaced() {
        return noOfStudentsPlaced;
    }

    public void setNoOfStudentsPlaced(int noOfStudentsPlaced) {
        this.noOfStudentsPlaced = noOfStudentsPlaced;
    }

    public int getNoOfStudentsCleared() {
        return noOfStudentsCleared;
    }

    public void setNoOfStudentsCleared(int noOfStudentsCleared) {
        this.noOfStudentsCleared = noOfStudentsCleared;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read Institution objects
        Institution[] institutions = new Institution[4];
        for (int i = 0; i < 4; i++) {
            int institutionId = Integer.parseInt(scanner.nextLine());
            String institutionName = scanner.nextLine();
            int noOfStudentsPlaced = Integer.parseInt(scanner.nextLine());
            int noOfStudentsCleared = Integer.parseInt(scanner.nextLine());
            String location = scanner.nextLine();
            institutions[i] = new Institution(institutionId, institutionName, noOfStudentsPlaced, noOfStudentsCleared, location);
        }

        // Read location and institutionName values
        String location = scanner.nextLine();
        String institutionName = scanner.nextLine();

        // Call the methods and display the results
        int totalClearance = findNumClearancedByLoc(institutions, location);
        if (totalClearance > 0) {
            System.out.println(totalClearance);
        } else {
            System.out.println("There are no cleared students in this particular location");
        }

        Institution institution = updateInstitutionGrade(institutions, institutionName);
        if (institution != null) {
            System.out.println(institution.getInstitutionName() + "::" + institution.getGrade());
        } else {
            System.out.println("No Institute is available with the specified name");
        }

        scanner.close();
    }

    public static int findNumClearancedByLoc(Institution[] instArray, String location) {
        int totalClearance = 0;
        for (Institution inst : instArray) {
            if (inst.getLocation().equalsIgnoreCase(location)) {
                totalClearance += inst.getNoOfStudentsCleared();
            }
        }
        return totalClearance;
    }

    public static Institution updateInstitutionGrade(Institution[] instArray, String instName) {
        for (Institution inst : instArray) {
            if (inst.getInstitutionName().equalsIgnoreCase(instName)) {
                int rating = (inst.getNoOfStudentsPlaced() * 100) / inst.getNoOfStudentsCleared();
                if (rating >= 80) {
                    inst.setGrade("A");
                } else {
                    inst.setGrade("B");
                }
                return inst;
            }
        }
        return null;
    }
}
