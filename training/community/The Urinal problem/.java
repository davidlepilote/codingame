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
        int N = in.nextInt();;
        in.nextLine();
        String B = in.nextLine();
        double maxDistance = 0.;
        int index = -1;

        for (int i = 0; i < B.length(); i++) {
            char c = B.charAt(i);
            if (c == 'U') {
                int distanceRight = 0;
                boolean infinite = true;
                for (int right = i + 1; right < B.length(); right++) {
                    if (B.charAt(right) == '!') {
                        infinite = false;
                        break;
                    }
                    distanceRight++;
                }
                if(infinite){
                    distanceRight = Integer.MAX_VALUE;
                }
                infinite = true;
                int distanceLeft = 0;
                for (int left = i - 1; left >= 0; left--) {
                    if (B.charAt(left) == '!') {
                        infinite = false;
                        break;
                    }
                    distanceLeft++;
                }
                if(infinite){
                    distanceLeft = Integer.MAX_VALUE;
                }
                double minMaxDistance = Math.min(distanceLeft, distanceRight);

                if (minMaxDistance >= maxDistance) {
                    maxDistance = minMaxDistance;
                    index = i;
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(index);
    }
}