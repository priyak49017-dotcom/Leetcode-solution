import java.util.PriorityQueue;

class Solution {
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int num : nums) {
            pq.add(num);
        }

        while (k > 0) {
            int x=pq.poll();
            x += 1;
            pq.add(x);
            
            k--;
        }

        long product = 1;
        int mod = 1_000_000_007;

        while (!pq.isEmpty()) {
            product = (product * pq.poll()) % mod;
        }

        return (int) product;
    }
}