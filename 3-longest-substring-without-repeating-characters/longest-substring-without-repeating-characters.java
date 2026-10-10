

class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int left = 0;
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            while (seen.contains(ch)) {
                seen.remove(s.charAt(left));
                left++;
            }

            seen.add(ch);
            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }
}