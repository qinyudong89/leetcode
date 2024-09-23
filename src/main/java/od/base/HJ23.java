package od.base;

import java.util.*;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 16:31:01
 */
public class HJ23 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Map<Character, Integer> map = new HashMap<>();
        char[] arr = in.nextLine().toCharArray();
        // 统计字符出现的次数
        for (char c : arr) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 找到出现次数最少的字符
        int min = Integer.MAX_VALUE;
        for (int num : map.values()) {
            min = Math.min(num, min);
        }
        // 剔除出现次数最少的字符
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            if (map.get(c) != min) {
                sb.append(c);
            }
        }
        System.out.println(sb);
    }
}
