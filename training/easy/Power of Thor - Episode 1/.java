import java.util.*;

class Player {


    public static void main(String d[]) {
        Scanner f = new Scanner(System.in);
        int e = f.nextInt(), g = f.nextInt(), c = f.nextInt(), b = f.nextInt();
        String o = g > b ? "S" : "N", p = e > c ? "E" : "W";
        g = Math.abs(g - b);
        e = Math.abs(e - c);

        while (true) {
            String a = "";
            if(g-- > 0) {
                a += o;
            }
            if(e-- > 0) {
                a += p;
            }
            System.out.println(a);
        }
    }
}