import model.Candidate;
import model.Path;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class DataLoader {
    public static List<Candidate> loadCandidates(String filePath) throws IOException{
        List<Candidate> candidates = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] values = line.split(",");
                String id = values[0].trim();
                int score = Integer.parseInt(values[1].trim());
                candidates.add(new Candidate(id, score));
            }

        } catch (NumberFormatException e) {
            System.err.println("warning: candidate data choose error" + e);
        }

        return candidates;
    }

    public static List<Path> loadPaths(String filePath) throws IOException{
        List<Path> paths = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){
            String line;
            reader.readLine();

            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] values = line.split(",");
                paths.add(new Path(values[0].trim(), values[1].trim(), Integer.parseInt(values[2].trim())));
            }


        }catch (NumberFormatException e) {
            System.err.println("warning: path choose error" + e);
        }

        return paths;
    }

    public static void main(String[] args) throws IOException {
        DataLoader loader = new DataLoader();

        // 示例用法
        List<Candidate> candidates = loader.loadCandidates("dataset/candidates_A.csv");
        List<Path> paths = loader.loadPaths("dataset/paths.csv");

        System.out.println("成功加载 " + candidates.size() + " 个候选位置");
        System.out.println("成功加载 " + paths.size() + " 条路径");

        // 打印第一行数据验证
        if(!candidates.isEmpty()) System.out.println("示例: " + candidates.get(0));
    }
}
