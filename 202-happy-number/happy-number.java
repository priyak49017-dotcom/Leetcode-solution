class Solution {
    public boolean isHappy(int n) {
        int slow=n;
        int fast=n;
        do{
            slow=sumOfSquare(slow);
            fast=sumOfSquare(sumOfSquare(fast));
        }while(slow != fast);
        return slow==1;


        
                
        
    }
    public int sumOfSquare(int n){
        int sum=0;
        while(n > 0){
            int dig=n%10;
            sum += dig*dig;
            n=n/10;
        }
        return sum;
    }
}