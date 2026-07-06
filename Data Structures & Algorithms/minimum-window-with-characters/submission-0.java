class Solution {
    public String minWindow(String s, String t) {
         if (s.length() < t.length()) {
            return "";
        }

        int[] freq = new int[128];

        // Store frequency of characters in t
        for (char c : t.toCharArray()) {
            freq[c]++;
        }

        int left = 0;
        int right = 0;
        int required = t.length();

        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        while (right < s.length()) {
            char current = s.charAt(right);

            if (freq[current] > 0) {
                required--;
            }

            freq[current]--;
            right++;

            // Try shrinking the window
            while (required == 0) {
                if (right - left < minLength) {
                    minLength = right - left;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                freq[leftChar]++;

                if (freq[leftChar] > 0) {
                    required++;
                }

                left++;
            }
        }

        return minLength == Integer.MAX_VALUE
                ? ""
                : s.substring(startIndex, startIndex + minLength);
        
    }
}
