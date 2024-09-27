package com.example.leetcode.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/27 18:04:58
 */
public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        long[] dp = new long[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;  // dp[i]: 换到面值i所用的最小数量

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : (int) dp[amount];
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            // 读取硬币数组
            String[] coinStrs = scanner.nextLine().split(",");
            int[] coins = new int[coinStrs.length];
            for (int i = 0; i < coinStrs.length; i++) {
                coins[i] = Integer.parseInt(coinStrs[i].trim());
            }

            // 读取金额
            int amount = scanner.nextInt();

            // 输出结果
            System.out.println(coinChange(coins, amount));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}

