package od.e24;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/12 18:20
 */
public class E4 {

    // 实现一个：光伏场地建设规划
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 输入
        int L = in.nextInt();
        int W = in.nextInt();
        int P = in.nextInt();
        int minPower = in.nextInt();
        // 发电量矩阵构建
        int[][] preSum = new int[L + 1][W + 1];
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= W; j++) {
                preSum[i][j] = in.nextInt();
            }
        }

        // 前缀和矩阵构建
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= W; j++) {
                preSum[i][j] += preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }

        // 遍历矩形区域
        int count = 0;
        for (int i = 1; i <= L - P + 1; i++) {
            for (int j = 1; j <= W - P + 1; j++) {
                int x2 = i + P - 1;
                int y2 = j + P - 1;
                int sum = preSum[x2][y2] - preSum[i - 1][y2] - preSum[x2][j - 1] + preSum[i - 1][j - 1];
                if (sum >= minPower) {
                    count++;
                }
            }
        }
        System.out.println(count);

    }
}
