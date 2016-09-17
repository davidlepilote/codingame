import java.util.*;
import java.io.*;
import java.math.*;
import java.util.regex.Matcher;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static final int o1 = 0;
    public static final int ologn = 1;
    public static final int on = 2;
    public static final int onlogn = 3;
    public static final int on2 = 4;
    public static final int on2logn = 5;
    public static final int on3 = 6;
    public static final int o2n = 7;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();

        int[] nums = new int[N];
        int[] ts = new int[N];
        double[][] os = new double[8][N];
        double[] osMeans = new double[8];
        for (int i = 0; i < N; i++) {
            nums[i] = in.nextInt();
            ts[i] = in.nextInt();
        }
        for(int i = 0 ; i != 8; i++){
            for(int j = 0; j != N; j++){
                double ratio = 0.;
                switch (i){
                    case o1:
                        ratio = 1.;
                        break;
                    case ologn:
                        ratio = Math.log(nums[j]);
                        break;
                    case on:
                        ratio = nums[j];
                        break;
                    case onlogn:
                        ratio = (Math.log(nums[j]) * nums[j]);
                        break;
                    case on2:
                        ratio = Math.pow(nums[j], 2);
                        break;
                    case on2logn:
                        ratio = (Math.pow(nums[j], 2) * (Math.log(nums[j])));
                        break;
                    case on3:
                        ratio = Math.pow(nums[j], 3);
                        break;
                    case o2n:
                        ratio = Math.pow(2, nums[j]);
                        break;
                }
                os[i][j] = ratio;
            }
        }

        int mostProbable = -1;
        double bestCorrelation = -1.;
        for(int i = 0; i != 8; i++){
            double currentCorrelation = computeCorrelation(ts, os[i]);
            System.err.println(currentCorrelation);
            if(currentCorrelation > bestCorrelation || (currentCorrelation > 1. && i == 1)){
                bestCorrelation = currentCorrelation;
                mostProbable = i;
            }
        }

        String answer = "";
        switch (mostProbable){
            case o1:
                answer = "O(1)";
                break;
            case ologn:
                answer = "O(log n)";
                break;
            case on:
                answer = "O(n)";
                break;
            case onlogn:
                answer = "O(n log n)";
                break;
            case on2:
                answer = "O(n^2)";
                break;
            case on2logn:
                answer = "O(n^2 log n)";
                break;
            case on3:
                answer = "O(n^3)";
                break;
            case o2n:
                answer = "O(2^n)";
                break;
        }

        System.out.println(answer);
    }
    
    public static double computeCorrelation(int[] array, double[] o){
        double meanArray = computeMean(array);
        double meanO = computeMean(o);
        if(meanO == 1.){
            double numerator = 100000.;
            for(int i = 0; i != array.length; i++){
                numerator += (array[i] - meanArray);
            }
            double denominator = 0.;
            for(int i = 0; i != array.length; i++){
                denominator += Math.pow(array[i] - meanArray, 2);
            }
            denominator = Math.sqrt(denominator);
            System.err.println(numerator + ", " + denominator + ", " + numerator / denominator);
            return numerator / denominator;
        }
        //System.err.println(meanO);
        double numerator = 0.;
        for(int i = 0; i != array.length; i++){
            numerator += ((array[i] - meanArray) * (o[i] - meanO));
        }
        double leftSide = 0.;
        double rightSide = 0.;
        for(int i = 0; i != array.length; i++){
            leftSide += Math.pow(array[i] - meanArray, 2);
            rightSide += Math.pow(o[i] - meanO, 2);
        }
        double denominator = Math.sqrt(leftSide * rightSide);
                //System.err.println(numerator + ", " + denominator + ", " + numerator / denominator);
        if(denominator == 0){
            return numerator;
        } else {
            return numerator / denominator;
        }
    }
    
    public static double computeMean(int[] array){
        int sum = 0;
        for(int i = 0; i != array.length; i++){
            sum += array[i];
        }
        return (double) sum / array.length;
    }
    
    public static double computeMean(double[] array){
        double sum = 0;
        for(int i = 0; i != array.length; i++){
            sum += array[i];
        }
        return sum / array.length;
    }
}