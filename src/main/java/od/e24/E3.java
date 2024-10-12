package od.e24;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/12 14:06
 * 光伏场地建设规划
 */
public class E3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 长度
        int L = in.nextInt();
        // 宽度
        int W = in.nextInt();
        // 子方格边长
        int P = in.nextInt();
        // 最小发电量
        int minPower = in.nextInt();

        // 发电量矩阵构建
        int[][] preSum = new int[L + 1][W + 1];
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= W; j++) {
                preSum[i][j] = in.nextInt();
            }
        }

        // 前缀和数组构建
        for (int i = 1; i <= L; i++) {
            for (int j = 1; j <= W; j++) {
                preSum[i][j] += preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
            }
        }

        // 满足条件的区域数量
        int count = 0;

        // 遍历所有可能的正方形子区域的左上角坐标 (i, j)
        for (int i = 1; i <= L - P + 1; i++) {
            for (int j = 1; j <= W - P + 1; j++) {
                int x2 = i + P - 1;
                int y2 = j + P - 1;
                // 计算子矩阵的总发电量
                int totalPower = preSum[x2][y2] - preSum[i - 1][y2] - preSum[x2][j - 1] + preSum[i - 1][j - 1];
                // 判断是否满足条件
                if (totalPower >= minPower) {
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}
