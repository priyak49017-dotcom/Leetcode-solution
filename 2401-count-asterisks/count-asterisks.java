class Solution {
    public int countAsterisks(String s) {
        
        int count=0;
        boolean box=false;
        for(char ch:s.toCharArray()){
            if(ch == '|'){
                box=!box;
            }else if(ch == '*' && !box){
                count++;
            }
        }
        return count;
    }
}