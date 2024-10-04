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
    // 方向数组，表示上下左右四个方向
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        rows = in.nextInt();
        cols = in.nextInt();
        // 初始化
        grid = new int[rows][cols];
        visited = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = in.nextInt();
            }
        }
        // 统计最大区域
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (!visited[i][j]) {
                    maxArea = Math.max(maxArea, dfs(i, j));
                }
            }
        }
        System.out.println(maxArea);
    }

    private static int dfs(int x, int y) {
        visited[x][y] = true;
        int area = 1;
        for (int i = 0; i < 4; i++) {
            // 移动到下一个网格
            int x1 = x + dx[i];
            int y1 = y + dy[i];
            // 相邻网格差值绝对值都小于等于1
            if (x1 >= 0 && x1 < rows
                    && (y1 >= 0 && y1 < cols)
                    && !(visited[x1][y1])
                    && Math.abs(grid[x1][y1] - grid[x][y]) <= 1) {
                area += dfs(x1, y1);
            }
        }
        return area;
    }
}
