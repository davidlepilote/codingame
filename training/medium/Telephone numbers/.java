import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
    	Tree root = new Tree('a');
    	int number = 0;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i = 0; i < N; i++) {
        	number += addNumber(root, in.next(), 0);
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(number); // The number of elements (referencing a number) stored in the structure.
    }
    
    public static int addNumber(Tree tree, String number, int nbAdds){
    	if(number.length() == 0){
    		return nbAdds;
    	}
    	char firstDigit = number.charAt(0);
    	Tree childTree = tree.children.get(firstDigit);
    	if(childTree == null){
    		nbAdds++;
    		childTree = new Tree(firstDigit);
    		tree.children.put(firstDigit, childTree);
    	}
		return addNumber(childTree, number.substring(1, number.length()), nbAdds);
    }
    
    private static class Tree{
    	private final char head;
    	private final Map<Character, Tree> children = new HashMap<>();
    	
    	public Tree(char head){
    		this.head = head;
    	}
    	
    	
    	
    }
}