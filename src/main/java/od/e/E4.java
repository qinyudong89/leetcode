package od.e;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/11 8:03
 * @Description :跳马
 */
public class E4 {

    private static final int[][] DIRS = {{1, 2}, {1, -2}, {2, 1}, {2, -1}, {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        sc.nextLine();

        char[][] board = new char[m][n];
        List<int[]> horses = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            board[i] = sc.nextLine().toCharArray();
            for (int j = 0; j < n; j++) {
                if (board[i][j] != '.') horses.add(new int[]{i, j, board[i][j] - '0'});
            }
        }

        if (horses.size() == 1) {
            System.out.println(0);
            return;
        }

        int minSteps = Integer.MAX_VALUE;
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < n; y++) {
                int totalSteps = 0;
                boolean canReach = true;
                for (int[] horse : horses) {
                    int steps = bfs(board, m, n, horse[0], horse[1], x, y, horse[2]);
                    if (steps == -1) {
                        canReach = false;
                        break;
                    }
                    totalSteps += steps;
                }
                if (canReach) minSteps = Math.min(minSteps, totalSteps);
            }
        }
        System.out.println(minSteps == Integer.MAX_VALUE ? -1 : minSteps);
    }

    private static int bfs(char[][] board, int m, int n, int sx, int sy, int ex, int ey, int k) {
        if (sx == ex && sy == ey) return 0;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{sx, sy, 0});
        visited[sx][sy] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], steps = cur[2];
            for (int[] dir : DIRS) {
                for (int step = 1; step <= k; step++) {
                    int nx = x + dir[0] * step, ny = y + dir[1] * step;
                    if (nx >= 0 && ny >= 0 && nx < m && ny < n && !visited[nx][ny]) {
                        if (nx == ex && ny == ey) return steps + 1;
                        queue.offer(new int[]{nx, ny, steps + 1});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
        return -1;
    }
}

