package com.example.leetcode.trie;

import org.apache.commons.collections4.trie.PatriciaTrie;

/**
 * PatriciaTrie、AbstractBitwiseTrie为Trie树的实现类
 */
public class Trie {
    public static void main(String[] args) {
        PatriciaTrie<String> t = new PatriciaTrie<String>();
        String s = "给出N个单词组成的熟词表，以及一篇全用小写英文书写的文章，请你按最早出现的顺序写出所有不在熟词表中的生词。在这道题中，我们可以用数组枚举，用哈希，用字典树，先把熟词建一棵树，然后读入文章进行比较，这种方法效率是比较高的";
        t.put("a", "以");
        t.put("b", "请");
        t.put("c", "在");

        for (int i = 0; i < s.length(); i++) {
            if (t.containsValue(s.charAt(i) + "")) {
                System.out.println(s.charAt(i));
            }
        }
    }
}
