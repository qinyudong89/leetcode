package com.example.leetcode.stack;

import java.util.Stack;

/**
 * 394. 字符串解码
 * 解题思路详见：https://cloud.tencent.com/developer/article/1489554
 */
public class DecodeString {

    public String decodeString(String s) {
        //初始化数据结构
        Stack<StringBuilder> str = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        //遍历
        for (char c : s.toCharArray()) {
            if (c == '[') {
                //入栈
                str.push(res);
                nums.push(num);
                //刷新num、res
                num = 0;
                res = new StringBuilder();
            } else if (c == ']') {
                StringBuilder tmp = new StringBuilder();
                for (int i = nums.pop(); i > 0; i--) {
                    tmp.append(res);//res*3
                }
                res = str.pop().append(tmp);
            } else if (c >= '0' && c <= '9') {
                //计算重复次数(由于重复次数可能大于10，所以暂存数字时要适当处理，如 num*10+当前数字)
                num = num * 10 + (c - '0');
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}
