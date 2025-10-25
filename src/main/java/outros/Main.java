package outros;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String inp = sc.nextLine();
        String[] inpSplit = inp.split(" ");
        assert inpSplit.length == 2;
        String word1 = inpSplit[0];
        String word2 = inpSplit[1];
        solve(word1, word2);
    }

    private static void solve(String word1, String word2){
        StringBuilder output = new StringBuilder();
        int min = Math.min(word1.length(), word2.length());
        for (int i = 0; i < min; i++) {
            output.append(word1.charAt(i));
            output.append(word2.charAt(i));
        }
        if (word1.length() > word2.length()) {
            output.append(word1.substring(min));
        } else {
            output.append(word1.substring(min));
        }
        System.out.println(output);
    }
}
