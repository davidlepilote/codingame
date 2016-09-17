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
        int n = in.nextInt();
        in.nextLine();
        String vs = in.nextLine();
        String[] split = vs.split(" ");
        int highestValue = 0;
        int loss = 0;
        for(String stringValue : split){
            int value = Integer.parseInt(stringValue);
            if(value > highestValue){
                highestValue = value;
            } else {
                int newLoss = highestValue - value;
                if(newLoss > loss){
                    loss = newLoss;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(loss > 0 ? -loss : 0);
    }
}