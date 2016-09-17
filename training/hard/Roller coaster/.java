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
        int maxSize = in.nextInt();
        int maxTurns = in.nextInt();
        int nbGroups = in.nextInt();
        int[] groups = new int[nbGroups];
        for (int i = 0; i < nbGroups; i++) {
            groups[i] = in.nextInt();
        }
        long money = 0;
        int nbTurns = 0;
        int currentTrain = 0;
        int currentGroup = 0;
        while(true){
            for (int i = 0; i < groups.length; i++) {
                if((currentTrain += groups[i]) > maxSize || currentGroup == nbGroups){
                    currentGroup = 0;
                    money += (currentTrain - groups[i]);
                    currentTrain = 0;
                    nbTurns++;
                    if(nbTurns >= maxTurns){
                        System.out.println(money);
                        return;
                    }
                    i--;
                } else {
                    currentGroup++;
                }
            }
        }
    }
}