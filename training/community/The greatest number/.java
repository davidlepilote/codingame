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
        in.nextLine();
        String input = in.nextLine();

        boolean isNegative = input.contains("-");

        boolean isFloat = input.contains(".");

        boolean onlyZero = true;

        List<Integer> digits = new ArrayList<>();

        for (char c : input.toCharArray()) {
            if (Character.isDigit(c)) {
                Integer e = Integer.valueOf("" + c);
                if(e != 0){
                    onlyZero = false;
                }
                digits.add(e);
            }

        }

        if (isNegative) {
            Collections.sort(digits);
        } else {
            Collections.sort(digits, new Comparator<Integer>() {
                @Override
                public int compare(Integer o1, Integer o2) {
                    return o2 - o1;
                }
            });
        }


        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if(onlyZero){
            System.out.println("0");
        } else {
            StringBuilder soluce = new StringBuilder();
            for (int i = 0; i < digits.size(); i++) {
                if (i == 0 && isNegative) {
                    soluce.append("-");
                }
                if (i == 1 && isFloat && isNegative) {
                    soluce.append(".");
                }
                if (i == digits.size() - 1 && isFloat && !isNegative && digits.get(digits.size() - 1) != 0) {
                    soluce.append(".");
                }
                if (!(i == digits.size() - 1 && isFloat && !isNegative && digits.get(digits.size() - 1) == 0)){
                    soluce.append(digits.get(i));
                }
            }
            System.out.println(soluce.toString());
        }
    }
}