package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/9 8:51
 */
public class HW157 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        // 读取允许的最大瑕疵度
        int flaw = in.nextInt();
        in.nextLine();  // 消耗换行符

        // 读取输入字符串
        String s = in.nextLine();

        // 初始化最大子串长度
        int maxLen = 0;

        // 外层循环：枚举子串的起始位置
        for (int start = 0; start < s.length(); start++) {
            // 起始字符必须是元音字母
            if (!isVowel(s.charAt(start))) {
                continue;  // 跳过非元音字母作为起始位置的情况
            }

            // 记录当前子串的瑕疵度
            int flawCount = 0;

            // 内层循环：枚举子串的结束位置
            for (int end = start; end < s.length(); end++) {
                // 检查当前字符是否是元音字母
                if (!isVowel(s.charAt(end))) {
                    flawCount++;  // 累加瑕疵度
                }

                // 如果瑕疵度超过允许的最大值，提前退出内层循环
                if (flawCount > flaw) {
                    break;
                }

                // 更新最大子串长度
                maxLen = Math.max(maxLen, end - start + 1);
            }
        }

        // 输出最长子串的长度
        System.out.println(maxLen);
    }

    // 判断字符是否是元音字母
    private static boolean isVowel(char c) {
        return "AEIOUaeiou".indexOf(c) != -1;
    }

}
