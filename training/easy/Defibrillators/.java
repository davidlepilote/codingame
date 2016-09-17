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
        String lON = in.next();
        in.nextLine();
        String lAT = in.next();
        in.nextLine();
        int n = in.nextInt();
        in.nextLine();
        double closest = Double.MAX_VALUE;
        double lon = Double.parseDouble(lON.replace(',','.'));
        double lat = Double.parseDouble(lAT.replace(',','.'));
        String answer = "";
        for (int i = 0; i < n; i++) {
            String dEFIB = in.nextLine();
            String[] split = dEFIB.split(";");
            double currentLon = Double.parseDouble(split[4].replace(',','.'));
            double currentLat = Double.parseDouble(split[5].replace(',','.'));
            double currentDistance = getDistance(lon, lat, currentLon, currentLat);
            if(currentDistance < closest){
                answer = split[1];
                closest = currentDistance;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(answer);
    }
    
    public static double getDistance(double lon1, double lat1, double lon2, double lat2){
        double x = (lon2 - lon1) * Math.cos((lat1 + lat2) / 2);
        double y = lat2 - lat1;
        return Math.sqrt(x * x + y * y) * 6371.;
    }
}