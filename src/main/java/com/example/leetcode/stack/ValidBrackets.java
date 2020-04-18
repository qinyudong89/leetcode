package com.example.leetcode.stack;

import java.util.*;
/**
 * @author yu dong qin
 * @ClassName: 20. 有效的括号
 * @Description:
 * 1、有效的括号的前提是左边括号必须合法。因此合法时才将元素加入栈
 * 2、如果元素是右括符号，那么判断有没有跟它相匹配的左边括号
 * @date
 */
public class ValidBrackets {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character,Character> map = new HashMap<>();
        map.put(')','(');
        map.put('}','{');
        map.put(']','[');
        for (Character c: s.toCharArray()) {
            if(!map.containsKey(c)) {
                //为左括号时直接入栈
                stack.push(c);
            }else{
                //为右括号时，如果栈为空或者栈顶与该括号类型不匹配返回false
                if(stack.empty() || map.get(c) != stack.pop()){
                    return false;
                }
            }
        }
        //字符串遍历完毕后，如果栈为空返回true，反之返回false
        return stack.empty();
    }
}
