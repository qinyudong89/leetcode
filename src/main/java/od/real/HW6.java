package od.real;


import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/24 23:27
 * 题目：篮球游戏
 * 考察：双端队列（Deque）的应用，同时涉及贪心算法和模拟
 */
public class HW6 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] pushs = in.nextLine().split(",");
        String[] pops = in.nextLine().split(",");
        in.close();

        // 验证非法输入
        if (pushs.length != pops.length) {
            System.out.println("NO");
            return;
        }

        // string to Integer
        List<Integer> pushList = new ArrayList<>(pushs.length);
        List<Integer> popList = new ArrayList<>(pops.length);
        for (String s : pushs) {
            pushList.add(Integer.parseInt(s));
        }
        for (String s : pops) {
            popList.add(Integer.parseInt(s));
        }

        int popIndex = 0;
        ArrayDeque<Integer> queue = new ArrayDeque<>(pushList.size());
        StringBuilder sb = new StringBuilder();
        for (Integer p : pushList) {
            queue.add(p);
            while (!queue.isEmpty()) {
                // 判断能否左边弹出
                if (Objects.equals(queue.peekFirst(), popList.get(popIndex))) {
                    popIndex++;
                    queue.pollFirst();
                    sb.append("L");
                }
                // 判断能否右边弹出
                else if (Objects.equals(queue.peekLast(), popList.get(popIndex))) {
                    popIndex++;
                    queue.pollLast();
                    sb.append("R");
                } else {
                    break;
                }
            }
        }
        if (sb.length() == popIndex) {
            System.out.println(sb);
        } else {
            System.out.println("NO");
        }
    }
}
