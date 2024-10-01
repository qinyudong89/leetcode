package od.real;

import org.apache.commons.collections4.MapUtils;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/1 9:10
 */
public class HW11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr1 = in.nextLine().split(",");
        String[] arr2 = in.nextLine().split(",");
        TreeMap<Integer, Integer> map1 = new TreeMap<>();
        TreeMap<Integer, Integer> map2 = new TreeMap<>();

        // 统计出现次数
        for (String s : arr1) {
            int num = Integer.parseInt(s);
            map1.put(num, map1.getOrDefault(num, 0) + 1);
        }
        for (String s : arr2) {
            int num = Integer.parseInt(s);
            map2.put(num, map2.getOrDefault(num, 0) + 1);
        }
        // 出现次数相同的数进行分组
        TreeMap<Integer,Integer> couonMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry: map1.entrySet()){
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            if (map2.containsKey(key)){
                couonMap.put(key, Math.min(value, map2.get(key)));
            }
        }
        if (MapUtils.isEmpty(couonMap)){
            System.out.println("NULL");
            return;
        }

        TreeMap<Integer, List<Integer>> outMap = new TreeMap<>();
        for (Map.Entry<Integer, Integer> entry: couonMap.entrySet()){
            int count = entry.getValue();
            int num = entry.getKey();
            outMap.putIfAbsent(count, new ArrayList<>());
            outMap.get(count).add(num);
        }

        for (Map.Entry<Integer, List<Integer>> entry: outMap.entrySet()){
            int key = entry.getKey();
            StringBuilder sb = new StringBuilder();
            for (Integer num: entry.getValue()){
                sb.append(num).append(",");
            }
            sb.deleteCharAt(sb.length()-1);

            System.out.println(key + ":"+ sb.toString());
        }
    }
}
