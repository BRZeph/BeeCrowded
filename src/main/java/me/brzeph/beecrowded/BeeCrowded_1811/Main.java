package me.brzeph.beecrowded.BeeCrowded_1811;


import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final List<String> testCases = List.of(
//            "4 10\n67 78 87 66 78 87 89 66 67 66\n77 79 99 98 98 98 97 78 78 89\n66 67 68 69 70 71 72 87 88 66\n75 77 90 95 94 97 99 66 88 99",
//            "4 7\n120 135 167 165 188 170 150\n98 76 60 78 108 100 110\n90 95 138 135 133 130 100\n70 68 74 67 75 67 100",
//            "2 5\n100 110 120 130 140 150\n90 100 110 120 130 140",
            "3 1\n100\n110\n130",
            "3 0\n\n\n"
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

                if (lines == 0){
                    return;
                }

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
                solve(s);
            }
        }
    }

    private static int solveCounter = 0;

    private static void solve(String inpS){
        solveCounter++;
        HashMap<Integer, Registry> registries = new HashMap<>();
        int outIdx = -1;
        for(String line : inpS.split("\n")){
            outIdx++;
            if (outIdx == 0){
                continue;
            }

            int max, min, counter;
            int last, current;
            int inIdx = 0;

            max = 0;
            min = 0;
            counter = 1;
            last = 0;

            for (String s : line.split(" ")){
                inIdx++;
                current = Integer.parseInt(s);
                if (inIdx == 1){
                    min = last = current;
                    registries.put(outIdx, new Registry(
                            counter, current, current
                    ));
                    continue;
                }

                if (current > last){
                    counter++;
                    max = last = current;
                } else {
                    counter = 1;
                    min = max = last = current;
                }

                if (!registries.containsKey(outIdx)){
                    registries.put(outIdx, new Registry(
                            counter, max, min
                    ));
                } else {
                    Registry currentRegistry = new Registry(counter, max, min);
                    Registry registry = registries.getOrDefault(outIdx, currentRegistry);
                    if (currentRegistry.counter > registry.counter){
                        registries.put(outIdx, currentRegistry);
                    } else if (currentRegistry.counter == registry.counter &&
                            currentRegistry.max - currentRegistry.min > registry.max - registry.min){
                        registries.put(outIdx, currentRegistry);
                    }
                }
            }
        }

//        for (Integer i : registries.keySet()){
//            Registry currentRegistry = registries.get(i);
//            System.out.println(i + ": " + currentRegistry);
//        }

        int maiorSeq = -1;
        int maiorDif = -1;
        int out = 1;
        int max = -1;

        for (Integer i : registries.keySet()){
            Registry r = registries.get(i);
            if (r.counter > maiorSeq){
                maiorSeq = r.counter;
                maiorDif = r.max - r.min;
                max = r.max;
                out = i;
            } else if (r.counter == maiorSeq && r.max - r.min > maiorDif){
                maiorDif = r.max - r.min;
                max = r.max;
                out = i;
            } else if (r.counter == maiorSeq && r.max - r.min == maiorDif && r.max > max){
                max = r.max;
                out = i;
            }
        }

        System.out.println("Instancia #" + solveCounter);
        System.out.println(out + "\n");
    }

    record Registry(int counter, int max, int min){
    }
}