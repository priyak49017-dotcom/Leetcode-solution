class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        PriorityQueue<Integer>heap=new PriorityQueue<>((a,b) ->{
            int SoldierA=countSoldier(mat[a]);
            int SoldierB=countSoldier(mat[b]);
            if(SoldierA != SoldierB){
                return SoldierA-SoldierB;
            }
            return a-b;
        });
        for(int i=0;i<mat.length;i++){
            heap.add(i);
        }
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;
                
    }
    private int countSoldier(int[] row){
        int count=0;
        for(int num : row){
            count += num;
        }
        return count;
    }
}