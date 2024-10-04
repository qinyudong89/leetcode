package od.real;

import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/21 8:47
 * 整数对最小和
 */
public class HW1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt();
        int[] arr1 = new int[n1];
        for (int i= 0; i< n1; i++){
            arr1[i] = in.nextInt();
        }
        int n2 = in.nextInt();
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = in.nextInt();
        }

        int k = in.nextInt();
        // 以最小堆为例实现排序
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < n1; i++){
            for (int j = 0; j < n2; j++){
                queue.offer(arr1[i] + arr2[j]);
            }
        }
        int sum = 0;
        for (int i = 0; i < k; i++){
            sum += queue.poll();
        }
        System.out.println(sum);
    }
}
