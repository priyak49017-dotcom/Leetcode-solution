class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer>pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int pils:piles){
            pq.add(pils);
        }
        while(k > 0){
            int x=pq.poll();
            x=x-x/2;
            pq.add(x);
            k--;
        }
        int sum=0;
        for(int stones:pq){
            sum += stones;
        }
        return sum;
        
    }
}