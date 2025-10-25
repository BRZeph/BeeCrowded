package org.example.base;

import java.util.List;
import java.util.Scanner;

public class base {

    private static final List<String> testCases = List.of(
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

    }
}