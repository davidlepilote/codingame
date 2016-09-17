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
        List<Long> ys = new ArrayList<>();
        long minX = Long.MAX_VALUE;
        long maxX = Long.MIN_VALUE;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            int X = in.nextInt();
            int Y = in.nextInt();
            if(minX > X){
                minX = X;
            }
            if(maxX < X){
                maxX = X;
            }
            if(minY > Y){
                minY = Y;
            }
            if(maxY < Y){
                maxY = Y;
            }
            ys.add((long) Y);
        }
        Collections.sort(ys);
        int median = (N / 2);
        long y = ys.get(median);
        for(int i = 0; i < N; i++){
            System.err.println(ys.get(i));
        }

        long distance = 0;
        for (int i = 0; i < N; i++) {
            distance += Math.abs(ys.get(i) - y);
        }
        System.err.println(minX + ", " + maxX); 
//        mean /= N;
//        int minDistance = Integer.MAX_VALUE;
//        for(long i = Math.max(minY, mean-100); i <= Math.min(maxY, mean+100); i++){
//            int distance = 0;
//            for(int j = 0; j != N; j++){
//                distance += Math.abs(ys[j] - i);
//                if(distance > minDistance){
//                    break;
//                }
//            }
//            if(distance < minDistance){
//                minDistance = distance;
//            }
//        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println((distance + maxX - minX) + "");
    }
}