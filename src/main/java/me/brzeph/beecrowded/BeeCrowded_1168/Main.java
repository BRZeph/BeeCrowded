package me.brzeph.beecrowded.BeeCrowded_1168;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "3\n115380\n2819311\n23456",
            "1\n0"
    );
    /*
"3\n115380\n2819311\n23456"
     */

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){
                String inp = scanner.nextLine();
                StringBuilder sb = new StringBuilder();
                sb.append(inp).append("\n");
                int lines = Integer.parseInt(inp.split(" ")[0]);
                for (int i = 0; i < lines; i++) {
                    sb.append(scanner.nextLine()).append("\n");
                }
                solve(sb.toString());
            }

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
        String[] sb = inpS.split("\n");
        int idx = 0;
        for (String s : sb){
            idx++;
            if (idx == 1) continue;
            int total = 0;
            for (char c : s.toCharArray()){
                total += getCost(Integer.parseInt(c + ""));
            }
            System.out.println(total + " leds");
        }
    }

    public static int getCost(int n){
        assert n >= 0 && n < 10;
        return switch (n) {
            case 1 -> 2;
            case 2, 3, 5 -> 5;
            case 4 -> 4;
            case 9, 6, 0 -> 6;
            case 7 -> 3;
            case 8 -> 7;
            default -> throw new IllegalArgumentException("Invalid: " + n);
        };
    }
}
