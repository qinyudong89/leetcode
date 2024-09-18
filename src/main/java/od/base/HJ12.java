package od.base;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author : Morgan.Qin
 *
 * @create 2024/9/18 8:33
 */
public class HJ12 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // 使用栈先进后出的特点实现
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length() ; i++) {
            stack.push(s.charAt(i));
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
    }
}
