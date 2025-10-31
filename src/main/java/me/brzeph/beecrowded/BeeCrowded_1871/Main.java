package me.brzeph.beecrowded.BeeCrowded_1871;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "7 8",
            "15 5",
            "99 6",
            "0 0"
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            while(solve(scanner.nextLine())){}

        } else {
            int i = 0;
            for (String s : testCases){
                i++;
                System.out.println("\n\nTest case: " + i);
                System.out.println("Input: " + s);
                solve(s);
            }
        }
    }

    private static boolean solve(String inpS) {
        if (inpS.equals("0 0")){
            return false;
        }
        String[] inpB = inpS.split(" ");
        int s1 = Integer.parseInt(inpB[0]);
        int s2 = Integer.parseInt(inpB[1]);
        int sum = s1 + s2;
        String sumS = String.valueOf(sum);
        sumS = sumS.replace("0", "");
        System.out.println(sumS);

        return true;
    }
}