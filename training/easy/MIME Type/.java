import java.util.*;
import java.io.*;
import java.math.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {

        Map<String, String> mapping = new HashMap<>();
        List<String> extensions = new ArrayList<>();

        Scanner in = new Scanner(System.in);
        int n = in.nextInt(); // Number of elements which make up the association table.
        in.nextLine();
        int q = in.nextInt(); // Number Q of file names to be analyzed.

        in.nextLine();
        for (int i = 0; i < n; i++) {
            String eXT = in.next(); // file extension
            String mT = in.next(); // MIME type.
            mapping.put(eXT.toUpperCase(), mT);
            in.nextLine();
        }
        for (int i = 0; i < q; i++) {
            String fNAME = in.nextLine(); 
            String[] split = fNAME.split("\\.");
            if(split.length < 2 || fNAME.charAt(fNAME.length()-1) == '.'){
                extensions.add("caca");
            } else {
                extensions.add(split[split.length - 1].toUpperCase());
            }
        }
        
        StringBuilder builder = new StringBuilder();
        for (String extension : extensions) {
            if(mapping.containsKey(extension)){
                builder.append(mapping.get(extension));
            } else {
                builder.append("UNKNOWN");
            }
            builder.append("\n");
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(builder.toString()); // For each of the Q filenames, display on a line the corresponding MIME type. If there is no corresponding type, then display UNKNOWN.
    }
}