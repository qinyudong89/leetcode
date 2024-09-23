package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description 解题思路
 * 1.读取输入字符串：从控制台读取输入字符串。
 * 2.分割坐标字符串：使用 split(";") 方法将输入字符串分割成多个坐标字符串。
 * 3.检查坐标合法性：使用正则表达式 Pattern 和 Matcher 检查坐标字符串是否合法。
 * 4.更新坐标位置：对于每个合法的坐标字符串，提取方向和距离，并更新当前位置。
 * 5.输出最终结果：将最终位置坐标写入输出文件。
 * @date 2024/9/18 11:43:11
 */
public class HJ17 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = bf.readLine().split(";");
        int x = 0;
        int y = 0;
        for (String s:arr){
            // 只能以 A、D、W、S 开头，后面跟 1 到 2 位数字
            if (!(s.matches("^[ADWS]\\d{1,2}$"))){
                continue;
            }
            char c0 = s.charAt(0);
            int num = Integer.parseInt(s.substring(1));
            switch (c0){
                case 'A':
                    x -= num;
                    break;
                case 'D':
                    x += num;
                    break;
                case 'W':
                    y += num;
                    break;
                case 'S':
                    y -= num;
                    break;
            }
        }
        System.out.println(x + "," + y);
    }
}
