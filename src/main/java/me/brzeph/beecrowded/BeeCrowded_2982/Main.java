package me.brzeph.beecrowded.BeeCrowded_2982;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "G 10\nV 20\nG 10\nG 100\nV 30"
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            int lines = Integer.parseInt(scanner.nextLine());
            StringBuilder sb = new StringBuilder();
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
                System.out.println("Input: " + s);
                solve(s);
            }
        }
    }

    private static void solve(String inpS) {
        String[] sb = inpS.split("\n");
        int money = 0;
        for(String s : sb){
            String[] innerSb = s.split(" ");
            String type = innerSb[0];
            int val = Integer.parseInt(innerSb[1]);

            if (type.equals("V")){
                money += val;
            } else {
                money -= val;
            }
        }

        if (money < 0){
            System.out.println("NAO VAI TER CORTE, VAI TER LUTA!");
        } else {
            System.out.println("A greve vai parar.");
        }
    }
}