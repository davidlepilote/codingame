import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Don't let the machines win. You are humanity's last hope...
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt(); // the number of cells on the X axis
        in.nextLine();
        int height = in.nextInt(); // the number of cells on the Y axis
        in.nextLine();
        boolean[][] cases = new boolean[height][width];
        for (int i = 0; i < height; i++) {
            String line = in.nextLine(); // width characters, each either 0 or .
            int j = 0;
            for(char isOn : line.toCharArray()){
                cases[i][j] = isOn == '0';
                j++;
            }
            System.err.println(line);
        }
        
        StringBuilder builder = new StringBuilder();
        for(int i = 0 ; i != height ; i++){
            for(int j = 0 ; j != width; j++){
                if(cases[i][j] == true){
                    builder.append(j).append(" ").append(i).append(" ");
                    boolean isHorizontal = false;
                    for(int jj = j + 1; jj < width; jj++){
                        if(cases[i][jj]){
                            builder.append(jj).append(" ").append(i).append(" ");
                            isHorizontal = true;
                            break;
                        }
                    }
                    if(!isHorizontal){
                        builder.append("-1 -1 ");
                    }
                    boolean isVertical = false;
                    for(int ii = i + 1; ii < height; ii++){
                        if(cases[ii][j]){
                            builder.append(j).append(" ").append(ii);
                            isVertical = true;
                            break;
                        }
                    }
                    if(!isVertical){
                        builder.append("-1 -1");
                    }
                    builder.append("\n");
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(builder.toString()); // Three coordinates: a node, its right neighbor, its bottom neighbor
    }
}