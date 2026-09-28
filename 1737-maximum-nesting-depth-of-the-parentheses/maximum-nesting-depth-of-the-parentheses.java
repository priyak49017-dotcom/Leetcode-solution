class Solution {
    public int maxDepth(String s) {
        int count=0;
        int max=0;
        for(char ch=0;ch < s.length();ch++){
            if(s.charAt(ch) == '('){
                count++;
                max=Math.max(max,count);


            }else if(s.charAt(ch) == ')'){
                count--;
            }

        }
        return max;
        
    }
}