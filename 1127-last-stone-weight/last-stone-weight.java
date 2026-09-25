class Solution {
    PriorityQueue<Integer>heap=new PriorityQueue<>(Collections.reverseOrder());
    public int lastStoneWeight(int[] stones) {
        for(int stone : stones){
            heap.add(stone);

        }
        while(heap.size() > 1){
            int first=heap.poll();
            int second=heap.poll();
            if(first != second){
                heap.add((first-second));
            }
        
            if(heap.size() == 0){
                return 0;
            }
        }
        return heap.remove();

        
    }
}