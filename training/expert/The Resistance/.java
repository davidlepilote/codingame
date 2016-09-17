import java.util.*;
import java.io.*;
import java.math.*;

class Solution {
    
    static Map<Character, String> letters = new HashMap<>();
    static int maxLength = 0;
    static Map<Integer, Long> nbSequences = new HashMap<>();
    static String code;
    static String[] words;
    
    public static int contains(String[] a, String b) {
        if (a.length == 0) {
          return 0;
        }
        int low = 0;
        int high = a.length-1;
    
        while(low <= high) {
          int middle = (low+high) /2; 
          if (b.compareTo(a[middle]) > 0){
            low = middle +1;
          } else if (b.compareTo(a[middle]) < 0){
            high = middle -1;
          } else { // The element has been found
            return 1 + countRight(a, middle) + countLeft(a, middle); 
          }
        }
        return 0;
    }
    
    public static int countRight(String[] words, int index){
        return count(words, index, true);
    }
    
    public static int countLeft(String[] words, int index){
        return count(words, index, false);
    }
    
    public static int count(String[] words, int index, boolean toRight){
        int nbSame = 0;
        int i = 1;
        while(toRight ? index + i < words.length && words[index + i++].equals(words[index])
                      : index - i >= 0 && words[index - i++].equals(words[index])){
            nbSame++;
        }
        return nbSame;
    }

    public static void main(String args[]) {
        long tic = System.currentTimeMillis();
        Scanner in = new Scanner(System.in);

        makeMap();
        code = in.next();

        int N = in.nextInt();
        words = new String[N];
        for (int i = 0; i < N; i++) {
            String W = in.next();
            StringBuilder builder = new StringBuilder();
            for(char letter : W.toCharArray()){
                builder.append(letters.get(letter));
            }
            if(builder.length() > maxLength){
                maxLength = builder.length();
            }
            words[i] = builder.toString();
        }
        Arrays.sort(words);
        long answer = getWords(0);
                System.err.println(System.currentTimeMillis() - tic);
        System.out.println(answer);

    }
    
    public static long getWords(int index){
        if(!nbSequences.containsKey(index)){
            Map<Integer, Integer> newWords = new HashMap<>();
            for(int i = 1; i <= maxLength && index + i <= code.length(); i++){
                String word = code.substring(index, index + i);
                int nbWords = contains(words, word);
                if(nbWords != 0){
                    newWords.put(index + i, nbWords);
                }
            }
            long nbWords = 0;
            for(int newIndex : newWords.keySet()){
                if(newIndex == code.length()){
                    nbWords += newWords.get(newIndex);
                } else {
                    nbWords += newWords.get(newIndex) * getWords(newIndex);
                }
            }
            nbSequences.put(index, nbWords);
        }
        return nbSequences.get(index);
    }
    
    public static void makeMap(){
        letters.put('A',".-");
        letters.put('B',"-...");
        letters.put('C',"-.-.");
        letters.put('D',"-..");
        letters.put('E',".");
        letters.put('F',"..-.");
        letters.put('G',"--.");
        letters.put('H',"....");
        letters.put('I',"..");
        letters.put('J',".---");
        letters.put('K',"-.-");
        letters.put('L',".-..");
        letters.put('M',"--");
        letters.put('N',"-.");
        letters.put('O',"---");
        letters.put('P',".--.");
        letters.put('Q',"--.-");
        letters.put('R',".-.");
        letters.put('S',"...");
        letters.put('T',"-");
        letters.put('U',"..-");
        letters.put('V',"...-");
        letters.put('W',".--");
        letters.put('X',"-..-");
        letters.put('Y',"-.--");
        letters.put('Z',"--..");
    }
}