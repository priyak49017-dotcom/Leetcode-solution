class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                provinces++;
                dfs(city, isConnected, visited);
            }
        }

        return provinces;
    }

    private void dfs(int city, int[][] graph, boolean[] visited) {
        visited[city] = true;

        for (int neighbor = 0; neighbor < graph.length; neighbor++) {
            if (graph[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(neighbor, graph, visited);
            }
        }
    }
}