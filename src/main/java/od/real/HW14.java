package od.real;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/3 13:48
 * 题目：跳房子
 *
 */
public class HW14 {

    public static void main(String[] args) {
        // 读取输入
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();
        int target = scanner.nextInt();

        // 解析输入的数组，去掉方括号和逗号
        String[] inputArray = input.substring(1, input.length() - 1).split(",");
        int[] steps = new int[inputArray.length];

        for (int i = 0; i < inputArray.length; i++) {
            steps[i] = Integer.parseInt(inputArray[i].trim());
        }

        int[] result = new int[2];
        // 初始化最小索引和为最大值
        int minIndexSum = Integer.MAX_VALUE;
        // 哈希表存储步数和它的索引
        Map<Integer, Integer> map = new HashMap<>();
        // 遍历步数数组
        for (int i = 0; i < steps.length; i++) {
            int step = steps[i];
            map.put(step, i);
            // 需要找到的配对数
            int num = target - step;
            if (map.containsKey(num)) {
                int j = map.get(num);
                int currIndexSum = i + j;
                // 若有多种组合满足两回合跳进，返回索引和最小的
                if (currIndexSum < minIndexSum) {
                    // 计算索引和
                    minIndexSum = currIndexSum;
                    result[0] = num;
                    result[1] = step;
                }
            }
        }

        System.out.println(Arrays.toString(result));
    }
}
