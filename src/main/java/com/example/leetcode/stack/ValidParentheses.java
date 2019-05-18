package com.example.leetcode.stack;

import java.util.Stack;

/**
 * @author yu dong qin
 * @ClassName: 20. 有效的括号
 * @Description:
 * 1、有效的括号的前提是左边括号必须合法。因此合法时才将元素加入栈
 * 2、如果元素是右括符号，那么判断有没有跟它相匹配的左边括号
 * @date
 */
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if ('(' == c || '{' == c || '[' == c) {
                stack.push(c);
            } else if (')' == c) {
                if (stack.isEmpty() || stack.pop() != '(') {
                    return false;
                }
            } else if ('}' == c) {
                if (stack.isEmpty() || stack.pop() != '{') {
                    return false;
                }
            } else if (']' == c) {
                if (stack.isEmpty() || stack.pop() != '[') {
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
