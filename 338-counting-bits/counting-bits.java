class Solution {
    public int[] countBits(int n) {
        int[]bit=new int[n+1];
        for(int i=1;i<=n;i++){
            bit[i]=bit[i/2]+(i%2);
        }
        return bit;
        
    }
}