import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        Map<Integer, String> code = new HashMap<>();
        code.put(0, "00");
        code.put(1, "0");

        Scanner in = new Scanner(System.in);
        //String mESSAGE = "%";
        String mESSAGE = in.nextLine();

        String binaryWord = getBinaryWord(mESSAGE);
        int oldBinary = Integer.parseInt(binaryWord.substring(0, 1));
        int index = 1;
        int sequenceSize = 1;
        StringBuilder builder = new StringBuilder();
        while(index < binaryWord.length()){
            int currentBinary = Integer.parseInt(binaryWord.substring(index, index + 1));
            if(currentBinary == oldBinary){
                sequenceSize++;
            } else {
                builder.append(code.get(oldBinary))
                        .append(' ')
                        .append(getSequence(sequenceSize))
                        .append(' ');
                sequenceSize = 1;
                oldBinary = currentBinary;
            }
            index++;
        }
        builder.append(code.get(oldBinary))
                .append(' ')
                .append(getSequence(sequenceSize));
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(builder.toString().trim());
    }

    public static String getSequence(int sequenceSize){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i != sequenceSize; i++){
            builder.append("0");
        }
        return builder.toString();
    }

    public static String getBinaryWord(String word){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i != word.length(); i++){
            String letter = word.substring(i, i + 1);
            BigInteger bi = new BigInteger(letter.getBytes());
            String binaryWithoutZeros = bi.toString(2);
            StringBuilder builderZeros = new StringBuilder();
            for(int j = 0; j != 7 - binaryWithoutZeros.length(); j++){
                builderZeros.append("0");
            }
            builderZeros.append(binaryWithoutZeros);
            builder.append(builderZeros);
        }
        return builder.toString();
    }
}