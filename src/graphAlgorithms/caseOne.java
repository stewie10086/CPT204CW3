package graphAlgorithms;


import entity.DijkstraResult;
import entity.Path;
import utils.CsvReader;
import utils.formatRoute;

import java.util.List;

//Case 1: from the 1st selected location in Dataset A to itself.
public class caseOne {
    public static void main(String[] args) {
        List<Path> paths = CsvReader.readPath("dataset\\paths.csv");
        DijkstraResult r = DijkstraAlgorithm.dijkstra(paths, "L0001", "L0001");
        String formattedPath = formatRoute.FormatRoute(r.pathEdges, "L0001");
        System.out.println("Total distance: " + r.totalDistance + " route: " + formattedPath);
    }

//    public static List<Path> getMyPath(){
//        List<Path> pathList = CsvReader.readPath("dataset\\paths.csv");
//        List<Path> myPath = new ArrayList<>();
//        String from, to;
//        for (Path path : pathList){
//            from = path.getFromLocationName();
//            to = path.getToLocationName();
//            if ((from.startsWith("L") && Integer.parseInt(from.substring(1)) >= 1 && Integer.parseInt(from.substring(1)) <= 10)
//                    &&
//                    (to.startsWith("L") && Integer.parseInt(to.substring(1)) >= 1 && Integer.parseInt(to.substring(1)) <= 10))
//            {
//                myPath.add(path);
//            }
//        }
//        return myPath;
//    }
}
