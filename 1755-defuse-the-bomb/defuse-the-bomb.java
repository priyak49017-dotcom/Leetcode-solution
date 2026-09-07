class Solution {
    public int[] decrypt(int[] arr, int k) {
        int size = arr.length;
        int[] res = new int[size];
        if(k == 0){
            return res;
        }
        if(k>0){
            int sum = 0;
            for(int ind=1;ind<=k;ind++){
                sum += arr[(ind+size)%size];
            }
            for(int ind=0;ind<size;ind++){ // 0
                res[ind] = sum; // 12
                sum -= arr[(ind+1)%size];  
                sum += arr[(ind+k+1)%size]; 
	         }
        }
        else{
            k = -k;
            int sum = 0;
            for(int ind=1;ind<=k;ind++){
                sum += arr[(size-ind)%size];
            }
            for(int ind=0;ind<size;ind++){ // 0
                res[ind] = sum; // 12
                sum -= arr[(ind-k+size)%size];  
                sum += arr[ind]; 
	         }
        }

        return res;
    }
}