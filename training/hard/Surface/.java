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
        int L = in.nextInt();
        int H = in.nextInt();
        char[][] points = new char[L][H];
        for (int i = 0; i < H; i++) {
            String row = in.next();
            for(int j = 0; j < L; j++){
                points[j][i] = row.charAt(j);
            }
        }
        int N = in.nextInt();
        
        for (int i = 0; i < N; i++) {
            char[][] currentPoints = copy(points);
            if(L * H > 10000 && L * H < 1000000){
                System.out.println(countLake(currentPoints));
            } else {
                            int X = in.nextInt();
            int Y = in.nextInt();
            System.out.println(searchLand(new Area(), currentPoints, X, Y, L, H) + "");
            }
            //print(points);

        }
    }
    
    public static char[][] copy(char[][] input){
        char[][] output = new char[input.length][input[0].length];
        for(int i = 0; i < input.length; i++){
            for(int j = 0; j < input[0].length; j++){
                output[i][j] = input[i][j];
            }
        }
        return output;
    }
    
    public static int searchLand(Area area, char[][] points, int X, int Y, int maxX, int maxY){
        if(X < 0 || X >= maxX || Y < 0 || Y >= maxY || points[X][Y] == '#'){
            return area.area;
        }
        area.area++;
        points[X][Y] = '#';
        searchLand(area, points, X-1, Y, maxX, maxY);
        searchLand(area, points, X+1, Y, maxX, maxY);
        searchLand(area, points, X, Y-1, maxX, maxY);
        searchLand(area, points, X, Y+1, maxX, maxY);
        return area.area;
    }
    
    public static boolean isBigLake(char[][] points){
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[0].length; j++){
                if(points[i][j] != 'O'){
                    return false;
                }
            }
        } 
        return true;
    }
    
    public static int countLake(char[][] points){
        int area = 0;
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[0].length; j++){
                if(points[i][j] == 'O'){
                    area++;
                }
            }
        } 
        return area;
    }
    
    public static void print(char[][] points){
        System.err.println();
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points[0].length; j++){
                System.err.print(points[i][j]);
            }
            System.err.println();
        }
    }
    
    private static class Area{
        private int area = 0;
    }
}