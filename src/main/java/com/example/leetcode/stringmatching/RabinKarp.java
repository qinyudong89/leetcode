package com.example.leetcode.stringmatching;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/6/11 17:33
 */
public class RabinKarp {
    //质数
    private long prime;
    //进制
    private int denary = 256;
    //文件长度
    private int n;
    //模式串长度
    private int m;
    //模式hash
    private long patternHash;
    //text的第一个子串的hash值（用以后续计算）
    private long baseHash;

    //初始化
    public void init(String text, String pattern) {
        this.n = text.length();
        this.m = pattern.length();
        this.prime = randomPrime();
        baseHash = 1;
        for (int i = 1; i <= m - 1; i++) {
            baseHash = (denary * baseHash) % prime;
        }
        patternHash = hash(pattern, m);
    }

    //搜索
    public int search(String text, String pattern) {
        init(text, pattern);
        if (n < m) {
            return -1;
        }
        long txtHash = hash(text, m);
        if ((patternHash == txtHash) && check(text, pattern, 0)) {
            return 0;
        }

        for (int i = m; i < n; i++) {
            //利用上一个子串的hash结果hash(Si-m+1)，在O(1)的时间内计算出hash(Si-m+2)
            txtHash = (txtHash + prime - baseHash * text.charAt(i - m) % prime) % prime;
            txtHash = (txtHash * denary + text.charAt(i)) % prime;
            //计算下标
            int offset = i - m + 1;
            //使用“拉斯维加斯方法则”，在比较散列值相同后，再去比较字符，保证在散列冲突的情况下，仍能保证正确性
            if ((patternHash == txtHash) && check(text, pattern, offset)) {
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
        long h = 0;
        for (int j = 0; j < m; j++) {
            //使用霍纳法则，快速解决“多项式求值”
            h = (denary * h + key.charAt(j)) % prime;
        }
        return h;
    }

    //随机生成素数
    private long randomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        RabinKarp rabinKarp = new RabinKarp();
        int index = rabinKarp.search("errtyyye", "ye");
        System.out.println(index);
    }
}
