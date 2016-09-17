import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {
    
    public static final int MAX_V_SPEED = 40;
    public static final int COEFF = 50;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        int[] landXs = new int[surfaceN];
        int[] landYs = new int[surfaceN];
        for (int i = 0; i < surfaceN; i++) {
            landXs[i] = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            landYs[i] = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
        }
        int middlePlatform = findMiddlePlatform(landXs, landYs);
        int heightPlatform = findHeightPlatform(landXs, landYs);
        // game loop
        while (true) {
            int X = in.nextInt();
            int Y = in.nextInt();
            int hSpeed = in.nextInt(); // the horizontal speed (in m/s), can be negative.
            int vSpeed = in.nextInt(); // the vertical speed (in m/s), can be negative.
            int fuel = in.nextInt(); // the quantity of remaining fuel in liters.
            int rotate = in.nextInt(); // the rotation angle in degrees (-90 to 90).
            int power = in.nextInt(); // the thrust power (0 to 4).

            String outPower = "";
            String outRotation = "";
            // Write an action using System.out.println()
            int maxHeight = findMaxHeightAhead(landXs, landYs, X, middlePlatform, heightPlatform);
            if(isLandable(middlePlatform, X, hSpeed)){
                System.err.println("LAND vSpeed : " + vSpeed);
                outPower = vSpeed < -30 ? "4" : "0";
                outRotation = "0";
            } else if(shouldLand(middlePlatform, X, hSpeed, heightPlatform, Y)){
                System.err.println("SHOULD LAND");
                outRotation = stabilizeHSpeed(hSpeed);
                outPower = "4";
            } else {
                System.err.println("HEAD TO PLATFORM");
                outRotation = headToPlatform(middlePlatform, hSpeed, X, maxHeight, vSpeed, Y);
                outPower = stabilize(vSpeed, outRotation);
            }
            System.out.println(outRotation + " " + outPower );
        }
    }
    
    public static int findMiddlePlatform(int[] landXs, int[] landYs){
        int middle = -1;
        for(int i = 0 ; i != landXs.length - 1 ; i++){
            if(landYs[i] == landYs[i+1]){
                middle = (landXs[i+1] + landXs[i]) / 2;
            }
        }
        return middle;
    }
    
    public static int findHeightPlatform(int[] landXs, int[] landYs){
        int height = -1;
        for(int i = 0 ; i != landXs.length - 1 ; i++){
            if(landYs[i] == landYs[i+1]){
                height = landYs[i];
            }
        }
        return height;
    }
    
    public static int findMaxHeightAhead(int[] landXs, int[] landYs, int X, int xPlatform, int yPlatform){
        int height = yPlatform;
        if(xPlatform > X){
            for(int i = 0 ; i != landYs.length - 1 ; i++){
                if(landXs[i] > xPlatform){
                    break;
                }
                if(landXs[i] > X){
                    int currentHeight = landYs[i];
                    if(currentHeight > height){
                        height = currentHeight;
                    }
                }
            }
        } else {
            for(int i = landYs.length - 1 ; i != 0 ; i--){
                if(landXs[i] < xPlatform){
                    break;
                }
                if(landXs[i] < X){
                    int currentHeight = landYs[i];
                    if(currentHeight > height){
                        height = currentHeight;
                    }
                }
            }
        }
        return height;
    }
    
    public static boolean isLandable(int middlePlatform, int X, int hSpeed){
        if(X > middlePlatform -750 && X < middlePlatform + 750 && Math.abs(hSpeed) < 20 ){
            return true;
        } else{
            return false;
        }
    }
    
    public static boolean shouldLand(int middlePlatform, int X, int speed, int heightPlatform, int Y){
        if(X > middlePlatform -750 && X < middlePlatform + 750 && Math.abs(speed) > 20 && Y > heightPlatform){
            return true;
        } else{
            return false;
        }
    }
    
    public static String headToPlatform(int middlePlatform, int hSpeed, int X, int heightPlatform, int vSpeed, int Y){
        if(Y < heightPlatform + 400 && vSpeed < 10){
            return "0";
        }
        int maxSpeed = Math.abs(middlePlatform - X) / COEFF;
        System.err.println(maxSpeed);
        if(hSpeed < -maxSpeed){
            return "-45";
        }
        if(hSpeed > maxSpeed){
            return "45";
        }
        if(X < middlePlatform){
            return "-20";
        }
        if(X > middlePlatform){
            return "20";
        }
        return "0";
    }
    
    public static String stabilizeHSpeed(int hSpeed){
        if(hSpeed < 0){
            return "-45";
        }
        if(hSpeed > 0){
            return "45";
        }
        return "0";
    }
    
    public static String stabilize(int vSpeed, String rotation){
        String power = "";
        if(rotation.equals("0")){
            power = "4";
        }
        if(vSpeed > 0){
            power = "0";
        } else{
            power = "4";
        }
        return power;
    }
}