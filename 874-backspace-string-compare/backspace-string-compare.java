class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character>a=new Stack<>();
        Stack<Character>b=new Stack<>();
        for(char ch:s.toCharArray()){
            if(!a.isEmpty() && ch == '#'){
                a.pop();
            }
            else if(ch != '#'){
                a.push(ch);
            }
        }
        for(char ch:t.toCharArray()){
            if(!b.isEmpty() && ch == '#'){
                b.pop();
            }
            else if(ch != '#'){
                b.push(ch);
            }
        }
        return a.equals(b);
        
    }
}