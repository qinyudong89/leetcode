package od.base;

import java.util.LinkedHashSet;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/17 20:28
 */
public class HJ9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        char[] arr = s.toCharArray();
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        // 反向遍历
        for (int i = arr.length - 1; i >= 0; i--) {
            set.add(arr[i]);
        }
        //拼装成整数
        StringBuilder sb = new StringBuilder();
        for (Character character : set) {
            sb.append(character);
        }
        System.out.println(Integer.parseInt(sb.toString()));
    }
}
