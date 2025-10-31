package me.brzeph.beecrowded.BeeCrowded_1064;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<List<String>> testCases = List.of(
            List.of("7", "-5", "6", "-3.4", "4.6", "12")
    );

    public static void main(String[] args) {
        boolean finalSolution = true;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            List<String> inp = new ArrayList<>();
            for( int i = 0; i < 6; i++){
                inp.add(scanner.nextLine());
            }
            solve(inp);
        } else {
            int i = 0;
            for (List<String> s : testCases){
                i++;
                System.out.println("\n\nTest case: " + i + "\n\n");
                solve(s);
            }
        }
    }

    private static void solve(List<String> inpS) {
        float f;
        int positivos = 0;
        float totalPositivos = 0;
        for(String s : inpS){
            f = Float.parseFloat(s);
            if (f < 0) continue;
            positivos++;
            totalPositivos += f;
        }

        System.out.println(positivos + " valores positivos");
        System.out.printf("%.1f\n", (totalPositivos / positivos));
    }
}