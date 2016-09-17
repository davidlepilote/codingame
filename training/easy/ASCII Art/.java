import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    private final static char[] LETTERS = new char[]{'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z','?'};

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int l = in.nextInt();
        in.nextLine();
        int h = in.nextInt();
        Map<Character, String[]> letters = new HashMap<>();
        for(int i = 0; i != LETTERS.length; i++){
            letters.put(LETTERS[i], new String[h]);
        }
        in.nextLine();
        String word = in.nextLine();
        for (int line = 0; line < h; line++) {
            String row = in.nextLine();
            for(int i = 0; i != LETTERS.length; i++){
                letters.get(LETTERS[i])[line] = row.substring(i * l, i * l + l);
            }
        }

        StringBuilder builder = new StringBuilder();
        for (int line = 0; line < h; line++) {
            for (char letter : word.toCharArray()) {
                char upperCaseLetter = Character.toUpperCase(letter);
                if(letters.containsKey(upperCaseLetter)){
                    builder.append(letters.get(upperCaseLetter)[line]);
                } else {
                    builder.append(letters.get('?')[line]);
                }
            }
            builder.append("\n");
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(builder.toString());
    }
}