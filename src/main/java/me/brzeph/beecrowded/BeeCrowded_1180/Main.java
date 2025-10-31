package me.brzeph.beecrowded.BeeCrowded_1180;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "1 2 3 4 -5 6 7 8 9 10",
            "1",
            "" // ????
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            scanner.nextLine(); // Ignore line amount.
            solve(scanner.nextLine());

        } else {
            int i = 0;
            for (String s : testCases){
                i++;
                System.out.println("\n\nTest case: " + i + "\n\n");
                solve(s);
            }
        }
    }

    private static void solve(String inpS) {
        String[] inpB = inpS.split(" ");
        int idx = 0;
        int pos = -1;
        float cur;

        float val = Float.MAX_VALUE;

        for (String s : inpB){
            if (s.isEmpty()){
                continue;
            }
            cur = Float.parseFloat(s);
            if (cur < val){
                val = cur;
                pos = idx;
            }
            idx++;
        }

        System.out.printf("Menor valor: %.0f\n", val);
        System.out.println("Posicao: " + pos);
    }
}