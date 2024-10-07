package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/7 0:08
 * 题目：根据某条件聚类最少交换次数
 */
public class HW21 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] arr = in.nextLine().split(" ");
        int[] nums = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            nums[i] = Integer.parseInt(arr[i]);
        }
        int k = in.nextInt();

        // 统计小于k的个数
        int countK = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] < k){
                countK++;
            }
        }
        if  (countK == 0){
            System.out.println(0);
            return;
        }
        // 统计当前窗口交换的次数
        int currSwap = 0;
        for (int i = 0; i < nums.length; i++){
            if (nums[i] >= k){
                currSwap++;
            }
        }

        // 使用滑动窗口，统计最小交换次数
        int minSwap = currSwap;
        for (int i = countK; i < currSwap; i++) {
            if (nums[i-countK] < k){
                currSwap--;
            }
            if (nums[i] >= k){
                currSwap++;
            }
            minSwap = Math.min(minSwap, currSwap);
        }
        System.out.println(minSwap);
    }
}
