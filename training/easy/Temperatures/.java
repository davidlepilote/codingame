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
        int N = in.nextInt(); // the number of temperatures to analyse
        in.nextLine();
        String TEMP = in.nextLine(); // the N temperatures expressed as integers ranging from -273 to 5526
        String[] temps = TEMP.split(" ");
        int result = Integer.MAX_VALUE;
        for(int i = 0; i < N; i++){
            int temp = Integer.parseInt(temps[i]);
            System.err.println(result);
            if(Math.abs(temp) < Math.abs(result)){
                result = temp;
            } else if(Math.abs(temp) == Math.abs(result) && temp >= 0){
                result = temp;
            }
        }
        System.out.println(result == Integer.MAX_VALUE ? 0 : result);
    }
}