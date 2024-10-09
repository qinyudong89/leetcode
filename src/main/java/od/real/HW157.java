package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/9 8:51
 *  * * 题目：最长的指定瑕疵度的元音子串
 *  * * 知识点：滑动窗口
 */
public class HW157 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int flaw = Integer.parseInt(in.nextLine());
        String s = in.nextLine();
        int maxLen = 0;
        for (int left = 0; left < s.length(); left++) {
            if (!isVowel(s.charAt(left))) {
                continue;
            }
            int count = 0;
            // 窗口内最左字符是元音才开始记数
            for (int rigth = left; rigth < s.length(); rigth++) {
                if (!isVowel(s.charAt(rigth))){
                    count++;
                }
                // 瑕疵度超限，重置
                if (count > flaw){
                    break;
                }
                // 更新最长子串的长度
                if (isVowel(s.charAt(rigth))){
                    maxLen = Math.max(maxLen, rigth - left + 1);
                }
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
