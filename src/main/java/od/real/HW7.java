package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/25 23:58
 * 题目：查找充电设备组合
 * 考察：动态规则
 */
public class HW7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        int max = in.nextInt();

        // 动态规划求解
        int[] dps = new int[max + 1];
        for (int i = 0; i < nums.length; i++) {
            for (int j = max; j >= nums[i]; j--) {
                dps[j] = Math.max(dps[j], dps[j - nums[i]] + nums[i]);
            }
        }
        System.out.println(dps[max]);
    }
}
