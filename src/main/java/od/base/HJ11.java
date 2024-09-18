package od.base;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/18 8:16
 */
public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        for (int i = s.length() - 1; i >= 0; i--) {
            System.out.print(Integer.parseInt(s.charAt(i) + ""));
        }
    }
}
