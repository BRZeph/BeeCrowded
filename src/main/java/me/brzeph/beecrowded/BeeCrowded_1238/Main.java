package me.brzeph.beecrowded.BeeCrowded_1238;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "acegi bdfhj", // Happy case
            "Tpo oCder", // Happy case
            "aa bb", // Happy case
            "acegikmo b",
            " abcdef",
            "abcdef",
            "",
            " "
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            int size = Integer.parseInt(scanner.nextLine());
            for (int i = 0; i < size; i++) {
                solve(scanner.nextLine());
            }

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

    private static void solve(String inpS) {
        String[] inpB = inpS.split(" ");
        String word1 = inpB.length == 0 ? "" : inpB[0];
        String word2 = inpB.length <= 1 ? "" : inpB[1];
        StringBuilder ans = new StringBuilder();

        int minL = Math.min(word1.length(), word2.length());

        for (int i = 0; i < minL; i++){
            ans.append(word1.charAt(i));
            ans.append(word2.charAt(i));
        }

        if (minL < word1.length()){
            ans.append(word1.substring(minL));
        }

        if (minL < word2.length()){
            ans.append(word2.substring(minL));
        }

        System.out.println(ans);
    }
}
