import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        boolean isPerfectSquare = checkPerfectSquare(num);
        System.out.println(isPerfectSquare);

        scanner.close();
    }

    public static boolean checkPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }
}
