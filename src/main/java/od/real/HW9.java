package od.real;

import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeSet;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/29 17:30
 * 题目：寻找密码
 * 考察：
 */
public class HW9 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] strs = in.nextLine().split(" ");
        TreeSet<String> pwds = new TreeSet<>(Arrays.asList(strs));

        String maxPwd = "";
        for (String pwd : strs) {
            boolean valid = true;
            String tmpPwd = pwd;
            while (!tmpPwd.isEmpty()) {
                if (!pwds.contains(tmpPwd)) {
                    valid = false;
                    break;
                }
                // 截取末尾字符
                tmpPwd = tmpPwd.substring(0, tmpPwd.length() - 1);
            }
            // 多个符合要求的密码，则返回字典序最大的密码
            if (valid && pwd.compareTo(maxPwd) > 0) {
                maxPwd = pwd;
            }
        }
        System.out.println(maxPwd);
    }
}
