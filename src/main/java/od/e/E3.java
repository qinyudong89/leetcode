package od.e;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/10 23:10
 * 两个字符串间的最短路径问题
 */
public class E3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strArray = scanner.nextLine().split(" ");

        String s1 = "o" + strArray[0];
        String s2 = "o" + strArray[1];

        char[] a = s1.toCharArray();
        char[] b = s2.toCharArray();


        // 初始化 dp 数组
        int[][] dp = new int[a.length][b.length];
        // 初始化边界条件
        for (int i = 0; i < a.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < b.length; i++) {
            dp[0][i] = i;
        }

        // 动态规划填充 dp 数组
        for (int i = 1; i < a.length; i++) {
            for (int j = 1; j < b.length; j++) {
                if (a[i] == b[j]) {
                    // 斜边
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    // 垂直或水平边
                    dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + 1;
                }
            }
        }
        System.out.println(dp[a.length - 1][b.length - 1]);
    }

}
