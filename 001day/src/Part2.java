import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        Path path = Path.of("001day/reqs.txt");
        int curDial = 50; //starts out at 50
        int ret = 0;

        try {
            List<String> lines = Files.readAllLines(path);
            for(String line : lines){
                char direction = line.charAt(0);
                int curAmount = Integer.parseInt(line.substring(1));

                if(curAmount < 0){
                    if(direction == 'R'){
                        direction = 'L';
                    }
                    else{
                        direction = 'R';
                    }
                    curAmount *= -1;
                }

                if(direction == 'R'){   //turn right
                    if(curDial + curAmount > 99){
                        ret += (curDial + curAmount) / 100;
                    }
                    curDial = Math.floorMod(curDial + curAmount, 100);
                }





                else {                   //turn left
                    if (curDial - curAmount < 1){
                        ret += ((curDial - curAmount) / 100)*-1 + 1;
                        if(curDial == 0){
                            ret--;
                        }
                    }
                    curDial = Math.floorMod(curDial - curAmount, 100);

                }








            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ret);
    }
}

