package com.example.leetcode.dp;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/28 15:07
 * @Description :完全背包不考虑顺序的组合问题：外循环coins,内循环target正序,应用转移方程3
 */
public class LC518 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int amount = Integer.parseInt(in.nextLine());
        String[] strs = in.nextLine().split(",");
        int[] coins = new int[strs.length];
        for (int i = 0; i < strs.length; i++) {
            coins[i] = Integer.parseInt(strs[i]);
        }

        /**
         * 对于每种硬币 coin，从 1 到 amount 遍历每个可能的目标金额 i。
         * 如果当前金额 i 大于等于硬币面额 coin，则更新 dp[i] 的值：将 dp[i - coin] 累加到 dp[i] 上。
         * 这表示可以通过选择当前硬币来达到金额 i 的组合方法数。
         */
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {
                if (i >= coin) {
                    dp[i] += dp[i - coin];
                }
            }
        }
        System.out.println(dp[amount]);
    }
}
