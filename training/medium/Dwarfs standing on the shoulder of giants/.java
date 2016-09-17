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
        long tic = System.currentTimeMillis();
        Map<Integer, Node> nodes = new HashMap<>();
        TreeSet<Node> nodeSet = new TreeSet<>();
        int n = in.nextInt(); // the number of adjacency relations
        for (int i = 0; i < n; i++) {
            int xi = in.nextInt(); // the ID of a person which is adjacent to yi
            int yi = in.nextInt(); // the ID of a person which is adjacent to xi
            if(!nodes.containsKey(xi)){
            	nodes.put(xi, new Node(xi));
            }
            if(!nodes.containsKey(yi)){
            	nodes.put(yi, new Node(yi));
            }
            nodes.get(xi).addNeighbor(nodes.get(yi));
        }
        nodeSet.addAll(nodes.values());
        long tac = System.currentTimeMillis();
//System.err.println(nodes.size() + " " + (tac - tic));
        int maxHours = Integer.MIN_VALUE;
        int i = 0;
        for(Node node : nodeSet){
            i++;
            long toc = System.currentTimeMillis();
            if(i%1000==0)
            System.err.println(i + " " + node.getNeighbors().size() + " " + (toc - tac));
        	int nbHours = spread(node, null, 0, 0, maxHours);
        	if(nbHours > maxHours){
        		maxHours = nbHours;
        	}
        }
        
        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        System.out.println(maxHours+1); // The minimal amount of steps required to completely propagate the advertisement
    }
    
    private static int spread(Node currentNode, Node previousNode, int nbHours, int maxHours, final int veryMax){
    	if(maxHours < nbHours){
    	    maxHours = nbHours;
    	}
    	for(Node neighbor : currentNode.getNeighbors()){
    		if(!neighbor.equals(previousNode)){
        		maxHours = spread(neighbor, currentNode, nbHours + 1, maxHours, veryMax);
    		}
    	}
    	return maxHours;
    }
    
    private static class Node implements Comparable<Node>{
    	private final int name;
    	private final Set<Node> neighbors = new HashSet<>();
    	
    	public Node(int name){
    		this.name = name;
    	}
    	
    	public void addNeighbor(Node neighbor){
    		neighbors.add(neighbor);
    	}
    	
    	public Set<Node> getNeighbors(){
    		return neighbors;
    	}

		@Override
		public boolean equals(Object obj) {
			if(obj == null){
				return false;
			}
			return this.name == ((Node) obj).name;
		}

		@Override
		public int compareTo(Node o) {
			if(this.neighbors.size() < o.neighbors.size()){
				return 1;
			} else if(this.neighbors.size() > o.neighbors.size()){
				return -1;
			} else {
				if(this.name < o.name){
					return 1;
				} else if(this.name > o.name){
					return -1;
				} else {
					return 0;
				}
			}
		}
    	
    	
    }
}