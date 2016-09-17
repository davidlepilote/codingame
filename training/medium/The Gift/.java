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
        List<Integer> budgets = new ArrayList<>();
        List<Integer> pay = new ArrayList<>();
        int N = in.nextInt();
        int C = in.nextInt();
        int sum = 0;
        for (int i = 0; i < N; i++) {
            int B = in.nextInt();
            sum += B;
            budgets.add(B);
            pay.add(0);
        }
        Collections.sort(budgets);

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        int sumPaid = 0;
        if(C > sum){
            System.out.println("IMPOSSIBLE");
        } else {
            while(true) {
                for (int i = N - 1; i >= 0; i--) {
                    if (pay.get(i) < budgets.get(i)) {
                        pay.set(i, pay.get(i) + 1);
                        sumPaid++;
                    }
                    if (sumPaid == C) {
                        for (int j = 0; j < N; j++) {
                            System.err.println(pay.get(j));
                        }
                        for (int j = 0; j < N; j++) {
                            System.out.println(pay.get(j));
                        }
                        return;
                    }
                }
            }
        }

    }
}