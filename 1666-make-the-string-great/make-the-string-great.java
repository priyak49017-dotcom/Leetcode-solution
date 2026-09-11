class Solution {
    public String makeGood(String s) {
        Stack<Character>st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(st.isEmpty()){
                st.push(ch);
            }
            else if( !st.isEmpty() && Character.toLowerCase(ch) == Character.toLowerCase(st.peek()) && st.peek() != ch ){
                st.pop();
            }else{
                st.push(ch);
            }
        }
        StringBuilder sb=new StringBuilder();
        for(char ch:st){
            sb.append(ch);
        }
        return sb.toString();
        
    }
}