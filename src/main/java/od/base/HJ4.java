package od.base;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/16 17:06
 */
public class HJ4 {
    public static void main(String[] args) {
        // 获取控制台输入的数据
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            split(in.nextLine());
        }
    }

    public static void split(String str) {
        // 长度>8则截取
        while (str.length() >= 8) {
            // 先以8位作为一段,进行截取
            System.out.println(str.substring(0, 8));
            // 剩余字符串长度，再重复上述操作
            str = str.substring(8);
        }
        // 长度>0 且小于8，则后而补0
        if (!str.isEmpty()) {
            // 08d表示会以最小八位的方式显示数字，如果数字不足八位，则在前面补零
            str = String.format("%s%08d", str, 0);
            System.out.println(str.substring(0, 8));
        }
    }
}
