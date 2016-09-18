import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Solution {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int M = in.nextInt();

        Map<String, Voter> voters = new HashMap<>();
        for (int i = 0; i < N; i++) {
            String personName = in.next();
            int nbVote = in.nextInt();
            voters.put(personName, new Voter(personName, nbVote));
        }
        for (int i = 0; i < M; i++) {
            String voterName = in.next();
            String voteValue = in.next();
            if(voters.containsKey(voterName)){
                Voter voter = voters.get(voterName);
                if(voteValue.equals("Yes")){
                    voter.yes();
                } else if(voteValue.equals("No")){
                    voter.no();
                }
                voter.vote();
            }
        }

        int nbYes = 0;
        int nbNo = 0;

        for (Voter voter : voters.values()) {
            if(voter.isOk()){
                nbYes += voter.getYes();
                nbNo += voter.getNo();
            }
        }

        // Write an action using System.out.println()
        // To debug: System.err.println("Debug messages...");

        System.out.println(nbYes + " " + nbNo);
    }

    public static class Voter{
        public final String name;

        public final int nbVotes;

        private int yes = 0;

        private int no = 0;
        
        private int countVote;

        public Voter(String name, int nbVotes) {
            this.name = name;
            this.nbVotes = nbVotes;
        }

        public boolean isOk(){
            return countVote <= nbVotes;
        }

        public int getYes(){
            return yes;
        }

        public int getNo(){
            return no;
        }

        public void yes(){
            yes++;
        }

        public void no(){
            no++;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Voter voter = (Voter) o;

            return name != null ? name.equals(voter.name) : voter.name == null;

        }

        @Override
        public int hashCode() {
            return name != null ? name.hashCode() : 0;
        }

        public void vote() {
            countVote++;
        }
    }
}