class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer>climbs=new PriorityQueue<>();
        for(int i=0;i<heights.length-1;i++){
            int climb=heights[i+1]-heights[i];

        
        if(climb < 0){
            continue;
        }
        climbs.offer(climb);//5 it use ladder to claim
        if(climbs.size() > ladders){//2nd cliaim occurs
            bricks -= climbs.poll();
        }
        if(bricks < 0){
            return i;
        }
        }
        return heights.length-1;
        
    }
}