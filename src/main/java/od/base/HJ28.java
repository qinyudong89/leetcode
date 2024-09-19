package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/19 21:57
 */
public class HJ28 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        // StringTokenizer可以帮助我们轻松地分割字符串，而不需要手动处理分隔符
        StringTokenizer st = new StringTokenizer(bf.readLine());
        // 奇偶数分组
        List<Integer> odds = new ArrayList<>(n);
        List<Integer> evens = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if (num % 2 == 1) {
                odds.add(num);
            } else {
                evens.add(num);
            }
        }

        int count = 0;
        int[] matchEvens = new int[evens.size()];
        //求最大匹配数
        for (int i = 0; i < odds.size(); i++) {
            boolean[] bools = new boolean[evens.size()];
            if (huangyuli(odds.get(i), matchEvens, evens, bools)) {
                count++;
            }
        }
        System.out.println(count);
    }

    // 匈牙利算法
    private static boolean huangyuli(int n, int[] matchEvens, List<Integer> evens, boolean[] bools) {
        for (int i = 0; i < evens.size(); i++) {
            //该位置偶数没被访问过，并且能与n组成素数伴侣
            if (!(bools[i]) && isPrime(n + evens.get(i))) {
                bools[i] = true;
                // 如果偶数下标i的元素还没有配对过，则与n配对；否则继续尝试下一个偶数，如果下一个还能配上，则继续尝试下一个偶数
                if (matchEvens[i] == 0 || huangyuli(matchEvens[i], matchEvens, evens, bools)) {
                    matchEvens[i] = n;
                    return true;
                }
            }
        }
        return false;
    }

    // 素数质数
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        /**
         * 只需检查奇数因子即可，因为所有偶数因子已经被排除。
         * 循环从3开始，每次递增2，这样可以跳过所有的偶数
         */
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i <= sqrt; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
