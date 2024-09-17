package od.base;

import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/16 16:31
 */
public class HJ3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 接收数据
        int num = in.nextInt();
        // 利用TreeSet,去重、有序的特性
        Set<Integer> set = new TreeSet<>();
        for (int i = 0; i < num; i++) {
            set.add(in.nextInt());
        }
        for (Integer integer : set) {
            System.out.println(integer);
        }

    }
}
