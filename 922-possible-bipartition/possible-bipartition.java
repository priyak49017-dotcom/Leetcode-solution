import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        // Build an adjacency list. People are numbered from 1 to n.
        int[][] graph = new int[n + 1][n + 1];
        for (int[] dislike : dislikes) {
            graph[dislike[0]][dislike[1]] = 1;
            graph[dislike[1]][dislike[0]] = 1;
        }

        int[] color = new int[n + 1]; // 0 = uncolored, 1 or -1 = groups

        for (int start = 1; start <= n; start++) {
            if (color[start] != 0) {
                continue;
            }

            Queue<Integer> q = new LinkedList<>();
            q.add(start);
            color[start] = 1;

            while (!q.isEmpty()) {
                int person = q.poll();

                for (int other = 1; other <= n; other++) {
                    if (graph[person][other] == 0) {
                        continue;
                    }

                    if (color[other] == 0) {
                        color[other] = -color[person];
                        q.add(other);
                    } else if (color[other] == color[person]) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}