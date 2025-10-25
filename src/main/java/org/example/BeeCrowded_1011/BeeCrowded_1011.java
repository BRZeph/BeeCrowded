package org.example.BeeCrowded_1011;

import java.util.List;
import java.util.Scanner;

public class BeeCrowded_1011 {

    private static final List<String> testCases = List.of(
            "400", "800", "30"
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);

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
        int inpI = Integer.valueOf(inpS);
        int anos = inpI / 365;
        int meses = ( inpI % 365 ) / 30;
        int dias = (inpI % 365) % 30;

        System.out.println(
                anos + " ano(s)" + "\n" +
                        meses + " mes(es)" + "\n" +
                        dias + " dia(s)"
        );
    }
}