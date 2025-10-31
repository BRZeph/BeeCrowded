package me.brzeph.beecrowded.BeeCrowded_1043;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class Main {

//    private static final List<String> testCases = List.of(
//            "6.0 4.0 2.0",
//            "6.0 4.0 2.1",
//            "1 2 5" // Edge case: not possible to form a triangle
//    );

    public static void main(String[] args) throws IOException {
//        boolean finalSolution = false;
//
//        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            solve(scanner.nextLine());
//        } else {
//            int i = 0;
//            for (String s : testCases){
//                i++;
//                System.out.println("\n\nTest case: " + i);
//                solve(s);
//            }
//        }
    }

    private static void solve(String inpS) {
        float a, b, c;
        String[] inpB = inpS.split(" ");
        a = Float.valueOf(inpB[0]);
        b = Float.valueOf(inpB[1]);
        c = Float.valueOf(inpB[2]);

        if ((a >= b + c) || (b >= a + c) || (c >= b + a)){ // Edge case: not possible to form a triangle.
            System.out.println("Area = " + ( ( a + b ) * c / 2)); // A = (B + b)*h/2
        } else {
            System.out.println("Perimetro = " + ( a + b + c ));
        }
    }
}