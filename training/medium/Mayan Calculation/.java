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
        Map<String, Integer> digits = new HashMap<>();
        Map<Character, String> strDigits = new HashMap<>();
        StringBuilder[] builders = new StringBuilder[20];
        for(int i = 0; i != 20; i++){
            builders[i] = new StringBuilder();
        }
        int L = in.nextInt();
        int H = in.nextInt();
        for (int i = 0; i < H; i++) {
            String numeral = in.next();
            for(int j = 0; j != 20; j++){
                String numberLine = numeral.substring(j * L, (j + 1) * L);
                builders[j].append(numberLine);
            }
        }
        for(int i = 0; i != 20; i++){
            digits.put(builders[i].toString(), i);
            System.err.println(Integer.toString(Integer.parseInt(String.valueOf(i), 10), 20).charAt(0) + ":" + builders[i].toString());
            strDigits.put(Integer.toString(Integer.parseInt(String.valueOf(i), 10), 20).charAt(0), builders[i].toString());
        }
        int S1 = in.nextInt();
        StringBuilder digit = new StringBuilder();
        String[] numberOne = new String[S1 / H];
        int numberIndex = 0;
        for (int i = 0; i < S1; i++) {
            if(i % H == 0 && i != 0){
                numberOne[numberIndex++] = digit.toString();
                digit = new StringBuilder();
            }
            String num1Line = in.next();
            digit.append(num1Line);
        }
        numberOne[numberIndex] = digit.toString();
        long firstNumber = 0;
        for(int i = 0; i != numberOne.length; i++){
            firstNumber += digits.get(numberOne[i]) * (Math.pow(20, numberOne.length - 1 - i));
        }
        int S2 = in.nextInt();
        digit = new StringBuilder();
        String[] numberTwo = new String[S2 / H];
        numberIndex = 0;
        for (int i = 0; i < S2; i++) {
            if(i % H == 0 && i != 0){
                numberTwo[numberIndex++] = digit.toString();
                digit = new StringBuilder();
            }
            String num1Line = in.next();
            digit.append(num1Line);
        }
        numberTwo[numberIndex] = digit.toString();
        long secondNumber = 0;
        for(int i = 0; i != numberTwo.length; i++){
            secondNumber += digits.get(numberTwo[i]) * (Math.pow(20, numberTwo.length - 1 - i));
        }
        String operation = in.next();
        char operator = operation.charAt(0);
        long result = firstNumber;
        switch (operator){
            case '+':
                result += secondNumber;
                break;
            case '-':
                result -= secondNumber;
                break;
            case '*':
                result *= secondNumber;
                break;
            case '/':
                result /= secondNumber;
                break;
        }

        String s = Long.toString(Long.parseLong(String.valueOf(result), 10), 20);
        System.err.println(result + ", " + s);
        for(int i = 0; i != s.length(); i++){
            String currentDigit = strDigits.get(s.charAt(i));
            System.err.println(s.charAt(i));
            for(int j = 0; j != H; j++){
                System.out.println(currentDigit.substring(j * L, (j + 1) * L));
            }
        }
    }
}