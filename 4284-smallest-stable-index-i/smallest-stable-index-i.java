class Solution {
    public int firstStableIndex(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            int maxLeft = nums[0];
            int minRight = nums[i];

            for (int j = 0; j <= i; j++) {
                maxLeft = Math.max(maxLeft, nums[j]);
            }

            for (int j = i; j < nums.length; j++) {
                minRight = Math.min(minRight, nums[j]);
            }

            if (maxLeft - minRight <= k) {
                return i;
            }
        }

        return -1;
    }
}