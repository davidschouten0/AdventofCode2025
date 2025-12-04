import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Part2 {
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

        for(int i = 2; i <= numS.length(); i++){
            if(numS.length()%i == 0){
                if(sequenceHelper(num, i)){
                    return num;
                }
            }
        }

        return 0;
    }

    public static boolean  sequenceHelper(long num, int parts){
        String numS = String.valueOf(num);

        boolean flag = true;

        int sizeOfPartition = numS.length()/parts;
        long firstPart = Long.parseLong(numS.substring(0, sizeOfPartition));

        for(int i = sizeOfPartition; i < numS.length(); i += sizeOfPartition){
            if(firstPart == Long.parseLong(numS.substring(i, i + sizeOfPartition))){

            }
            else{
                flag = false;
                break;
            }
        }

        return flag;
    }
}