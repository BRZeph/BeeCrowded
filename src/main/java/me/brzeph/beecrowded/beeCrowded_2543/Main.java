package me.brzeph.beecrowded.beeCrowded_2543;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "7 5558\n5693 1\n5558 0\n6009 1\n5558 1\n1566 0\n5558 0\n8757 1\n5558 0\n5558 0",
            "1 5454\n5454 0",
            "1 5454\n5454 1",
            "1 5454\n5455 1",
            "1 5454\n5455 0"
            /*
"7 5558\n5693 1\n5558 0\n6009 1\n5558 1\n1566 0\n5558 0\n8757 1"
             */
    );

    public static void main(String[] args) {
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            while(scanner.hasNext()){

                StringBuilder sb = new StringBuilder();

                String input = scanner.nextLine();
                sb.append(input).append("\n");
                int iterations = Integer.parseInt(input.split(" ")[0]);

                for (int i = 0; i < iterations; i++) {
                    sb.append(scanner.nextLine()).append("\n");
                }
                solve(sb.toString());
            }
            scanner.close();

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
        String[] inpLines = inpS.split("\n");
        int id = Integer.parseInt(inpLines[0].split(" ")[1]);
        int counter = 0;
        for(String line : inpLines){
            String[] inpB = line.split(" ");
            int word1 = Integer.parseInt(inpB[0]);
            int word2 = Integer.parseInt(inpB[1]);

            if (word1 == id && word2 == 0){
                counter++;
            }
        }
        System.out.println(counter);
    }
}
