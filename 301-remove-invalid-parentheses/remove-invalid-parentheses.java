class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String>ans=new ArrayList<>();
        Queue<String>q=new LinkedList<>();
        Set<String>visited=new HashSet<>();
        q.add(s);
        visited.add(s);
        boolean found=false;
        while(!q.isEmpty()){
            String curr=q.poll();
            if(isValid(curr)){
                ans.add(curr);
                found=true;
            }
            if(found){
                continue;
            }
            for(int i=0;i<curr.length();i++){
                if(curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String next=curr.substring(0,i)+curr.substring(i+1);
                if(!visited.contains(next)){
                    visited.add(next);
                    q.offer(next);
                }
            }
        }
        return ans;
        
    }
    private boolean isValid(String curr){
        int count=0;
        for(char c:curr.toCharArray()){
            if(c == '(') count++;
            else if(c == ')') count--;

            if(count < 0) return false;
        }
        return count==0;
    }
}