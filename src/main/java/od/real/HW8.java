package od.real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/29 16:57
 * 题目 :最多团队
 * 考察：排序+双指针
 */
public class HW8 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 总人数
        int total = in.nextInt();
        // 个人能力
        int[] nums = new int[total];
        for (int i = 0; i < total; i++) {
            nums[i] = in.nextInt();
        }
        // 最低能力值
        int min = in.nextInt();

        // 排序
        Arrays.sort(nums);
        // 统计可以组成多少团队
        int count = 0;

        // 单人团队>min
        for (int i : nums) {
            if (i >= min) {
                count++;
            }
        }

        // 采用双指针
        int low = 0;
        int high = total - count - 1;
        while (low <= high) {
            // 双人团队
            if (nums[low] + nums[high] >= min) {
                count++;
                low++;
                high--;
            } else {
                low++;
                high--;
            }
        }
        System.out.println(count);
    }
}
