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
        int N = in.nextInt();
        List<Job> jobs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int J = in.nextInt();
            int D = in.nextInt();
            jobs.add(new Job(J, D));
        }
        System.err.println(jobs.size() == N);
        Collections.sort(jobs);
        int currentDate = 0;
        int nbJobs = 0;
        
        for(Job job : jobs){
            if(job.dateDebut >= currentDate){
                nbJobs++;
                currentDate = job.dateDebut + job.duree;
            }
        }

        System.out.println(nbJobs);
    }
    
    private static class Job implements Comparable {
        private final int dateDebut;
        private final int duree;
        
        public Job(int dateDebut, int duree){
            this.dateDebut = dateDebut;
            this.duree = duree;
        }
        
        @Override
        public int compareTo(Object o){
            Job other = (Job) o;
            //return (this.dateDebut + this.duree) - (other.dateDebut + other.duree);
            
            int debutCompare = this.dateDebut - other.dateDebut;
            if(debutCompare == 0){
                return this.duree - other.duree;
            }
            return debutCompare;
        }
    }
}