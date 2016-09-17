import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        LinkedList<Integer> player1 = new LinkedList<>();
        LinkedList<Integer> player2 = new LinkedList<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // the number of cards for player 1
        for (int i = 0; i < n; i++) {
            player1.addLast(getCardValue(in.next())); // the n cards of player 1
        }
        int m = in.nextInt(); // the number of cards for player 2
        for (int i = 0; i < m; i++) {
        	player2.addLast(getCardValue(in.next())); // the m cards of player 2
        }
        
        int nbTurns = 0;
        boolean bataille = false;
        LinkedList<Integer> deck1 = new LinkedList<>();
        LinkedList<Integer> deck2 = new LinkedList<>();
        while(player1.size() > 0 && player2.size() > 0){
        	if(!bataille){
                deck1 = new LinkedList<>();
                deck2 = new LinkedList<>();
        	}
        	deck1.addLast(player1.removeFirst());
        	deck2.addLast(player2.removeFirst());
        	if(deck1.getLast() > deck2.getLast()){
        		player1.addAll(deck1);
        		player1.addAll(deck2);
        		bataille = false;
            	nbTurns++;
        	} else if(deck2.getLast() > deck1.getLast()){
        		player2.addAll(deck1);
        		player2.addAll(deck2);
        		bataille = false;
            	nbTurns++;
        	} else {
        		bataille = true;
        		if(player1.size() < 3 || player2.size() < 3){
        			player1.clear();
        			player2.clear();
        			continue;
        		}
        		deck1.addLast(player1.removeFirst());
        		deck1.addLast(player1.removeFirst());
        		deck1.addLast(player1.removeFirst());
        		deck2.addLast(player2.removeFirst());
        		deck2.addLast(player2.removeFirst());
        		deck2.addLast(player2.removeFirst());
        	}
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        if(player1.size() == 0 && player2.size() == 0){
            System.out.println("PAT");
        } else if(player1.size() == 0){
        	System.out.println("2 " + nbTurns);
        } else if(player2.size() == 0){
        	System.out.println("1 " + nbTurns);
        }
    }
    
    public static int getCardValue(String card){
        int value = 0;
        String cardSimple = card.substring(0, card.length() - 1);
        if(cardSimple.equals("J")){
            value = 11;
        } else if(cardSimple.equals("Q")){
        	value = 12;
        } else if(cardSimple.equals("K")){
        	value = 13;
        } else if(cardSimple.equals("A")){
        	value = 14;
        } else {
        	value = Integer.valueOf(cardSimple);
        }
        return value;
    }
}