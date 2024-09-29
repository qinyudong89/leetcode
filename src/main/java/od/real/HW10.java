package od.real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/29 21:52
 * 题目：计算最接近的数
 */
public class HW10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine()
                .split("]");
        String[] numStrs = strs[0].replace("[", "").split(",");
        int[] nums = new int[numStrs.length];
        int target = Integer.parseInt(strs[1].replace(",",""));

        for (int i = 0; i < numStrs.length; i++) {
            nums[i] = Integer.parseInt(numStrs[i]);
        }
        Arrays.sort(nums);
        // 二分查找
        int left = 0;
        int right = nums.length - 1;
        int closest = nums[0];
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 当前值与目标值的距离
            int diff = Math.abs(nums[mid] - target);
            // 上一个值与目标值的距离
            int prevDiff = Math.abs(closest - target);
            if (diff < prevDiff) {
                closest = nums[mid];
            } else if (diff == prevDiff) {
                closest = Math.max(closest, nums[mid]);
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }

        System.out.println(closest);
    }
}

