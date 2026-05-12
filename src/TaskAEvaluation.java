import algorithms.BubbleSort;
import algorithms.MergeSort;
import algorithms.QuikSort;
import model.Candidate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TaskAEvaluation {
    static List<Candidate> TopLocations = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        String[] datasets = {
                "dataset/candidates_A.csv",
                "dataset/candidates_B.csv",
                "dataset/candidates_C.csv"
        };

        System.out.println("================= Sorting Performance Summary =================");
        System.out.printf("%-15s | %-15s | %-15s | %-15s%n", "Dataset", "BubbleSort(ms)", "MergeSort(ms)", "QuickSort(ms)");
        System.out.println("---------------------------------------------------------------");

        for (String file : datasets) {
            processDataset(file);
        }
        System.out.println("===============================================================\n");


        System.out.println("============== Top 30 Inspection Targets ==============");
        for (int i = 0; i < TopLocations.size(); i++) {

            System.out.printf("%2d. %s%n", (i + 1), TopLocations.get(i).toString());
        }

    }
    public static void processDataset(String filename) throws IOException {
        List<Candidate> originalData = DataLoader.loadCandidates(filename);
        List<Candidate> dataForBubble = new ArrayList<>(originalData);
        List<Candidate> dataForMerge = new ArrayList<>(originalData);
        List<Candidate> dataForQuick = new ArrayList<>(originalData);
        double bubbleTime = measureTime(dataForBubble, "Bubble");
        double mergeTime = measureTime(dataForMerge, "Merge");
        double quickTime = measureTime(dataForQuick, "Quick");
        String datasetName = filename.substring(filename.lastIndexOf("/") + 1);
        System.out.printf("%-15s | %-15.4f | %-15.4f | %-15.4f%n",
                datasetName, bubbleTime, mergeTime, quickTime);

        List<Candidate> finalData = new ArrayList<>(originalData);

        QuikSort.sort(finalData, 0, finalData.size() - 1);

        for (int i = 0; i < 10 && i < finalData.size(); i++) {
            TopLocations.add(finalData.get(i));
        }

    }
    private static double measureTime(List<Candidate> originalData, String algoType) {
        // run 3 times to take average
        int runTimes = 3;
        long totalNanoTime = 0;

        for (int i = 0; i < runTimes; i++) {

            List<Candidate> testData = new ArrayList<>(originalData);

            long startTime = System.nanoTime();


            if (algoType.equals("Bubble")) {
                BubbleSort.bubbleSort(testData);
            } else if (algoType.equals("Merge")) {
                Candidate[] arr = testData.toArray(new Candidate[0]);
                MergeSort.mergeSort(arr, 0, arr.length - 1);
            } else if (algoType.equals("Quick")) {
                QuikSort.sort(testData, 1, testData.size() - 1);
            }

            long endTime = System.nanoTime();
            totalNanoTime += (endTime - startTime);
        }

        // calculate the average time, turn ns to ms
        double averageNano = (double) totalNanoTime / runTimes;
        return averageNano / 1_000_000.0;
    }
}
