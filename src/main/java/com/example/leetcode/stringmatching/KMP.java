package com.example.leetcode.stringmatching;

/**
 * @Description:Knuth-Morris-Pratt算法
 * 参考资料：
 * https://github.com/henlix/string-pattern-matching/blob/master/src/org/sopt/string/strategy/impl/KMP.java
 * https://www.cnblogs.com/en-heng/p/5091365.html
 * http://www.ruanyifeng.com/blog/2013/05/Knuth%E2%80%93Morris%E2%80%93Pratt_algorithm.html
 * @Auther: 覃钰栋
 * @Date: 2019/6/20 16:53
 */
public class KMP {

    //搜索
    public int search(String text, String pattern) {
        int[] array = fail(pattern);
        int i = 0, j = 0;
        while (i < text.length()) {
            //case1：如果字符匹配，则继续匹配下个字符
            if (j == -1 || text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
            } else {
                //case2:当字符失配时，移动位数 = array[j]
                j = array[j];
            }
            if (j == pattern.length()) {
                return i - pattern.length();
            }
        }
        return -1;
    }

    /**
     * 失配函数
     * array为部分匹配表
     * array中的值是字符串的前缀集合与后缀集合的交集中，最长元素的长度（失配时右移位数）
     * <p>
     * 例如，对于”aba”，它的前缀集合为{”a”, ”ab”}，后缀 集合为{”ba”, ”a”}。
     * 两个集合的交集为{”a”}，那么长度最长的元素就是字符串”a”了，
     * 长 度为1，所以对于”aba”而言，它在PMT表中对应的值就是1
     *
     * @param pattern
     * @return
     */
    private int[] fail(String pattern) {
        int m = pattern.length();
        int[] array = new int[m + 1];
        int i = 1;
        int j = 0;
        //第0位的值，我们将其设成了-1，这只是为了编程的方便，并没有其他的意义
        array[0] = -1;

        while (i < m) {
            if (j == -1 || pattern.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;
                array[i] = j;
            } else {
                j = array[j];
            }
        }
        return array;
    }

    public static void main(String[] args) {
        KMP kmp = new KMP();
        String p = "abababca";
        String t = "ababababca";
        int index = kmp.search(t, p);
        System.out.println(index);

    }
}
