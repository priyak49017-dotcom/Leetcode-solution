class Solution {
    public String reorganizeString(String s) {
        int[] freq = new int[26];

        for (char ch : s.toCharArray()) {
            freq[ch - 'a']++;
        }

        int max = 0;
        int maxIndex = 0;

        for (int i = 0; i < 26; i++) {
            if (freq[i] > max) {
                max = freq[i];
                maxIndex = i;
            }
        }

        if (max > (s.length() + 1) / 2) {
            return "";
        }

        char[] result = new char[s.length()];
        int position = 0;

        
        while (freq[maxIndex] > 0) {
            result[position] = (char) ('a' + maxIndex);
            position += 2;
            freq[maxIndex]--;

            if (position >= s.length()) {
                position = 1;
            }
        }

        
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                result[position] = (char) ('a' + i);
                position += 2;
                freq[i]--;

                if (position >= s.length()) {
                    position = 1;
                }
            }
        }

        return new String(result);
    }
}