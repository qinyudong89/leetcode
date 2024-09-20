package od.base;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/9/20 8:09
 */
public class HJ35 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNextInt()){
            int n = in.nextInt();    //读入正整数n

            int[][] result = new int[n][];    //建立数组（n行）
            int t = 1;    //记录依次赋予的数组值
            for(int i=0; i < n; i++){
                result[i] = new int[n-i];    //数组第i行有n-i个元素
                for(int j=0; j < i+1; j++){    //对第i个对角线赋值
                    result[i-j][j] = t;
                    t++;
                }
            }

            //输出数组值
            for(int[] a : result){
                for(int a1 : a)
                    System.out.print(a1 + " ");
                System.out.println();
            }
        }
    }
}
