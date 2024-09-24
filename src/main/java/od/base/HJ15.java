package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description 采用Brian Kernighan 算法，
 * 它的核心思想是通过不断地将数字与其减一的结果进行按位与操作，从而消除最低位的 1，直到数字变为零为止。
 * @date 2024/9/18 11:11:43
 */
public class HJ15 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bf.readLine());
        int count = 0;
        while (num != 0) {
            // 检查 number 的最低位是否为 1
            if ((num & 1) == 1) {
                count++;
            }
            // 向右移动一位
            num >>>= 1;
        }
        System.out.println(count);
    }
}
