package com.example.leetcode.SlidingWindow;

import org.springframework.util.Assert;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/7 9:24
 * @desc:无重复字符的最长子串
 */
public class LC3 {
    public static void main(String[] args) {
        System.out.println(new LC3().lengthOfLongestSubstring("abca"));
    }
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        int maxLen = 0;
        int left = 0;
        for (int rigth = 0; rigth < s.length(); rigth++) {
            char c = s.charAt(rigth);
            // 如果字符已经存在于哈希表中，更新左边界,保证区间 dic.get(c) + 1 内无重复字符且最大。
            if (dic.containsKey(c)) {
                left = Math.max(left, dic.get(c) + 1);
            }
            // 更新
            dic.put(c, rigth);
            maxLen = Math.max(maxLen, rigth - left + 1);
        }
        return maxLen;
    }
}
