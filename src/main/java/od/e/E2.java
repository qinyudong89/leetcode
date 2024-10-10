package od.e;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/10 22:46
 */
public class E2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int n = arr.length;
        // 第一个元素的左侧积为1
        long[] rigthProduct = new long[n];
        // 最后一个元素的右侧积为1
        rigthProduct[n - 1] = 1;
        // 计算右侧积
        for (int i = n - 2; i >= 0; i--) {
            rigthProduct[i] = rigthProduct[i + 1] * nums[i + 1];
        }

        // 计算左侧积
        long leftProduct = 1;
        for (int i = 0; i < n; i++) {
            if (leftProduct == rigthProduct[i]) {
                System.out.print(i );
                return;
            }
            if (i < n - 1) {
                leftProduct *= nums[i];
            }
        }
        System.out.println(-1);
    }
}
