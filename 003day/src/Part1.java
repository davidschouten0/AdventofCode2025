import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        Path path = Path.of("003day/reqs.txt");
        int ret = 0;
        try {
            List<String> lines = Files.readAllLines(path);
            ret = helper(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
    }

    public static int helper(List<String> lines){
        int ret = 0;
        for(String line: lines){
            int firstNum = 0;
            int indexFirstNum = 0;

            int secondNum = 0;
            for(int i = 0; i < line.length() - 1; i++){
                if(firstNum < line.charAt(i) - 48){
                    firstNum = line.charAt(i) - 48;
                    indexFirstNum = i;
                }
            }
            for(int i = 0; i < line.length(); i++){
                if(secondNum < line.charAt(i) - 48 && indexFirstNum < i){
                    secondNum = line.charAt(i) - 48;
                }
            }
            ret += 10*firstNum + secondNum;
        }
        return ret;
    }
}