class Solution {
    public double maxProbability(int n, int[][] edges,double[] succProb,int start_node,int end_node) {

        ArrayList<double[]>[] graph = new ArrayList[n];

        for(int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < edges.length; i++) {

            int u = edges[i][0];
            int v = edges[i][1];

            double probability = succProb[i];

            graph[u].add(new double[]{v, probability});
            graph[v].add(new double[]{u, probability});
        }

        double[] prob = new double[n];

        prob[start_node] = 1.0;

        PriorityQueue<double[]> pq =new PriorityQueue<>((a,b) ->Double.compare(b[1], a[1]));

        pq.add(new double[]{start_node, 1.0});

        while(!pq.isEmpty()) {

            double[] cur = pq.remove();

            int node = (int)cur[0];
            double currentProb = cur[1];

            if(node == end_node) {
                return currentProb;
            }

            for(double[] next : graph[node]) {

                int nextNode = (int)next[0];
                double edgeProb = next[1];

                double newProb =currentProb * edgeProb;

                if(newProb > prob[nextNode]) {

                    prob[nextNode] = newProb;

                    pq.add(new double[]{nextNode,newProb});
                }
            }
        }

        return 0.0;
    }
}