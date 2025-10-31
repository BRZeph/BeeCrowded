package me.brzeph.beecrowded.BeeCrowded_1047;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "7 8 9 10",
            "7 8 9 38",
            "7 50 7 30", // Edge case: 23.x hour long game without changing the hour.
            "7 7 7 7", // Edge case: 24 hour long game.
            "7 10 8 9", // Edge case: game with less than 1 hour duration.
            "20 1 3 10" // Edge case: starts late in one day and finishes early in another.
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
        int a, b, c, d;
        String[] inpB = inpS.split(" ");
        a = Integer.parseInt(inpB[0]);
        b = Integer.parseInt(inpB[1]);
        c = Integer.parseInt(inpB[2]);
        d = Integer.parseInt(inpB[3]);

        if (a == c && b == d){ // Edge case: 24 hour long game.
            System.out.println("O JOGO DUROU " + 24 + " HORA(S) E " + 0 + " MINUTO(S)");
            return;
        }

        if (
                a > c || // Edge case: starts late in one day and finishes early in another.
                (b > d && a == c) // Edge case: 23.x hour long game without changing the hour.
        ){
            c += 24;
        }

        int minI = a*60 + b;
        int minF = c*60 + d;
        int duration = minF - minI;

        if (duration < 60){ // Edge case: game with less than 1 hour duration.
            System.out.println("O JOGO DUROU " + 0 + " HORA(S) E " + duration + " MINUTO(S)");
            return;
        }

        System.out.println("O JOGO DUROU " + ( duration / 60 ) + " HORA(S) E " + ( duration % 60 ) + " MINUTO(S)");
    }
}