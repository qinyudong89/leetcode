package com.example.leetcode.SlidingWindow;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/7 12:40
 */
public class LC209 {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        int left = 0;
        int minLen = Integer.MAX_VALUE;
        int sum = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public static void main(String[] args) {
        // 示例 1
        int target1 = 7;
        int[] nums1 = {2, 3, 1, 2, 4, 3};
        LC209 solution = new LC209();
        System.out.println(solution.minSubArrayLen(target1, nums1)); // 输出 2

        // 示例 2
        int target2 = 4;
        int[] nums2 = {1, 4, 4};
        System.out.println(solution.minSubArrayLen(target2, nums2)); // 输出 1

        // 示例 3
        int target3 = 11;
        int[] nums3 = {1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println(solution.minSubArrayLen(target3, nums3)); // 输出 0
    }
}
