package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/18 23:43
 */
public class HJ26 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = null;
        while ((s = bf.readLine()) != null && !s.equals(" ")) {
            // 先对英文字符进行汇总
            List<Character> list = new ArrayList<>();
            for (Character c : s.toCharArray()) {
                if (Character.isLetter(c)) {
                    list.add(c);
                }
            }
            // 对英文字符进行排序
            list.sort(new Comparator<Character>() {
                @Override
                public int compare(Character o1, Character o2) {
                    // 字母比较忽略大小写
                    return Character.toLowerCase(o1) - Character.toLowerCase(o2);
                }
            });

            // 重新组装字符串，非英文字符原地不动
            StringBuilder sb = new StringBuilder();
            for (int i = 0, j = 0; i < s.length(); i++) {
                Character c = s.charAt(i);
                if (Character.isLetter(c)) {
                    // 命中时j才自增，避免数组越界
                    sb.append(list.get(j++));
                } else {
                    // 非英文字符
                    sb.append(c);
                }
            }
            System.out.println(sb);
        }
    }
}
