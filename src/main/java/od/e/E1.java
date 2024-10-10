package od.e;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/10 22:10
 * 找朋友
 */
public class E1 {
    public static void main(String[] args) {
//        forec();
        stack();
    }

    public static void stack(){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] kids = new int[n];
        for (int i = 0; i < n; i++) {
            kids[i] = in.nextInt();
        }
        int[] res = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && kids[stack.peek()]<kids[i]){
                res[stack.pop()] = i;
            }
            stack.push(i);
        }

        for (int i: res){
            System.out.print(i+" ");
        }

    }

    public static void forec() {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] kids = new int[n];
        for (int i = 0; i < n; i++) {
            kids[i] = in.nextInt();
        }

        int[] res = new int[n];
        for (int i = 0; i < kids.length; i++) {
            for (int j = i + 1; j < n; j++) {
                if (kids[i] < kids[j]) {
                    res[i] = j;
                    break;
                }
            }
        }
        for (int i = 0; i < res.length; i++) {
            System.out.print(res[i] + " ");
        }
    }
}
