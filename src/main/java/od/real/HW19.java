package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/6 11:08
 * 题目：事件推送
 */
public class HW19 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        int r = in.nextInt();

        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.nextInt();
        }

        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = in.nextInt();
        }

        int index = 0;
        for (int i = 0; i < m; i++) {
            while (index < b.length && b[index] < a[i]) {
                index++;
            }
            if (index < b.length && b[index] - a[i] <= r) {
                System.out.println(a[i] + " " + b[index]);
            }
        }
    }
}
