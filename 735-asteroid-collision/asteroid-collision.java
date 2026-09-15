class Solution {
    public int[] asteroidCollision(int[] arr) {
        Stack<Integer>st=new Stack<>();
        st.push(arr[0]);
        for(int i=1;i<arr.length;i++){
            if(arr[i] > 0 ){
                st.push(arr[i]);
            }else if(arr[i] <0){
                while(!st.isEmpty() && st.peek()>0 && st.peek() < -arr[i]){
                    st.pop();
                }
                if(!st.isEmpty() && st.peek()>0 && st.peek() == -arr[i]){
                    st.pop();
                }else if(st.isEmpty() || st.peek()<0){
                    st.push(arr[i]);
                }
            }
        }
        int res[]=new int[st.size()];
        for(int ind=0;ind<st.size();ind++){
            res[ind]=st.get(ind);
        }
        return res;


        
        
    }
}