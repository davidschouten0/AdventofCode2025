import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1{
    public static void main(String[] args) {
        long ret = 0;
        Path path = Path.of("004day/reqs.txt");
        try {
            List<String> lines = Files.readAllLines(path);
            ret = calculateForkLiftableRows(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
    }

    private static int calculateForkLiftableRows(List<String> lines){
        char[][] grid = linkedListToArray(lines);
        int ret = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '@' && surroundingPaperrolls(grid, i, j) < 4){
                    ret++;
                }
            }
        }

        return ret;
    }

    private static char[][] linkedListToArray(List<String> lines){
        int x = lines.get(0).length();
        int y = lines.size();

        char[][] ret = new char[y][x];

        int j = 0;
        for(String line: lines){
            for(int i = 0; i < x; i++){
                ret[j][i] = line.charAt(i);
                System.out.print(ret[j][i]);
            }
            j++;
            System.out.println();
        }

        return ret;
    }

    private static int surroundingPaperrolls(char[][] grid, int i, int j){
        int paperRollCounter = 0;
        for(int k = -1; k <= 1; k++){
            for(int l = -1; l <= 1; l++){
                if(!((l == 0 ) && (k == 0)) && i+k >= 0 && i+k < grid.length && j+l >= 0 && j+l < grid[0].length && grid[i + k][j + l] == '@'){
                    paperRollCounter++;
                }
            }
        }
        return paperRollCounter;
    }
}