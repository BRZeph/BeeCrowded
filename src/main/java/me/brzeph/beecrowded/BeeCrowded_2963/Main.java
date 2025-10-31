package me.brzeph.beecrowded.BeeCrowded_2963;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "3\n1000\n1000\n1000",
            "5\n1\n2\n3\n4\n5",
            "1\n1"
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            int lines = Integer.parseInt(scanner.nextLine());
            StringBuilder sb = new StringBuilder();
            sb.append(lines);
            sb.append("\n");
            for (int i = 0; i < lines; i++) {
                sb.append(scanner.nextLine());
                sb.append("\n");
            }
            solve(sb.toString());

        } else {
            int i = 0;
            for (String s : testCases){
                i++;
                System.out.println("\n\nTest case: " + i);
//                System.out.println("Input: " + s);
                solve(s);
            }
        }
    }

    public static void solve(String inpS){
        int idx = 0;
        int carlosVotes = -1;
        for(String s : inpS.split("\n")){
            idx++;
            if (idx == 1) continue; // Skip first line
            if (idx == 2){ // Young Carlos votes
                carlosVotes = Integer.parseInt(s);
                continue;
            }
            int votes = Integer.parseInt(s);
            if (votes > carlosVotes){
                System.out.println("N");
                return;
            }
        }
        System.out.println("S");
    }
}
