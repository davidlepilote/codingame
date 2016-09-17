import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {

        Map<Integer, Node> nodes = new HashMap<>();
        List<Integer> getaways = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int N = in.nextInt(); // the total number of nodes in the level, including the gateways
        int L = in.nextInt(); // the number of links
        int E = in.nextInt(); // the number of exit gateways
        for (int i = 0; i < L; i++) {
            int N1 = in.nextInt(); // N1 and N2 defines a link between these nodes
            int N2 = in.nextInt();
            if(nodes.containsKey(N1)){
                nodes.get(N1).addNode(N2);
            } else {
                Node node = new Node(N1, nodes);
                node.addNode(N2);
                nodes.put(N1, node);
            }
            if(nodes.containsKey(N2)){
                nodes.get(N2).addNode(N1);
            } else {
                Node node = new Node(N2, nodes);
                node.addNode(N1);
                nodes.put(N2, node);
            }
        }
        for (int i = 0; i < E; i++) {
            int EI = in.nextInt(); // the index of a gateway node
            getaways.add(EI);
        }

        // game loop
        while (true) {
            int SI = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn
            StringBuilder cutter = new StringBuilder();
            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");
            for (Integer getaway : getaways) {
                if(nodes.get(getaway).isLinked(SI)){
                    nodes.get(getaway).removeNode(SI);
                    nodes.get(SI).removeNode(getaway);
                    cutter.append(getaway)
                            .append(" ")
                            .append(SI);
                    break;
                }
            }
            if(cutter.length() == 0){
                int otherNode = nodes.get(SI).getNodeWithMostLinks();
                nodes.get(otherNode).removeNode(SI);
                cutter.append(SI)
                        .append(" ")
                        .append(otherNode);
            }

            System.out.println(cutter.toString()); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }

    private static class Node{
        final int nodeNumber;
        final Map<Integer, Node> nodes;
        final Set<Integer> links = new HashSet<>();

        public Node(int nodeNumber, Map<Integer, Node> nodes){
            this.nodeNumber = nodeNumber;
            this.nodes = nodes;
        }

        public int removeFirstNode(){
            Integer firstNode = links.iterator().next();
            links.remove(firstNode);
            return firstNode;
        }
        
        public int getNodeWithMostLinks(){
            int nbOfLinks = 0;
            int bestNode = -1;
            for (Integer link : links) {
                int currentLinks = nodes.get(link).getNumberOfLinks();
                if(currentLinks > nbOfLinks){
                    nbOfLinks = currentLinks;
                    bestNode = link;
                }
            }
            return bestNode;
        }

        public void addNode(int node){
            links.add(node);
        }
        
        public int getNumberOfLinks(){
            return links.size();
        }

        public boolean isLinked(int node){
            return links.contains(node);
        }

        public void removeNode(int node){
            links.remove(node);
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            if (nodeNumber != node.nodeNumber) return false;

            return true;
        }

        @Override
        public int hashCode() {
            return nodeNumber;
        }
    }
}