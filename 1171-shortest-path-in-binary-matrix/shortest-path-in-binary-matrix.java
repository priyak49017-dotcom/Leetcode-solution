

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) {
            return -1;
        }

        int[][] dist = new int[n][n];
        Queue<int[]> q = new LinkedList<>();

        q.add(new int[]{0, 0});
        dist[0][0] = 1; 

        int[][] directions = {{-1, -1},{-1, 0},{-1, 1},{0, -1}, {0, 1},{1, -1},{1, 0},{1, 1}};
         while (!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            if (row == n - 1 && col == n - 1) {
                return dist[row][col];
            }
            for (int[] dir : directions) {
                int r = row + dir[0];
                int c = col + dir[1];
                if (r >= 0 && r < n && c >= 0 && c < n&& grid[r][c] == 0 && dist[r][c] == 0) {
                    dist[r][c] = dist[row][col] + 1;
                    q.add(new int[]{r, c});
                }
            }
        }

        return -1;
    }
}