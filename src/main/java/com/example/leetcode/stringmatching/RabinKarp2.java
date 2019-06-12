package com.example.leetcode.stringmatching;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Description:Rabin-Karp算法
 * @Auther: 覃钰栋
 * @Date: 2019/6/12 14:41
 */
public class RabinKarp2 {
    // d是进制
    public final static int d = 256;

    static void search(String text, String pattern) {
        int M = pattern.length();
        int N = text.length();
        int i, j;
        //模式哈希值
        int p = 0;
        //文本哈希值
        int t = 0;
        int h = 1;
        //质数
        int q = randomPrime();

        // h的值为“pow(d, M-1)%q”
        for (i = 0; i < M - 1; i++) {
            h = (h * d) % q;
        }

        //首先计算模式的哈希值、及窗口的文本
        for (i = 0; i < M; i++) {
            p = (d * p + pattern.charAt(i)) % q;
            t = (d * t + text.charAt(i)) % q;
        }

        //将模式与文本的每个窗口比较
        for (i = 0; i <= N - M; i++) {
            //如果模式哈希值与文本窗口的哈希值相等，则比较字符串
            if (p == t) {
                for (j = 0; j < M; j++) {
                    if (text.charAt(i + j) != pattern.charAt(j)) {
                        break;
                    }
                }
                // if p == t and pat[0...M-1] = txt[i, i+1, ...i+M-1]
                if (j == M) {
                    System.out.println("Pattern found at index " + i);
                }
            }

            // 计算下一个文本窗口的哈希值: 删除前位数，添加后位数
            if (i < N - M) {
                t = (d * (t - text.charAt(i) * h) + text.charAt(i + M)) % q;

                // 我们可能得到负的t，把它变成正的
                if (t < 0) {
                    t = (t + q);
                }
            }
        }
    }

    //随机生成素数
    private static int randomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.intValue();
    }

}
