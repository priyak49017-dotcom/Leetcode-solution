class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>frequency=new HashMap<>();
        for(int num:nums){
            frequency.put(num,frequency.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer>heap=new PriorityQueue<>((a,b)->frequency.get(b)-frequency.get(a));
        heap.addAll(frequency.keySet());
        
        
        
        int[] result=new int[k];
        for(int i=0;i<k;i++){
            result[i]=heap.poll();
        }
        return result;
        
    }
}