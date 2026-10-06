class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] req : prerequisites) {
            list.get(req[1]).add(req[0]);
        }

        boolean[] visi = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];

        for(int i = 0; i < numCourses; i++) {
            if(!visi[i]) {
                if(isCycle(i, list, visi, path)) {
                    return false;
                }
            }
        }

        return true;
    }

    boolean isCycle(int start, ArrayList<ArrayList<Integer>> graph,
                    boolean[] visi, boolean[] path) {

        visi[start] = true;
        path[start] = true;

        for(int nei : graph.get(start)) {

            if(!visi[nei]) {

                if(isCycle(nei, graph, visi, path)) {
                    return true;
                }

            } else if(path[nei]) {
                return true;
            }
        }

        path[start] = false;

        return false;
    }
}