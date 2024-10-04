package od.real;

import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/4 8:22
 */
public class HW15 {

    private static int[][] grid;
    private static boolean[][] visited;
    private static int rows, cols;
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 输入行列数
        rows = sc.nextInt();
        cols = sc.nextInt();

        grid = new int[rows][cols];
        visited = new boolean[rows][cols];

        // 输入网格数值
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int maxArea = 0;

        // 遍历网格，寻找最大连通区域
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }

        System.out.println(maxArea);
    }

    // 深度优先搜索，计算连通区域大小
    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;  // 当前格子计为1

        // 上下左右四个方向
        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols
                    && !visited[newX][newY]
                    && Math.abs(grid[newX][newY] - grid[x][y]) <= 1) {
                area += dfs(newX, newY);
            }
        }

        return area;  // 返回该区域的总大小
    }
}
