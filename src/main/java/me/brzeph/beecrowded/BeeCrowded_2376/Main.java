package me.brzeph.beecrowded.BeeCrowded_2376;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
            "4 1\n1 0\n0 4\n3 1\n2 3\n1 2\n2 0\n0 2\n1 2\n4 3\n0 1\n3 2\n3 4\n1 4\n1 0", // F
            "2 0\n1 0\n2 1\n1 0\n1 0\n1 2\n1 2\n1 0\n2 1\n1 0\n0 1\n0 2\n2 1\n1 0\n2 1"  // A
    );

    public static void main(String[] args) {
        // TODO: remake this considering that the input will have 2^n lines.
        boolean finalSolution = false;

        if(finalSolution){
            Scanner scanner = new Scanner(System.in);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 15; i++) {
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
        String[] inpHelper = inpS.split("\n");
        Character curr = 'A' - 1;

        int idx = 1;
        int idx2 = 1;
        int idx3 = 1;
        int idx4 = 1;

        for(String s : inpHelper){
            String[] inpB = s.split(" ");

            int score1 = Integer.parseInt(inpB[0]);
            int score2 = Integer.parseInt(inpB[1]);

            if (idx <= 8) {
                Character teamA = addTo(curr, 1);
                Character teamB = addTo(curr, 2);
                curr = addTo(curr, 2);

                Game game = new Game(teamA, teamB, score1, score2);

//                System.out.println("idx1 game: " + game);

                matches.put(idx, game);
            } else if(idx <= 12) {
                Character c1 = Game.solveMatch(idx - 9 + idx2);
                Character c2 = Game.solveMatch(idx - 8 + idx2);

//                System.out.println("match " + (idx - 9 + idx2) + " winner: " + c1);
//                System.out.println("match " + (idx - 8 + idx2) + " winner: " + c2);

                Game game = new Game(c1, c2, score1, score2);

//                System.out.println("idx2 game: " + game);

                matches.put(idx, game);

                idx2++;
            } else if (idx <= 14) {
                Character c1 = Game.solveMatch(idx - 5 + idx3);
                Character c2 = Game.solveMatch(idx - 4 + idx3);

//                System.out.println("match " + (idx - 5 + idx3) + " winner: " + c1);
//                System.out.println("match " + (idx - 4 + idx3) + " winner: " + c2);

                Game game = new Game(c1, c2, score1, score2);

//                System.out.println("idx3 game: " + game);

                matches.put(idx, game);

                idx3++;
            } else if (idx == 15){
                Character c1 = Game.solveMatch(idx - 3 + idx4);
                Character c2 = Game.solveMatch(idx - 2 + idx4);

//                System.out.println("match " + (idx - 3 + idx4) + " winner: " + c1);
//                System.out.println("match " + (idx - 2 + idx4) + " winner: " + c2);

                Game game = new Game(c1, c2, score1, score2);

//                System.out.println("idx4 game: " + game);

                matches.put(idx, game);

                idx4++;
            }
            idx++;
        }

        System.out.println(Game.compare(matches.get(15)));
    }

    private static HashMap<Integer, Game> matches = new HashMap<>();

    private static Character addTo(Character base, int add){
        return (char) (base + add);
    }

    record Game(Character team1, Character team2, int goals1, int goals2){

        public static Character compare(Game game){
            assert game.goals1() != game.goals2();
            if (game.goals1() > game.goals2()){
                return game.team1();
            } else {
                return game.team2();
            }
        }

        public static Character solveMatch(int matchId){
            return compare(matches.get(matchId));
        }

    }
}