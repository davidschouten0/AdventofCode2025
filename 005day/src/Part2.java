import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class Part2 {
    public static void main(String[] args) {
        Path path = Path.of("005day/reqs.txt");
        long ret = 0;

        try {
            List<String> lines = Files.readAllLines(path);
            ret = solver(lines);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(ret);
    }

    public static long solver(List<String> input){
        ArrayList<Node2> list = new ArrayList<>();
        long count = 0;

        for(String curString: input){
            if(curString.matches("\\d+-\\d+")){
                long lowerBound = Long.parseLong(curString.split("-")[0]);
                long upperBound = Long.parseLong(curString.split("-")[1]);

                list.add(new Node2(lowerBound, upperBound));
            }
            else{
                break;
            }
        }

        list.sort((a, b) -> Long.compareUnsigned(a.from, b.from));

        for(int i = 0; i < list.size() - 1; i++){
            Node2 curLeftNode = list.get(i);
            Node2 curRightNode = list.get(i+1);

            if(curLeftNode.till >= curRightNode.from){
                if(curLeftNode.till > curRightNode.till){  // LeftNode absorbs RightNode
                    long temp = curLeftNode.till;
                    curLeftNode.till = curRightNode.from - 1;
                    curRightNode.till = temp;
                }
                else{
                    curLeftNode.till = curRightNode.from - 1;
                }
            }
        }

        for(Node2 node: list){
            long tempSum = node.till - node.from + 1;
            if(tempSum > 0){
                count += tempSum;
            }
        }

        return count;
    }
}

class Node2 {
    long from;
    long till;

    Node2(long from, long till){
        this.from = from;
        this.till = till;
    }

    boolean isInRange(long ID){
        if(from <= ID && till >= ID){
            return true;
        }
        return false;
    }
}