package od.base;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 14:09:24
 */
public class MyTest {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s1 = sc.nextLine();
            String s2 = sc.nextLine();
            int k = sc.nextInt();
            // s2长度不够
            if (s2.length() < s1.length() + k) {
                System.out.println(-1);
                continue;
            }
            Map<Character, Integer> map = calculate(s1);
            Map<Character, Integer> map1 = calculate(s2.substring(0, s1.length() + k));
            boolean firstResult = true;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                if (!map1.containsKey(entry.getKey())
                        || map1.get(entry.getKey()) < entry.getValue()) {
                    firstResult = false;
                    break;
                }
            }
            if (firstResult) {
                System.out.println(0);
                continue;
            }


            int result = -1;
            int start = 1;
            for (int i = s1.length() + k; i < s2.length(); i++) {
                char last = s2.charAt(start++);
                char current = s2.charAt(i);
                map1.put(last, map1.get(last) - 1);
                map1.put(current, map1.getOrDefault(current, 0) + 1);

                boolean flag = true;
                for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                    if (!map1.containsKey(entry.getKey())
                            || map1.get(entry.getKey()) < entry.getValue()) {
                        flag = false;
                        break;
                    }
                }

                if (flag) {
                    result = start - 1;
                    break;
                }
            }
            System.out.println(result);
        }
    }

    static Map<Character, Integer> calculate(String word) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        return map;
    }
}
