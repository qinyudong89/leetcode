package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/22 8:50
 * * 题目：最长的指定瑕疵度的元音子串
 * * 知识点：滑动窗口
 */
public class SlidingWindow {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 瑕疵度
        int flaw = in.nextInt();
        in.nextLine();
        // 字符串
        String s = in.nextLine();
        int maxLen = 0;
        for (int start = 0; start < s.length(); start++) {
            // 首个字母必需是元音字母
            if (!(isVowel(s.charAt(start)))) {
                continue;
            }

            int flawCount = 0;
            for (int end = start; end < s.length(); end++) {
                if (!(isVowel(s.charAt(end)))) {
                    flawCount++;
                }
                // 瑕疵度超限，重置
                if (flawCount > flaw) {
                    break;
                }
                // 更新最大子串的长度
                if (isVowel(s.charAt(end))) {
                    maxLen = Math.max(maxLen, end - start + 1);
                }
            }
        }
        System.out.println(maxLen);

    }

    public static boolean isVowel(char c) {
        return "aeiouAEIOU".indexOf(c) != -1;
    }
}
