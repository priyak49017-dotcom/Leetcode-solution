class Solution {
    public List<Boolean> checkIfPrerequisite(
        int numCourses,
        int[][] prerequisites,
        int[][] queries) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        for(int i = 0; i < numCourses; i++) {
            list.add(new ArrayList<>());
        }

        for(int[] p : prerequisites) {
            list.get(p[0]).add(p[1]);
        }

        boolean[][] reach = new boolean[numCourses][numCourses];

        for(int i = 0; i < numCourses; i++) {
            dfs(i, i, list, reach);
        }

        List<Boolean> ans = new ArrayList<>();

        for(int[] q : queries) {
            ans.add(reach[q[0]][q[1]]);
        }

        return ans;
    }

    void dfs(int src, int current,ArrayList<ArrayList<Integer>> list,boolean[][] reach) {

        for(int nei : list.get(current)) {

            if(!reach[src][nei]) {
                reach[src][nei] = true;
                dfs(src, nei, list, reach);
            }
        }
    }
}