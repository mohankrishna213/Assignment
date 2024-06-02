import java.util.Scanner;

class Player {
    private int id;
    private String name;
    private int iccRank;
    private int matchesPlayed;
    private int runsScored;

    public Player(int id, String name, int iccRank, int matchesPlayed, int runsScored) {
        this.id = id;
        this.name = name;
        this.iccRank = iccRank;
        this.matchesPlayed = matchesPlayed;
        this.runsScored = runsScored;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIccRank() {
        return iccRank;
    }

    public void setIccRank(int iccRank) {
        this.iccRank = iccRank;
    }

    public int getMatchesPlayed() {
        return matchesPlayed;
    }

    public void setMatchesPlayed(int matchesPlayed) {
        this.matchesPlayed = matchesPlayed;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }
}

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Player[] players = new Player[4];
        for (int i = 0; i < 4; i++) {
            int id = Integer.parseInt(scanner.nextLine());
            String name = scanner.nextLine();
            int iccRank = Integer.parseInt(scanner.nextLine());
            int matchesPlayed = Integer.parseInt(scanner.nextLine());
            int runsScored = Integer.parseInt(scanner.nextLine());
            players[i] = new Player(id, name, iccRank, matchesPlayed, runsScored);
        }

        int target = Integer.parseInt(scanner.nextLine());

        double[] averageRuns = findAverageOfRuns(players, target);
        for (double avg : averageRuns) {
            if (avg >= 80 && avg <= 100) {
                System.out.println("Grade A");
            } else if (avg >= 50 && avg <= 79) {
                System.out.println("Grade B");
            } else {
                System.out.println("Grade C");
            }
        }

        scanner.close();
    }

    public static double[] findAverageOfRuns(Player[] players, int target) {
        double[] averages = new double[players.length];
        for (int i = 0; i < players.length; i++) {
            if (players[i].getMatchesPlayed() >= target) {
                averages[i] = (double) players[i].getRunsScored() / players[i].getMatchesPlayed();
            }
        }
        return averages;
    }
}
