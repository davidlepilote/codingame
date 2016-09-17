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
            nodes.get(yi).addNeighbor(nodes.get(xi));
        }
        nodeSet.addAll(nodes.values());
        long tac = System.currentTimeMillis();
        int maxHours = Integer.MAX_VALUE;
        int i = 0;
        Node firstNode = nodeSet.iterator().next();
        Result result = spread(firstNode, null, 0, new Result(0, null));
        result = spread(result.node, null, 0, new Result(0, null));
        System.out.println((int) Math.ceil(result.nbHours / 2.));
        return;

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");
        //System.out.println(maxHours); // The minimal amount of steps required to completely propagate the advertisement
    }

    private static Result spread(Node currentNode, Node previousNode, int nbHours, Result result){
        if(result.nbHours < nbHours){
            result = new Result(nbHours, currentNode);
        }
        for(Node neighbor : currentNode.getNeighbors()){
            if(!neighbor.equals(previousNode)){
                result = spread(neighbor, currentNode, nbHours + 1, result);
            }
        }
        return result;
    }

    private static class Result{
        private final int nbHours;
        private final Node node;

        public Result(int nbHours, Node node){
            this.nbHours = nbHours;
            this.node = node;
        }
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
            if(this.neighbors.size() > o.neighbors.size()){
                return 1;
            } else if(this.neighbors.size() < o.neighbors.size()){
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