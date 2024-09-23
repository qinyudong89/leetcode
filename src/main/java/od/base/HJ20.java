package od.base;

import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 15:21:59
 */
public class HJ20 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        while (in.hasNext()) {
            String pwd = in.next();
            // 长度判断
            if (pwd.length() < 8) {
                System.out.println("NG");
                continue;
            }
            // 类型判断（大小写字母.数字.其它符号）
            if (isValidType(pwd)) {
                System.out.println("NG");
                continue;
            }
            // 子串重复判断
            if (isRepeat(pwd, 0, 3)) {
                System.out.println("NG");
                continue;
            }
            System.out.println("OK");
        }
    }

    private static boolean isRepeat(String pwd, int l, int r) {
        if (r >= pwd.length()) {
            return false;
        }
        // pwd.substring(r) 与 pwd.substring(l, r) 有叠则算存在重复子串
        if (pwd.substring(r).contains(pwd.substring(l, r))) {
            return true;
        } else {
            return isRepeat(pwd, l + 1, r + 1);
        }
    }

    /**
     * 不符合类型则返回true
     *
     * @param pwd
     * @return
     */
    private static boolean isValidType(String pwd) {
        int count = 0;
        //大写
        if (Pattern.compile("[A-Z]").matcher(pwd).find()) {
            count++;
        }
        // 小写
        if (Pattern.compile("[a-z]").matcher(pwd).find()) {
            count++;
        }
        // 数字
        if (Pattern.compile("[0-9]").matcher(pwd).find()) {
            count++;
        }
        // 其它
        if (Pattern.compile("[^a-zA-Z0-9]").matcher(pwd).find()) {
            count++;
        }
        return count < 3;
    }

}
