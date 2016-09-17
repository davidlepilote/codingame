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
        int R = in.nextInt();
        int L = in.nextInt();

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        List<Integer> answer1 = new ArrayList<>();
        answer1.add(R);
        String answer = R + "";
        for(int i = 0; i != L - 1; i++){
        	answer = computeNextLine(answer);
        	answer1 = computeNextLine(answer1);
        }
        System.out.println(prepareAnswer(answer1));
    }
    
    public static String prepareAnswer(String answer){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i != answer.length() - 1; i++){
            builder.append(answer.charAt(i)).append(" ");
        }
        builder.append(answer.charAt(answer.length() - 1));
        return builder.toString();
    }
    
    public static String prepareAnswer(List<Integer> answer){
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i != answer.size() - 1; i++){
            builder.append(answer.get(i)).append(" ");
        }
        builder.append(answer.get(answer.size() - 1));
        return builder.toString();
    }
    
    public static List<Integer> computeNextLine(List<Integer> line){
    	List<Integer> builder = new ArrayList<>();
    	int nbDigits = 1;
    	int previousNb = line.get(0);
    	for(int i = 1; i < line.size(); i++){
    		int currentNb = line.get(i);
    		if(currentNb == previousNb){
    			nbDigits++;
    		} else {
    			builder.add(nbDigits);
    			builder.add(previousNb);
    			nbDigits = 1;
    			previousNb = currentNb;
    		}
    	}
    	builder.add(nbDigits);
    	builder.add(previousNb);
    	return builder;
    }
    
    public static String computeNextLine(String line){
    	StringBuilder builder = new StringBuilder();
    	int nbDigits = 1;
    	char previousChar = line.charAt(0);
    	for(int i = 1; i < line.length(); i++){
    		char currentChar = line.charAt(i);
    		if(currentChar == previousChar){
    			nbDigits++;
    		} else {
    			builder.append(nbDigits).append(previousChar);
    			nbDigits = 1;
    			previousChar = currentChar;
    		}
    	}
    	builder.append(nbDigits).append(previousChar);
    	return builder.toString();
    }
}