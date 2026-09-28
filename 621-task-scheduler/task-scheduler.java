import java.util.*;

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        for (char task : tasks) {
            freq[task - 'A']++;
        }

        PriorityQueue<Integer> pq =
                new PriorityQueue<>((a, b) -> b - a);

        for (int count : freq) {
            if (count > 0) {
                pq.offer(count);
            }
        }

        int minTime = 0;

        while (!pq.isEmpty()) {
            int round = n + 1;
            List<Integer> remainingCounts = new ArrayList<>();

            while (round > 0 && !pq.isEmpty()) {
                int current = pq.poll() - 1;

                if (current > 0) {
                    remainingCounts.add(current);
                }

                round--;
                minTime++;
            }

            for (int count : remainingCounts) {
                pq.offer(count);
            }

            // If tasks remain, the unused slots in this round are idle time.
            if (!pq.isEmpty()) {
                minTime += round;
            }
        }

        return minTime;
    }
}