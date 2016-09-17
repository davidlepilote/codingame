import java.util.*;
class Player {
    public static void main(String b[]) {
        Scanner i = new Scanner(System.in);
        int[] r = new int[8];
        int j = 0;
        while(j < 8)
            r[j++] = i.nextInt();
        int z = r[0];
        int[] e = new int[z--];
        e[z] = r[4];
        j = 0;
        while(j++ < z)
            e[i.nextInt()] = i.nextInt();
        for(;;) {
            int f = i.nextInt(), p = i.nextInt();
            String d = i.next();
            System.out.println(f != -1 && d.contains("L") && p < e[f]
                    || d.contains("R") && p > e[f] ? "BLOCK" : "WAIT");
        }
    }
}