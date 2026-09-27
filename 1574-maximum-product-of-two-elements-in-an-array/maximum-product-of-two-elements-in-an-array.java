class Solution {
    public int maxProduct(int[] nums) {
        PriorityQueue<Integer>heap=new PriorityQueue<>((a,b)->b-a);
        for(int num:nums){
            heap.add(num);
        }
        int first=heap.poll();
        int second=heap.poll();
        int c=(first-1)*(second-1);
        return c;
        
        
    }
}