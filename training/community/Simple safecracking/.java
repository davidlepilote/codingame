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
        String msg = in.nextLine();

        char t = msg.substring(0, 1).toLowerCase().charAt(0);

        char e = msg.charAt(2);

        String code = msg.substring(msg.indexOf(": ") + ": ".length());

        String[] split = code.split("-");

        String finalCode = "";
        for (String digit : split) {
            if (digit.length() == 5) {
                if (digit.charAt(4) == digit.charAt(3)) {
                    finalCode += "3";
                } else if (digit.charAt(4) == t) {
                    finalCode += "8";
                } else {
                    finalCode += "7";
                }
            } else if (digit.length() == 4) {
                if (digit.charAt(0) == digit.charAt(2)) {
                    finalCode += "9";
                } else if (digit.charAt(1) == e) {
                    finalCode += "0";
                } else if (digit.charAt(3) == e) {
                    finalCode += "5";
                } else {
                    finalCode += "4";
                }
            } else {
                if (digit.charAt(0) == t) {
                    finalCode += "2";
                } else if (digit.charAt(2) == e) {
                    finalCode += "1";
                } else {
                    finalCode += "6";
                }
            }
        }

        System.out.println(finalCode);
    }
}