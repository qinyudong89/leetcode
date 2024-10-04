package od.real;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/22 17:23
 * * 题目：最左侧冗余子串
 * * 知识点：哈希＋滑动窗口
 */
public class HW4 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        int k = in.nextInt();
        if (s2.length() < s1.length() + k) {
            System.out.println(-1);
            return;
        }

        Map<Character, Integer> countMap = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            countMap.put(s1.charAt(i), countMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> windowsMap = new HashMap<>();
        int windowSize = s1.length() + k;
        for (int i = 0; i < windowSize; i++) {
            windowsMap.put(s2.charAt(i), windowsMap.getOrDefault(s2.charAt(i), 0) + 1);
        }

        if (match(countMap, windowsMap)) {
            System.out.println(0);
            return;
        }
        for (int i = windowSize; i < s2.length(); i++) {
            /**
             * 移除左侧字符
             * 1.先找出最左字符
             * 2.再将统计次数减一
             * 3.判断是否为0，为0则移除
             */
            char leftChar = s2.charAt(i - windowSize);
            windowsMap.put(leftChar, windowsMap.get(leftChar) - 1);
            if (windowsMap.get(leftChar) == 0) {
                windowsMap.remove(leftChar);
            }
            // 添加右侧字符
            char rigthChar = s2.charAt(i);
            windowsMap.put(rigthChar, windowsMap.getOrDefault(rigthChar, 0) + 1);

            // 判断是否匹配
            if (match(countMap, windowsMap)) {
                System.out.println(i - windowSize + 1);
                return;
            }
        }

        System.out.println(-1);
    }


    /**
     * 依次检查：
     * 滑动窗口中的字符频率必须大于或等于目标字符串中的字符频率（即 countMap 中的频率要求）
     *
     * @param countMap
     * @param windowsMap
     * @return
     */
    public static boolean match(Map<Character, Integer> countMap, Map<Character, Integer> windowsMap) {
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            char c = entry.getKey();
            int count = entry.getValue();
            if (windowsMap.getOrDefault(c, 0) < count) {
                return false;
            }
         }
        return true;
    }
}
