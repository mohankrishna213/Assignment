import java.util.Scanner;

public class Solution {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for(int i=0; i < input.length();i++){
            if(i%2 != 0){
                System.out.print(input.charAt(i));
            }
        }
        scanner.close();

    }
}
