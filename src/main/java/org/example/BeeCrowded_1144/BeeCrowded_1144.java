package org.example.BeeCrowded_1144;

import java.util.List;
import java.util.Scanner;

public class BeeCrowded_1144 {

    public static final List<Integer> testCases = List.of(
            5
    );

    public static void main(String[] args) {
        boolean finalSolution = true;

        if (finalSolution) {
            Scanner scanner = new Scanner(System.in);
            String inp = scanner.nextLine();
            solve(Integer.valueOf(inp));
        } else {
            for (int i : testCases){
                solve(i);
            }
        }
    }

    private static void solve(int inp) {
        boolean linhaPar = true;
        int currentLine = 1;
        int saida1, saida2, saida3;
        for (int i = 1; i <= inp * 2; i++) {
            if (linhaPar){
                saida1 = currentLine;
                saida2 = (int) Math.pow(currentLine, 2);
                saida3 = (int) Math.pow(currentLine, 3);
            } else {
                saida1 = currentLine;
                saida2 = (int) Math.pow(currentLine, 2) + 1;
                saida3 = (int) Math.pow(currentLine, 3) + 1;
                currentLine++;
            }
            System.out.println(saida1 + " " + saida2 + " " + saida3);
            linhaPar = !linhaPar;
        }
    }
}
