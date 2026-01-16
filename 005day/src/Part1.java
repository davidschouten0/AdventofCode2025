import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part1 {
    public static void main(String[] args) {
        Path path = Path.of("005day/reqs.txt");
        int ret = 0;

        try {
            List<String> lines = Files.readAllLines(path);
            ret = solver(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(ret);
    }

    public static int solver(List<String> input){
        ArrayList<Node1> list = new ArrayList<>();
        int count = 0;

        for(String curString: input){
            if(curString.matches("\\d+-\\d+")){
                list.add(new Node1(curString.split("-")[0], curString.split("-")[1]));
            }
            else{
                for(Node1 curNode: list){
                    if(curNode.isInRange(curString)){
                        count++;
                        break;
                    }
                }
            }
        }

        return count;
    }
}

class Node1 {
    BigInteger from;
    BigInteger till;

    Node1(String from, String till){
        this.from = new BigInteger(from);
        this.till = new BigInteger(till);
    }

    boolean isInRange(String ID){
        BigInteger id = new BigInteger(ID);
        if(id.compareTo(from) >= 0 &&  id.compareTo(till) <= 0){
            return true;
        }
        return false;
    }
}