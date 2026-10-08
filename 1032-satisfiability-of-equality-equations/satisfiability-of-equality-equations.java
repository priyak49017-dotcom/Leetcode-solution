class Solution {
    int[] par;
    void Union(int val1,int val2){
        int x=find(val1);
        int y=find(val2);
        if(x == y){
            return;
        }
        par[y]=x;
    }
    int find(int val){
        if(par[val] == val){//a==a
            return val;
        }
        return find(par[val]);
    }
    public boolean equationsPossible(String[] equations) {
        par=new int[26];
        for(int i=0;i<26;i++){
            par[i]=i;
        }
        for(int i=0;i<equations.length;i++){
            int val1=equations[i].charAt(0)-'a';
            int val2=equations[i].charAt(3)-'a';
            if(equations[i].charAt(1)=='='){
                Union(val1,val2);
            }
        }
        for(int i=0;i<equations.length;i++){
            int val1=equations[i].charAt(0)-'a';
            int val2=equations[i].charAt(3)-'a';
            if(equations[i].charAt(1)=='!'){
                if(find(val1) == find(val2)){
                    return false;
                }
            }
        }
        return true;
    }
}