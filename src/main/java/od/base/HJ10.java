package od.base;

import java.util.BitSet;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/17 21:33
 */
public class HJ10 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        // BitSet 底层数据结构采用位图，可以快速判断一个字符是否出现过
        BitSet bs = new BitSet(128);
        for (char c : s.toCharArray()) {
            // 不存在则设置为true
            if (!bs.get(c)) {
                bs.set(c);
            }
        }
        System.out.println(bs.cardinality());
    }
}
