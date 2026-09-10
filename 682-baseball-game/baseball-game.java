class Solution {
    public int calPoints(String[] str) {
        Stack<Integer>st=new Stack<>();
        for(int i=0;i<str.length;i++){
            if(str[i].equals("D")){
                st.push(st.peek()*2);
            }else if(str[i].equals("C")){
                st.pop();
            }else if(str[i].equals("+")){
                int val=st.peek()+st.get(st.size()-2);
                st.push(val);
            }else{
                st.push(Integer.parseInt(str[i]));
            }
        }
        int sum=0;
        while(!st.isEmpty()){
            sum+=st.pop();
        }
        return sum;
    }

        
}