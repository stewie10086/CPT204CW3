package algorithms;

import model.Candidate;

public class MergeSort {
    public static void mergeSort(Candidate[] arr, int left, int right){
        if (left < right){
            //find mid point
            int mid = left + (right - left) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, right, mid);
        }
    }

    public static void merge(Candidate[] arr, int left, int right, int mid){
        //calculate the storage of each array
        int n1 = mid - left + 1;
        int n2 = right - mid;

        Candidate[] Left = new Candidate[n1];
        Candidate[] Right = new Candidate[n2];

        for (int i = 0; i < n1; i++) {
            Left[i] = arr[left + i];
        }
        for (int j = 0; j < n2; j++) {
            Right[j] = arr[mid + 1 + j];
        }

        int i = 0;
        int j = 0;
        int k = left;
        // merge together by comparisons
        while (i < n1 && j < n2){
            if (PriorityJudge.IfComeAhead(Left[i],Right[j])){
                arr[k] = Left[i];
                i++;
            }else {arr[k] = Right[j];
                j++;
            }
            k++;
        }

        // copy the rest elements
        while (i < n1){
            arr[k] = Left[i];
            k++;
            i++;
        }
        while (j < n2){
            arr[k] = Right[j];
            k++;
            j++;
        }
    }
}
