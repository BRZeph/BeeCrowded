package me.brzeph.beecrowded.BeeCrowded_2875;

import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "3 3\nX 1 1\n0 0 1\n1 0 1",
            "5 6\n1 X 1 1 0 1\n0 0 1 1 0 1\n0 1 1 1 0 1\n0 0 0 1 0 1\n1 1 0 0 0 1"
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
//                System.out.println("\n\nTest case: " + i);
//                System.out.println("Input: " + s);
                solve(s);
            }
        }
    }

    public static void solve(String inpS){
        String[] inpOut = inpS.split("\n");
        int matX = Integer.parseInt(inpOut[0].split(" ")[0]);
        int matY = Integer.parseInt(inpOut[0].split(" ")[1]);

        String[][] matrix = new String[matX][matY];

        int idx = -1;
        int idxX;

        for (String s : inpOut){
            idx++;
            if (idx == 0) continue;

            idxX = 0;

            for (String matS : s.split(" ")){
                idxX++;
//                System.out.println("idx " + idx);
//                System.out.println("idxX " + idxX);
                matrix[idx - 1][idxX - 1] = matS;
            }
        }

        processMatrix(matrix);
    }

    private static void processMatrix(String[][] matrix) {
        StringBuilder sb = new StringBuilder();
        findNextMove(matrix, sb, Direction.DOWN);
        sb.append(" E");
        sb.deleteCharAt(0);
        System.out.println(sb);
    }

    private static void findNextMove(String[][] matrix, StringBuilder sb, Direction dir) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!matrix[i][j].equals("X")) {
                    continue;
                }
                if (i < matrix.length - 1 && matrix[i + 1][j].equals("0")){ // DOWN
                    matrix[i][j] = "1";
                    matrix[i + 1][j] = "X";
//                    System.out.println("i + 1");
//                    System.out.println(dir.toString());
                    switch (dir){
                        case DOWN:
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.DOWN);
                            return;
                        case LEFT:
                            sb.append(" L");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.DOWN);
                            return;
                        case RIGHT:
                            sb.append(" R");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.DOWN);
                            return;
                    }
                }
                if (j < matrix[i].length - 1 && matrix[i][j + 1].equals("0")){ // RIGHT
                    matrix[i][j] = "1";
                    matrix[i][j + 1] = "X";
//                    System.out.println("j + 1");
//                    System.out.println(dir.toString());
                    switch (dir){
                        case RIGHT:
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.RIGHT);
                            return;
                        case UP:
                            sb.append(" R");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.RIGHT);
                            return;
                        case DOWN:
                            sb.append(" L");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.RIGHT);
                            return;
                    }
                }
                if (i > 0 && matrix[i - 1][j].equals("0")){ // UP
                    matrix[i][j] = "1";
                    matrix[i - 1][j] = "X";
//                    System.out.println("i - 1");
//                    System.out.println(dir.toString());
                    switch (dir){
                        case UP:
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.UP);
                            return;
                        case LEFT:
                            sb.append(" R");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.UP);
                            return;
                        case RIGHT:
                            sb.append(" L");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.UP);
                            return;
                    }
                }
                if (j > 0 && matrix[i][j - 1].equals("0")){ // LEFT
                    matrix[i][j] = "1";
                    matrix[i][j - 1] = "X";
//                    System.out.println("j - 1");
//                    System.out.println(dir.toString());
                    switch (dir){
                        case LEFT:
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.LEFT);
                            return;
                        case UP:
                            sb.append(" L");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.LEFT);
                            return;
                        case DOWN:
                            sb.append(" R");
                            sb.append(" F");
                            findNextMove(matrix, sb, Direction.LEFT);
                            return;
                    }
                }
            }
        }
    }

    enum Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
