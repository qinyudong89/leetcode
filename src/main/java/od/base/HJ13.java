package od.base;

import java.util.Scanner;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 09:57:03
 */
public class HJ13 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String s = in.nextLine();
            String[] arr = s.split(" ");
            for (int i = arr.length - 1; i >= 0; i--) {
                if (i != 0){
                    System.out.print(arr[i]+" ");
                }else {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}
