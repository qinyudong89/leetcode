package com.example.leetcode.trie;

/**
 * Aho-Corasick算法
 * @author qinyu
 */
public class AhoCorasick {
    private static final int SIZE = 256;

    void search(char[] x, int m, char[] y, int n) {
        int i, j, k, ell;
        int[] kmpNext = new int[SIZE];

        /* Preprocessing */
        preKmp(x, m, kmpNext);
        for (ell = 1; x[ell - 1] == x[ell]; ell++) {
            ;
        }
        if (ell == m) {
            ell = 0;
        }

        /* Searching */
        i = ell;
        j = k = 0;
        while (j <= n - m) {
            while (i < m && x[i] == y[i + j]) {
                ++i;
            }
            if (i >= m) {
                while (k < ell && x[k] == y[j + k]) {
                    ++k;
                }
                if (k >= ell) {
                    System.out.println(j);
                }
            }
            //匹配失败时，回溯
            j += (i - kmpNext[i]);
            if (i == ell) {
                k = Math.max(0, k - 1);
            } else if (kmpNext[i] <= ell) {
                k = Math.max(0, kmpNext[i]);
                i = ell;
            } else {
                k = ell;
                i = kmpNext[i];
            }
        }
    }

    void preKmp(char[] pattern, int m, int[] kmpNext) {
        int i = 1;
        int j = 0;
        //第0位的值，我们将其设成了-1，这只是为了编程的方便，并没有其他的意义
        kmpNext[0] = -1;
        while (i < m) {
            if (j == -1 || pattern[i] == pattern[j]) {
                i++;
                j++;
                kmpNext[i] = j;
            } else {
                j = kmpNext[j];
            }
        }
    }

    public static void main(String[] args) {
        AhoCorasick ac = new AhoCorasick();
        String text = "GCATCGCAGAGAGTATACAGTACG";
        String pattern = "GCAGAGAG";
        ac.search(pattern.toCharArray(), pattern.length(), text.toCharArray(), text.length());
    }
}
