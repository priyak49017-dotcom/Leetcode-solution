class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] req : prerequisites) {
            list.get(req[1]).add(req[0]);
        }

        boolean[] visi = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        int[] order = new int[numCourses];
        int[] index = {0};

        for (int i = 0; i < numCourses; i++) {
            if (!visi[i]) {
                if (isCycle(i, list, visi, path, order, index)) {
                    return new int[0];
                }
            }
        }

  
        for (int left = 0, right = numCourses - 1; left < right; left++, right--) {
            int temp = order[left];
            order[left] = order[right];
            order[right] = temp;
        }

        return order;
    }

    boolean isCycle(int start, ArrayList<ArrayList<Integer>> graph,
                    boolean[] visi, boolean[] path,
                    int[] order, int[] index) {

        visi[start] = true;
        path[start] = true;

        for (int nei : graph.get(start)) {
            if (!visi[nei]) {
                if (isCycle(nei, graph, visi, path, order, index)) {
                    return true;
                }
            } else if (path[nei]) {
                return true;
            }
        }

        path[start] = false;
        order[index[0]++] = start;

        return false;
    }
}