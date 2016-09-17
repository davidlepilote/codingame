import java.util.*;
import java.io.*;
import java.math.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        List<String> times = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            times.add(in.next());
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        System.out.println(times.stream().map(time -> LocalTime.parse(time, formatter)).sorted().findFirst().get().format(formatter));
    }
}