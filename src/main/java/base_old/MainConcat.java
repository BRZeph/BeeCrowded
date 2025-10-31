package base_old;

import java.util.List;
import java.util.Scanner;

public class MainConcat {

    private static final List<String> testCases = List.of(
            "G 10\nV 20\nG 10\nG 100\nV 30"
    );

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

    }
}
