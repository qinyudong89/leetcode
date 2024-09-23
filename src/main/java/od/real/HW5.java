package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/23 23:57
 * 题目：文本统计分析
 * 考察：对字符串解析的细致理解和处理复杂条件的能力
 */
public class HW5 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (in.hasNextLine()) {
            String s = in.nextLine();
            if (s.isEmpty()) {
                break;
            }
            sb.append(s).append("\n");
        }
        String text = sb.toString();
        // 单引号
        boolean isSigleQuote = false;
        // 双引号
        boolean isDoubleQuote = false;
        // 注释
        boolean isComment = false;
        // 文本数量
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            // 注释以换行结束
            if (isComment) {
                if (c == '\n') {
                    isComment = false;
                }
            }
            // 判断是不是双引号
            if (c == '"' && !isSigleQuote) {
                isDoubleQuote = !isDoubleQuote;
            } else if (c == '\'' && !isDoubleQuote) {
                isSigleQuote = !isSigleQuote;
            }

            // 判断是不是注释
            if (!isSigleQuote && !isDoubleQuote &&
                    c == '-' && i + 1 < text.length() && text.charAt(i + 1) == '-') {
                isComment = true;
                continue;
            }
            // 判断是不是;号
            if (!isSigleQuote && !isDoubleQuote && c == ';') {
                if (!isNotEmpty(sb.toString())) {
                    count++;
                }
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        // 检查最后一条语句（可能没有分号结尾）
        if (!isNotEmpty(sb.toString())) {
            count++;
        }
        System.out.println(count);

    }

    public static boolean isNotEmpty(String stement) {
        return !stement.trim().isEmpty();
    }
}


