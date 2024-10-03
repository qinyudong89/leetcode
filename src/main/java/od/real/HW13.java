package od.real;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/3 11:09
 * 题目：数组组成的最小数字
 * 描述：给定一个数组，将数组中的元素按照升序排列，并组成一个新数组，要求新数组中的元素为原数组中元素组成的最小数字。
 */
public class HW13 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            String line = scanner.nextLine();
            solution(line);
        }
    }

    private static void solution(String line) {
        String[] split = line.split(",");
        int len = split.length;

        int[] ints = new int[len];
        for (int i = 0; i < len; i++) {
            ints[i] = Integer.parseInt(split[i]);
        }

        // 使用自然数值顺序，确保数字小的排在前面
        Arrays.sort(ints);

        // 选择前3个最小的数，如果不足3个就选择全部
        int numsLen = Math.min(3, len);
        String[] nums = new String[numsLen];
        for (int i = 0; i < numsLen; i++) {
            nums[i] = String.valueOf(ints[i]);
        }
        // 按字典序（字母顺序）升序排列，确保数字组合最小
        Arrays.sort(nums);
        StringBuilder sb = new StringBuilder();
        for (String num : nums) {
            sb.append(num);
        }
        // 输出拼接后的最小数字
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
