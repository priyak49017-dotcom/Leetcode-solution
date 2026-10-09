class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length;
        boolean[]visi=new boolean[n];
        PriorityQueue<int[]>pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.add(new int[]{0,0});
        int MC=0;
        int count=0;while(!pq.isEmpty() && count < n){
            int[]curr=pq.poll();
            int x=curr[0];
            int cost=curr[1];
            if(!visi[x]){
                visi[x]=true;
                MC += cost;
                count++;
                for(int y=0;y<n;y++){
                    if(!visi[y]){
                        int dis=Math.abs(points[x][0]-points[y][0]) + Math.abs(points[x][1]-points[y][1]);
                        pq.add(new int[]{y,dis});

                    }
                }
                
            }
            
        }
        return MC;

        
    }
}