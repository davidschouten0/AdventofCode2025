import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part1 {
    public static void main(String[] args) {
        String content;
        try {
            Path path = Path.of("002day/reqs.txt");
            content = Files.readString(path);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        long ret = 0;

        String[] IDs = content.split(",");

        for(int i = 0; i < IDs.length; i++){
            String[] curID = IDs[i].split("-");
            long leftID = Long.parseLong(curID[0]);
            long rightID = Long.parseLong(curID[1]);

            for(long j = leftID; j <= rightID; j++){
                ret += sequenceRepetition(j);
            }
        }

        System.out.println(ret);
    }

    public static long sequenceRepetition(long num){
        String numS = String.valueOf(num);

        if(numS.length() % 2 != 0){
            return 0;
        }
        else{
            int half = numS.length() / 2;

            long lowerHalf = Long.parseLong(numS.substring(0, half));
            long upperHalf = Long.parseLong(numS.substring(half));

            if(lowerHalf == upperHalf){
                return num;
            }
            else{
                return 0;
            }
        }
    }
}