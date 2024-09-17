package od.base;

import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/17 14:36
 */
public class HJ8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long size = in.nextInt();
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < size; i++) {
            int key = in.nextInt();
            int value = in.nextInt();
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + value);
            } else {
                map.put(key, value);
            }
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
