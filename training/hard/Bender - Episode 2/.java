import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    static Value maxValue = new Value();
    static Map<String, Node> nodeMap = new HashMap<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);



        int N = in.nextInt();
        in.nextLine();
        for (int i = 0; i < N; i++) {
            String room = in.nextLine();
            String[] split = room.split(" ");
            int money = Integer.parseInt(split[1]);
            String nodeId = split[0];
            Node node;
            if(!nodeMap.containsKey(nodeId)){
                node = new Node(money, nodeId);
                nodeMap.put(nodeId, node);
            } else {
                node = nodeMap.get(nodeId);
                node.value = money;
            }
            String neighbor1 = split[2];
            String neighbor2 = split[3];
            if(!nodeMap.containsKey(neighbor1)){
                nodeMap.put(neighbor1, new Node(neighbor1));
            }
            if(!nodeMap.containsKey(neighbor2)){
                nodeMap.put(neighbor2, new Node(neighbor2));
            }
            node.left = nodeMap.get(neighbor1);
            node.right = nodeMap.get(neighbor2);
        }

        Node firstNode = nodeMap.get("0");

//        int value = firstNode.getValue();
//        realExplore(firstNode, value);


        firstNode.print();
        System.err.println(calculateSum(firstNode));
        //return max[0];

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(maxValue.getValue());
        //System.out.println(maxValue.getValue());
    }

    private static void realExplore(Node root, int value){
        if(!root.id.equals("E") || root.maxSum != -1){
            realExplore(root.left, value + root.left.value);
            realExplore(root.right, value + root.right.value);
        } else {
            if(maxValue.getValue() < value){
                maxValue.setValue(value);
            }
        }
    }

    private static int calculateSum(Node root) {
        if (root.id.equals("E")){
            return 0;
        }
        if(root.maxSum == -1){
            int left = calculateSum(root.left);
            int right = calculateSum(root.right);
            System.err.println(root.maxSum);
            root.maxSum = root.value + Math.max(left, right);
        }
        maxValue.setValue(Math.max(maxValue.getValue(), root.maxSum));
        return root.maxSum;
    }

    private static class Value{
        private int value = 0;

        public int getValue(){
            return value;
        }

        public void setValue(int value){
            this.value = value;
        }

        public void addValue(int value){
            this.value += value;
        }
    }

    private static class Node {
        Node left;
        Node right;
        int value = 0;
        int maxSum = -1 ;
        final String id;
        
        public Node(String id){
            this.id = id;
        }

        public Node(int value, String id){
            this.value = value;
            this.id = id;
        }
        
        public void print(){
            System.err.println(id + " " + value + " " + left.id + " " + right.id);
        }
    }
}