package com.example.leetcode.stringmatching;

/**
 * @Description:Boyer-Moore算法
 * 参考资料：http://www.ruanyifeng.com/blog/2013/05/boyer-moore_string_search_algorithm.html
 *         https://www.cnblogs.com/en-heng/p/5095542.html
 *         https://www.cnblogs.com/en-heng/p/5095542.html
 * @Auther: 覃钰栋
 * @Date: 2019/6/19 17:00
 */
public class BoyerMoore2 {
    private static final int SIZE = 256;

    public int search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int bmBc[] = new int[SIZE];
        int bmGs[] = new int[SIZE];
        //预处理坏字符、好后缀
        preBmBc(pattern, pattern.length(), bmBc);
        preBmGs(pattern, pattern.length(), bmGs);

        int j = 0;
        while (j <= n - m) {
            int i;
            //从后匹配，查找text与pattern匹配的字符
            for (i = m - 1; i >= 0 && text.charAt(i + j) == pattern.charAt(i); i--) { }

            // 匹配成功，返回主串与模式串第一个匹配的字符的位置
            if (i < 0) {
                return j;
            } else {
                int gs = bmGs[i];
                //坏字符移位规则：后移位数 = 坏字符的位置 - 搜索词中的上一次出现位置
                int bc = bmBc[text.charAt(i + j)] - pattern.length() + 1 + i;
                //Boyer-Moore算法的基本思想是，每次后移位数。取坏字符规则与好后缀这两个规则之中后移位数较大的值，
                j += Math.max(gs, bc);
            }
        }
        return -1;
    }

    public void preBmBc(String pattern, int m, int[] bmBc) {
        for (int i = 0; i < SIZE; i++) {
            bmBc[i] = m;
        }

        for (int i = 0; i < m - 1; i++) {
            bmBc[pattern.charAt(i)] = m - i - 1;
        }
    }

    /*
     *
     * @Description 好后缀规则表
     * @param [pattern, m, suff]
     * @return void
     * @author yu dong qin
     * @date 2019/6/19 18:14
     *
     */
    private void suffixes(String pattern, int m, int[] suff) {
        int f = 0;
        int g = m - 1;

        for (int i = m - 2; i >= 0; i--) {
            if (i > g && suff[i + m - 1 - f] < i - g) {
                suff[i] = suff[i + m - 1 - f];
            } else {
                if (i < g) {
                    g = i;
                }
                f = i;
                while (g >= 0 && pattern.charAt(g) == pattern.charAt(g + m - 1 - f)) {
                    --g;
                }
                suff[i] = f - g;
            }
        }
        suff[m - 1] = m;
    }

    /*
     *
     * @Description 预处理好后缀
     * @param [pattern, m, bmGs]
     * @return void
     * @author yu dong qin
     * @date 2019/6/19 18:15
     *
     */
    private void preBmGs(String pattern, int m, int[] bmGs) {
        int i, j = 0;
        int[] suff = new int[m];
        suffixes(pattern, m, suff);

        //case1：没有好后缀
        for (i = 0; i < m; ++i) {
            bmGs[i] = m;
        }

        //case2:移动后，模式串只有能部分匹配上好后缀的子串
        for (i = m - 1; i >= 0; --i) {
            if (suff[i] == i + 1) {
                for (; j < m - 1 - i; ++j) {
                    if (bmGs[j] == m) {
                        bmGs[j] = m - 1 - i;
                    }
                }
            }
        }

        //case3:移动后，模式串有子串能完全匹配上好后缀
        for (i = 0; i <= m - 2; ++i) {
            bmGs[m - 1 - suff[i]] = m - 1 - i;
        }
    }

    public static void main(String[] args) {
        BoyerMoore2 bm = new BoyerMoore2();
        String p = "EXAMPLE";
        String t = "HERE IS A SIMPLE EXAMPLE";
        int index = bm.search(t, p);
        System.out.println(index);

    }
}