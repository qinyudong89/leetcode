package od.real;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/6 12:55
 * 题目：任务处理
 */
public class HW20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 读取任务数量
        int n = scanner.nextInt();

        // 存储每个任务的起始时间和结束时间
        int[][] tasks = new int[n][2];

        for (int i = 0; i < n; i++) {
            tasks[i][0] = scanner.nextInt();  // 开始时间 si
            tasks[i][1] = scanner.nextInt();  // 结束时间 ei
        }

        // 贪心策略：按任务结束时间升序排序
        Arrays.sort(tasks, Comparator.comparingInt(a -> a[1]));

        int count = 0;  // 记录处理的最大任务数
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int[] task : tasks) {
            for (int day = task[0]; day <= task[1]; day++) {
                queue.add(day);
            }
            if (!queue.isEmpty()) {
                int currentDay = queue.poll();
//                System.out.println("第"+currentDay+"天："+Arrays.toString(task));
                count++;
            }
        }

        System.out.println(count);

    }
}
