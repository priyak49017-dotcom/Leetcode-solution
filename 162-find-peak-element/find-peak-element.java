class Solution {
    public int findPeakElement(int[] nums) {
        int target=nums[0];
        int max=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i] > target){
                target=nums[i];
                max=i;


            }
        }
        return max;
        
        
    }
}