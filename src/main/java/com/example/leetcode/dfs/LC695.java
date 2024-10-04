package com.example.leetcode.dfs;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/4 13:29
 */
public class LC695 {
    public int maxAreaOfIsland(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0) {
            return 0;
        }

        int area = 0;
        grid[x][y] = 1;
        area += dfs(grid, x - 1, y);
        area += dfs(grid, x + 1, y);
        area += dfs(grid, x, y - 1);
        area += dfs(grid, x, y + 1);
        return area;
    }
}
