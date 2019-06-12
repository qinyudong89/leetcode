package com.example.leetcode.stringmatching;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/6/11 17:33
 */
public class RabinKarp {
    //质数(减少哈希冲突)
    private long prime;
    //进制
    private int denary = 256;
    //文件长度
    private int n;
    //模式串长度
    private int m;
    //模式hash
    private long p;
    //
    private long h;

    //初始化
    public void init(String text, String pattern) {
        this.n = text.length();
        this.m = pattern.length();
        this.prime = randomPrime();
        h = 1;
        for (int i = 1; i <= m - 1; i++) {
            h = (denary * h) % prime;
        }
        p = hash(pattern, m);
    }

    //搜索
    public int search(String text, String pattern) {
        init(text, pattern);
        if (n < m) {
            return -1;
        }
        long textHash = hash(text, m);
        if ((p == textHash) && check(text, pattern, 0)) {
            return 0;
        }

        for (int i = m; i < n; i++) {
            //利用上一个子串的hash，在O(1)的时间内计算出下一个子串的hash
            textHash = (textHash + prime - h * text.charAt(i - m) % prime) % prime;
            textHash = (textHash * denary + text.charAt(i)) % prime;
            //计算下标
            int offset = i - m + 1;
            //在比较散列值相同后，使用“拉斯维加斯方法则”，再去比较字符，保证在散列冲突的情况下，仍能保证正确性
            if ((p == textHash) && check(text, pattern, offset)) {
                return offset;
            }
        }
        return -1;
    }

    //hash值相等时，再比较字符串是不相等
    private boolean check(String txt, String pattern, int i) {
        for (int j = 0; j < m; j++) {
            if (pattern.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    //计算hash
    private long hash(String key, int m) {
        long hash = 0;
        for (int j = 0; j < m; j++) {
            //使用霍纳法则，快速解决“多项式求值”
            hash = (denary * hash + key.charAt(j)) % prime;
        }
        return hash;
    }

    //随机生成素数
    private long randomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp();
        int index = rabinKarp.search("面试算法之字符串匹配算法,Rabin-Karp算法详解 09-08 阅读数 3709 既然谈论到字符串相关算法,那么字符串匹配是根本绕不过去的坎。在面试中,面试官可", "既然谈论到字");
        System.out.println(index);
    }
}
