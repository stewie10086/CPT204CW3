package algorithms;

import model.Candidate;

import java.util.List;

public class BubbleSort {
    public static void bubbleSort(List<Candidate> list){
        int n = list.size();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (PriorityJudge.IfComeAhead(list.get(j + 1), list.get(j))){
                    Candidate temp = list.get(j);
                    list.set(j , list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }


    }




}
