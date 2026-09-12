class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Arrays.sort(deck);
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<deck.length;i++){
            q.add(i);
        }
        int[] ans=new int[deck.length];
        for(int x:deck){
            ans[q.remove()]=x;
        
        if(!q.isEmpty()){
            q.add(q.remove());
        }
        }
        return ans;
    }
}