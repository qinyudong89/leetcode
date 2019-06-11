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
    private int scale = 256;
    //文件长度
    private int n;
    //模式串长度
    private int m;
    //模式hash
    private int patternHash;
    //
    private long baseHash;

    public  int search(String text, String pattern){
        int n = text.length();
        int m = pattern.length();

        if (m > n || m == 0 || n == 0){
            return -1;
        }


        return -1;
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
        long prime = longRandomPrime();
        for (int j = 0; j < m; j++) {
            //使用霍纳法则，快速解决“多项式求值”
            h = (scale * h + key.charAt(j)) % prime;
        }
        return h;
    }


    private  long longRandomPrime() {
        BigInteger prime = BigInteger.probablePrime(31, new Random());
        return prime.longValue();
    }

    public static void main(String[] args) {
        System.out.println();
    }
}
