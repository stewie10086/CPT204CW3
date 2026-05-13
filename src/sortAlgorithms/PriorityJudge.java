package sortAlgorithms;

import entity.Candidate;

public class PriorityJudge {
    public static boolean IfComeAhead(Candidate a, Candidate b){
        if (a.getPriorityScore() != b.getPriorityScore()){
            return a.getPriorityScore() > b.getPriorityScore();
        }
        else return Integer.parseInt(a.getLocationId().substring(1)) < Integer.parseInt(b.getLocationId().substring(1));
    }
}
