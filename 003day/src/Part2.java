import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        Path path = Path.of("003day/reqs.txt");
        BigInteger ret = BigInteger.valueOf(0);
        try {
            List<String> lines = Files.readAllLines(path);
            ret = helper(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
    }

    public static BigInteger helper(List<String> lines){
        BigInteger ret = BigInteger.valueOf(0);

        for(String line: lines){
            BigInteger curNum = BigInteger.valueOf(0);

            int firstNum = 0;
            int indexFirstNum = 0;
            for(int i = 0; i <= line.length() - 12; i++){
                if(firstNum < line.charAt(i) - 48){
                    firstNum = line.charAt(i) - 48;
                    indexFirstNum = i;
                }
            }
            curNum = curNum.add(BigInteger.valueOf(firstNum * (long) Math.pow(10, 11)));


            for(int j = 1; j <= 11; j++){
                int cur = helperHelper(line, indexFirstNum+1, line.length() - (12 - j))[0];
                indexFirstNum = helperHelper(line, indexFirstNum+1, line.length() - (12 - j))[1];

                curNum = curNum.add(BigInteger.valueOf(cur * (long) Math.pow(10, 11 - j)));
            }


            ret = ret.add(curNum);
        }

        return ret;
    }

    public static int[] helperHelper(String line, int from, int till){
        int num = -1;
        int index = 0;
        for(int i = from; i <= till; i++){
            if(num < line.charAt(i) - 48){
                num = line.charAt(i) - 48;
                index = i;
            }
        }
        return new int[]{num, index};
    }
}