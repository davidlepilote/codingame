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
        String entry = "";
        for (int i = 0; i < N; i++) {
            entry += in.nextLine();
        }
        //entry = "       (  '  0() ; =  '   =   12      )       ";
        entry = entry.replaceAll("\n", "").trim();
        //entry = entry.replaceAll("\t", "").trim();

        boolean isQuote = false;
        boolean emptyBlock = false;
        StringBuilder output = new StringBuilder();
        char current;
        char follow;
        char before;
        int index = 0;
        int indentation = 0;
        boolean isNewLine = false;
        int entrySize = entry.length();

        while(index < entrySize){
            current = entry.charAt(index++);
            if(isQuote) {
                if (current == '\'') {
                    isQuote = false;
                }
                output.append(current);
            } else {
                if(current != ' ' && current != '\t'){
                    output.append(current);
                }
                if(current == '\''){
                    isQuote = true;
                }
            }
        }

        System.err.println(output.toString());

        entry = output.toString();
        entrySize = entry.length();
        output = new StringBuilder();
        index = 0;
        System.err.println(entry);

        while(index < entrySize){
            if(index != 0){
                before = entry.charAt(index - 1);
            } else {
                before = '#';
            }
            current = entry.charAt(index++);
            if(index != entrySize){
                follow = entry.charAt(index);
            } else {
                follow = '#';
            }
            if(isQuote){
                if(current == '\''){
                    isQuote = false;
                }
                output.append(current);
            } else {
                if(current != ' '){
                    switch (current){
                        case ('\''):
                            output.append(current);
                            isQuote = true;
                            break;
                        case (';'):
                            output.append(current);
                            newLine(output, indentation);
                            isNewLine = true;
                            break;
                        case ('('):
                            if(follow != ')'){
                                indentation++;
                            }
                            output.append(current);
                            newLine(output, indentation);
                            break;
                        case ('='):
                            output.append(current);
                            if(follow == '('){
                                newLine(output, indentation);
                            }
                            break;
                        case (')'):
                            if(before != '('){
                                indentation--;
                                newLine(output, indentation);
                                isNewLine = false;
                            }
                            output.append(current);
                            break;
                        default:
                            output.append(current);
                    }
                }
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        String answer = output.toString().trim();
        if(answer.charAt(answer.length()-1) == '\n'){
            answer = answer.substring(0, answer.length()-1);
        }
        System.out.println(answer);
    }

    public static void newLine(StringBuilder builder, int indentation){
        builder.append('\n');
        for(int i = 0; i < indentation * 4; i++){
            builder.append(' ');
        }
    }
}