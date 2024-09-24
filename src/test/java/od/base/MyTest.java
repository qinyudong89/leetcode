package od.base;

import java.util.Arrays;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 14:09:24
 */
public class MyTest {
    public static void main(String[] args) {
        String password = "021Abc9Abc1";
//        System.out.println(password.substring(0,3));
        // 检查是否有长度大于2的重复子串
        ;
        System.out.println(getString(password, 0, 3));
    }
    private static boolean getString(String str, int l, int r) {
        if (r >= str.length()) {
            return false;
        }
        System.out.println(str.substring(r) + " | "+str.substring(l, r));
        if (str.substring(r).contains(str.substring(l, r))) {
            return true;
        } else {
            return getString(str,l+1,r+1);
        }
    }
}
