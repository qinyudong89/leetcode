package od.base;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/16 12:21
 */
public class HJ2 {
    public static void main(String[] args) {
        // 接收字符串
        Scanner sc = new Scanner(System.in);
        // 不区分大小写字母
        String s1 = sc.nextLine().toLowerCase();

        // 接收一个字符
        String s2 = sc.nextLine().toLowerCase();
        // 先将字符串中的该字符替换为空，再计算长度，s1与s2的长度差就是结果
        String s3 = s1.replaceAll(s2, "");
        System.out.println(s1.length() - s3.length());
    }
}
