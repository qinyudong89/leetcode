package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/17 10:30
 */
public class HJ6 {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String str = in.readLine();
        long num = Long.parseLong(str);
        long k = (long) Math.sqrt(num);
        StringBuilder sb = new StringBuilder();
        for (long i = 2; i <= k; i++) {
            if (num % i == 0) {
                sb.append(i).append(" ");
//                System.out.println(i + " ");
                num = num / i;
                i--;
            }
        }
        sb.append(num == 1 ? " " : num+" ");
//        System.out.println(num == 1 ? " " : num + " ");
        System.out.println(sb);
    }
}
