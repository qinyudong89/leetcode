package od.base;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/16 8:20
 */

import java.util.Scanner;

public class HJ {
    public static int lengthOfLastWord(String str) {
        if (str == null || str.isEmpty()) {
            return 0;
        }
        String[] words = str.split(" ");
        if (words.length == 0) {
            return 0;
        }
        String endWord = words[words.length - 1];
        return endWord.length();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(lengthOfLastWord(str));
    }
}
