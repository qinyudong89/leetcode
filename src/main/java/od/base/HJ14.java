package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 10:13:41
 */
public class HJ14 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        Scanner in = new Scanner(System.in);
        PriorityQueue<String> queue = new PriorityQueue<>();
        for (int i = 0; i < num; i++){
            queue.add(in.next());
        }
        while (!queue.isEmpty()){
            System.out.println(queue.poll());
        }
    }

}
