import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        Path path = Path.of("001day/reqs.txt");
        int numberOnTheDial = 50; //starts out at 50
        int ret = 0;

        try {
            List<String> lines = Files.readAllLines(path);

            for(String line : lines){
                char direction = line.charAt(0);
                int curAmount = Integer.parseInt(line.substring(1));

                if(direction == 'R'){   //turn right
                    numberOnTheDial = Math.floorMod(numberOnTheDial + curAmount, 100);
                }
                else{                   //turn left
                    numberOnTheDial = Math.floorMod(numberOnTheDial - curAmount, 100);
                }

                if(numberOnTheDial == 0){
                    ret++;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
    }
}