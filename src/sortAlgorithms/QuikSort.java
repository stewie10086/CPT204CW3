package sortAlgorithms;

import entity.Candidate;

import java.util.List;

public class QuikSort {
    public static void sort(List<Candidate> list, int low, int high){
        if (low < high){
            int pivot = partition(list, low, high);


            //recursively sorting the left and right sides of the pivot
            sort(list, low, pivot - 1);
            sort(list, pivot + 1, high);
        }

    }
    public static int partition(List<Candidate> list, int low, int high){
        Candidate pivot = list.get(high);
        // out of the region
        int i = low - 1;

        for (int j = low; j < high; j++){
            if (PriorityJudge.IfComeAhead(list.get(j), pivot)){
                i++;

                Candidate temp = list.get(i);
                list.set(i, list.get(j));
                list.set(j, temp);
            }
        }
        // after loop, all high priority at the left of i while low priority at the right
        // switch pivot to the i+1 position
        Candidate temp = list.get(i + 1);
        list.set(i + 1, pivot);
        list.set(high, temp);

        return i+1;
    }

}
