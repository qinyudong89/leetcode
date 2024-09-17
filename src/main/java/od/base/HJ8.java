package od.base;

import java.io.IOException;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class HJ8 {

    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int n  = in .nextInt();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int i=0; i<n;i++){
            int k = in.nextInt();
            int v = in.nextInt();
            map.merge(k,v,Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}

