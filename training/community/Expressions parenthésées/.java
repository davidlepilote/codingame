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
        String expression = in.next();
                
        int parenthese = 0;
        int crochet = 0;
        int accolade = 0;
        
        boolean caca = true;
        
        for (char c : expression.toCharArray()) {
            switch (c){
                case '(':
                    parenthese++;
                    break;
                case ')':
                    parenthese--;
                    break;
                case '[':
                    crochet++;
                    break;
                case ']':
                    crochet--;
                    break;
                case '{':
                    accolade++;
                    break;
                case '}':
                    accolade--;
                    break;
            }
            if(parenthese < 0 || accolade < 0 || crochet < 0){
                System.out.println("false");
                caca = false;
                break;
            }
        }

        if(caca)
            System.out.println(parenthese == 0 && accolade == 0 && crochet == 0);
    }
}