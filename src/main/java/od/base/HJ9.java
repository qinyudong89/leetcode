package od.base;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/17 20:28
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = new StringBuilder(in.nextLine()).reverse().toString();
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            /**
             * 这个解法的精髓在：s.indexOf(s.charAt(i)) == i
             * 1、indexOf方法只返回第一次查找到的字符下标，
             * 2、随着for循环的i值不断增长，如果字符都是新的，与之前出现的字符不重复，那么判断条件一直成立；
             * 3、一旦中间有重复字符，由于indexOf返回的是第一次该字符出现的地方，导致判断条件不成立，不会被append结果中去
             */
            if (s.indexOf(s.charAt(i)) == i) {
                b.append(s.charAt(i));
            }
        }
        System.out.print(Integer.parseInt(b.toString()));
    }
}
