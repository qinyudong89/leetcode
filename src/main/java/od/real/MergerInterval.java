package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/21 16:03
 * 题目：路灯照明问题
 * 知识点：合并区间
 */
public class MergerInterval {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        // 最右端边界
        int maxLen = (n - 1) * 100;
        // 初始分差分数组
        int[] diff = new int[maxLen + 1];
        for (int i = 0; i < nums.length; i++) {
            // 起始点
            int pos = i * 100;
            // 左边界
            int left = Math.max(pos - nums[i], 0);
            // 右边界
            int rigth = Math.min(pos + nums[i], maxLen);


            // 标记覆盖的区域
            diff[left] += 1;// 从left开始覆盖
            if (rigth + 1 <= maxLen) {
                diff[rigth + 1] -= 1;// 从rigth+1开始不再覆盖
            }
        }

        // 统计未被覆盖区域（通过前缀和实现）
        int sum = 0;
        int currentPos = 0;
        for (int i = 0; i < maxLen; i++) {
            currentPos += diff[i];
            if (currentPos == 0) {
                sum++;
            }
        }
        System.out.println(sum);

    }
}
