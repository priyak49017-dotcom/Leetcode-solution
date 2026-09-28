class Solution {
    public boolean isPalindrome(int x) {
        int original=x;
        int rev=0;
        while(x > 0){
            int dig=x%10;
            rev =rev*10 + dig;
            x=x/10;
        }if(original == rev){
            return true;
        }
        return false;
        
        
        
        
    }
}