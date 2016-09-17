import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<Integer> puissances = new ArrayList<Integer>();
        for (int i = 0; i < N; i++) {
            int Pi = in.nextInt();
            puissances.add(Pi);
        }
        int distance = Integer.MAX_VALUE;
        int previous = -1;
        Collections.sort(puissances);
        for(Integer Pi : puissances){
            if(previous == -1){
                previous = Pi;
                continue;
            }
            distance = Math.min(distance, Pi - previous);
            previous = Pi;
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(distance);
    }
}