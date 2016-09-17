import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {



    public static void main(String args[]) {

        Map<Character, Integer> points = makePointsMap();
        Map<Character, Integer> letters = makeLettersMap("");

        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            words.add(in.nextLine());
        }
        String lETTERS = in.nextLine();

        int highestScore = 0;
        String bestWord = "";
        for (String word : words) {
            letters = makeLettersMap(lETTERS);
            int currentScore = check(word, letters, points);
            System.err.println(currentScore);
            if(currentScore > highestScore){
                highestScore = currentScore;
                bestWord = word;
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(bestWord);
    }

    private static int check(String word, Map<Character, Integer> letters, Map<Character, Integer> points){
        int score = 0;
        if(word.length() <= 7){
            for (char letter : word.toCharArray()) {
                if(!letters.containsKey(letter)){
                    score = 0;
                    break;
                }
                score += points.get(letter);
                if(letters.get(letter) <= 1){
                    letters.remove(letter);
                } else {
                    letters.put(letter, letters.get(letter) - 1);
                }
            }
        }
        return score;
    }
    
    private static Map<Character, Integer> makeLettersMap(String letters){
        Map<Character, Integer> letterMap = new HashMap<>();
        for (char letter : letters.toCharArray()) {
            if(letterMap.containsKey(letter)){
                letterMap.put(letter, letterMap.get(letter) + 1);
            } else {
                letterMap.put(letter, 1);
            }
        }
        return letterMap;
    }

    private static Map<Character, Integer> makePointsMap() {
        Map<Character, Integer> points = new HashMap<>();
        points.put('e',1);
        points.put('a',1);
        points.put('i',1);
        points.put('o',1);
        points.put('n',1);
        points.put('r',1);
        points.put('t',1);
        points.put('l',1);
        points.put('s',1);
        points.put('u',1);
        points.put('d',2);
        points.put('g',2);
        points.put('b',3);
        points.put('c',3);
        points.put('m',3);
        points.put('p',3);
        points.put('f',4);
        points.put('h',4);
        points.put('v',4);
        points.put('w',4);
        points.put('y',4);
        points.put('k',5);
        points.put('j',8);
        points.put('x',8);
        points.put('q',10);
        points.put('z',10);
        return points;
    }
}