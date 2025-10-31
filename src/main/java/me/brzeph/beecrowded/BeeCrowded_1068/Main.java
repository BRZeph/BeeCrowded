package me.brzeph.beecrowded.BeeCrowded_1068;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "a+(b*c)-2-a",
            "(a+b*(2-c)-2+a)*2",
            "(a*b-(2+c)",
            "2*(3-a))",
            ")3+b*(2-c)("
    );
    public static void main(String[] args) {
        boolean finalSolution = true;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                solve(scanner.nextLine());
            }

        } else {
            int i = 0;
            for (String s : testCases){
                i++;
                System.out.println("\n\nTest case: " + i);
                solve(s);
            }
        }
    }

    public static void solve(String inpS){
        if (inpS.isEmpty()) return;
        for (String line : inpS.split("\n")){
            if (line.isEmpty()) continue;
            String processed = "";
            for (char c : line.toCharArray()){
                String s = String.valueOf(c);
                if (!s.equals("(") && !s.equals(")")) continue;
                processed += s;
            }
            String temp;
            do {
                temp = processed;
                processed = processed.replace("()", "");
            } while (!temp.equals(processed));
            if (processed.isEmpty()){
                System.out.println("correct");
            } else {
                System.out.println("incorrect");
            }
        }
    }
}
