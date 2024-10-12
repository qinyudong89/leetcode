package od.e24;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/12 14:01
 * @Description :boss的收入
 *
 */
public class E2 {
    static List<List<Integer>> graph;  // 邻接表，用于存储分销网络

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        final int MAX = (int) 1e6 + 5;  // 假设最多存在 100 万个分销节点
        graph = new ArrayList<>();      // 初始化邻接表

        for (int i = 0; i < MAX; i++) {
            graph.add(new ArrayList<>());  // 初始化每个节点的邻接链表
        }

        int[] income = new int[MAX];   // 每个节点的收入
        int[] indegree = new int[MAX]; // 入度数组，记录每个节点有多少下级
        int m = in.nextInt();          // 输入分销关系的数量
        int n = 0;                     // 记录节点的最大值

        // 读取分销关系和收入
        for (int i = 0; i < m; i++) {
            int sub = in.nextInt();      // 下级分销 ID
            int boss = in.nextInt();     // 上级分销 ID
            int revenue = in.nextInt();  // 下级的收入

            graph.get(sub).add(boss);    // 下级分销指向上级
            indegree[boss]++;            // 上级的入度增加
            income[sub] += revenue;      // 记录下级的收入

            n = Math.max(n, Math.max(sub, boss));  // 更新节点数量范围
        }

        // 队列，用于存储入度为 0 的节点（无下级的节点）
        Queue<Integer> queue = new LinkedList<>();

        // 找到所有入度为 0 的节点，加入队列
        for (int i = 0; i <= n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // 拓扑排序，处理收入的分发
        while (!queue.isEmpty()) {
            int sub = queue.poll();  // 取出入度为 0 的节点
            for (int boss : graph.get(sub)) {
                // 将下级的 15% 收入上交给上级
                income[boss] += income[sub] / 100 * 15;

                // 减少上级的入度
                indegree[boss]--;

                // 如果上级的入度变为 0，加入队列
                if (indegree[boss] == 0) {
                    queue.add(boss);
                }
            }

            // 如果队列为空，则当前节点为 Boss，输出其收入
            if (queue.isEmpty()) {
                System.out.println(sub + " " + income[sub]);
            }
        }
    }
}
