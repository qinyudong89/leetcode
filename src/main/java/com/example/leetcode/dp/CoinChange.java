package com.example.leetcode.dp;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/27 18:04:58
 */
public class CoinChange {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] pushs = scanner.nextLine().split(",");
        int[] coins = new int[pushs.length];
        for (int i = 0; i < pushs.length; i++) {
            coins[i] = Integer.parseInt(pushs[i]);
        }
        int amount = scanner.nextInt();
        long[] db = new long[amount + 1];
        Arrays.fill(db, Integer.MAX_VALUE);
        db[0] = 0;
        for (int coin : coins) {
            for (int i = 0; i <= amount; i++) {
                if (coin <= i) {
                    db[i] = Math.min(db[i], db[i - coin] + 1);
                }
            }
        }
        int result = db[amount] == Integer.MAX_VALUE ? -1 : (int) db[amount];
        System.out.println(result);
    }
}

