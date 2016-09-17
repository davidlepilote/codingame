import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    static int maxX = Integer.MAX_VALUE;
    static int maxY = Integer.MAX_VALUE;
    static int minX = 0;
    static int minY = 0;

    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        int w = in.nextInt(); // width of the building.
        int h = in.nextInt(); // height of the building.
        int n = in.nextInt(); // maximum number of turns before game over.
        int x0 = in.nextInt();
        int y0 = in.nextInt();

        maxX = w;
        maxY = h;
        int batmanX = x0;
        int batmanY = y0;

        // game loop
        while (true) {
            String bOMBDIR = in.next(); // the direction of the bombs from batman's current location (U, UR, R, DR, D, DL, L or UL)

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            batmanX = moveOnX(batmanX, bOMBDIR);
            batmanY = moveOnY(batmanY, bOMBDIR);
            System.err.println(minX + ", " + maxX + " " + minY + ", " + maxY);
            System.out.println(batmanX + " " + batmanY); // the location of the next window Batman should jump to.
        }
    }

    public static int moveOnX(int batmanX, String bombDirection){
        int move = batmanX;
        if(bombDirection.contains("R")){
            if(maxX - batmanX == 1){
                move = maxX;
            }
            else {
                if ((maxX + batmanX) % 2 == 0) {
                    move = (maxX + batmanX) / 2;
                } else {
                    move = 1 + (maxX + batmanX) / 2;
                }
            }
            minX = batmanX;
        }
        if(bombDirection.contains("L")){
            if(batmanX - minX == 1){
                move = minX;
            } else {
                if ((minX + batmanX) % 2 == 0) {
                    move = (minX + batmanX) / 2;
                } else {
                    move = 1 + (minX + batmanX) / 2;
                }
                maxX = batmanX;
            }
        }
        return move;
    }

    public static int moveOnY(int batmanY, String bombDirection){
        int move = batmanY;
        if(bombDirection.contains("U")){
            if(batmanY - minY == 1){
                move = minY;
            } else {
                if((minY + batmanY) % 2 == 0){
                    move = (minY + batmanY) / 2;
                } else {
                    move = (minY + batmanY) / 2;
                }
            }
            maxY = batmanY;
        }
        if(bombDirection.contains("D")){
            if(maxY - batmanY == 1){
                move = maxY;
            } else {
                if ((maxY + batmanY) % 2 == 0) {
                    move = (maxY + batmanY) / 2;
                } else {
                    move = 1 + (maxY + batmanY) / 2;
                }
            }
            minY = batmanY;
        }
        return move;
    }
}