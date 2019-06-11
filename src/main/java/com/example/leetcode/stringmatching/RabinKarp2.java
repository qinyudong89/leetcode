package com.example.leetcode.stringmatching;

import java.math.BigInteger;
import java.util.Random;

/**
 * @Description:
 * @Auther: 覃钰栋
 * @Date: 2019/6/11 15:30
 */
public class RabinKarp2 {
    private String pat;
    private long patHash;
    private int m;
    private long q;
    private int R;
    private long RM;

    public RabinKarp2(String pat) {
        this.pat = pat;
        R = 256;
        m = pat.length();
        q = longRandomPrime();

        RM = 1;
        for (int i = 1; i <= m - 1; i++) {
            RM = (R * RM) % q;
        }
        patHash = hash(pat, m);
    }

    /*
     *
     * @Description 计算散列值
     * @param [key, m]
     * @return long
     * @author yu dong qin
     * @date 2019/6/11 15:51
     *
     */
    private long hash(String key, int m) {
        long h = 0;
        for (int j = 0; j < m; j++) {
            //使用霍纳法则，快速解决“多项式求值”
            h = (R * h + key.charAt(j)) % q;
        }
        return h;
    }

    /*
     *
     * @Description 在比较散列值相同后，再去比较字符
     * @param [txt, i]
     * @return boolean
     * @author yu dong qin
     * @date 2019/6/11 15:51
     *
     */
    private boolean check(String txt, int i) {
        for (int j = 0; j < m; j++) {
            if (pat.charAt(j) != txt.charAt(i + j)) {
                return false;
            }
        }
        return true;
    }

    public int search(String txt) {
        int n = txt.length();
        if (n < m) {
            return n;
        }
        long txtHash = hash(txt, m);

        if ((patHash == txtHash) && check(txt, 0)) {
            return 0;
        }

        for (int i = m; i < n; i++) {
            //利用上一个子串的hash结果hash(Si-m+1)，在O(1)的时间内计算出hash(Si-m+2)
            txtHash = (txtHash + q - RM * txt.charAt(i - m) % q) % q;
            txtHash = (txtHash * R + txt.charAt(i)) % q;
            //计算下标
            int offset = i - m + 1;
            //使用“拉斯维加斯方法则”，在比较散列值相同后，再去比较字符，保证在散列冲突的情况下，仍能保证正确性
            if ((patHash == txtHash) && check(txt, offset)) {
                return offset;
            }
        }
        return n;
    }

    private static long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        RabinKarp2 rabinKarp = new RabinKarp2("abc");
        int index = rabinKarp.search("errtyyye");
        System.out.println(index);
    }
}