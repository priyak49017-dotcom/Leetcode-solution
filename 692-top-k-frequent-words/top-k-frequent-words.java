class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer>frequency=new HashMap<>();
        for(String word:words){
            frequency.put(word,frequency.getOrDefault(word,0)+1);
        }
        PriorityQueue<String>heap=new PriorityQueue<>((a,b)->{if(!frequency.get(a).equals(frequency.get(b))){
            return frequency.get(b)-frequency.get(a);
        }
        return a.compareTo(b);
        });
        heap.addAll(frequency.keySet());
        List<String>result=new ArrayList<>();
        for(int i=0;i<k;i++){
            result.add(heap.poll());
        }
        return result;
        
    }
}