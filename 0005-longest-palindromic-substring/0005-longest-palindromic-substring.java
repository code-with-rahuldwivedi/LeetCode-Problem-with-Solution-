class Solution {
    public String longestPalindrome(String s) {

        if (s == null || s.length() == 0) {
            return "";
        }

        // Step 1: Transform the String
        StringBuilder sb = new StringBuilder("#");

        for (char ch : s.toCharArray()) {
            sb.append(ch).append("#");
        }

        String str = sb.toString();

        int n = str.length();

        // Step 2: Initialize variables
        int[] p = new int[n];

        int center = 0;
        int right = 0;

        int maxLength = 0;
        int centerIndex = 0;

        // Step 3: Iterate through transformed String
        for (int i = 0; i < n; i++) {

            int mirror = 2 * center - i;

            // Step 4: Reuse mirror information
            if (i < right) {
                p[i] = Math.min(right - i, p[mirror]);
            }

            // Step 5: Expand around center
            while (i + p[i] + 1 < n &&
                   i - p[i] - 1 >= 0 &&
                   str.charAt(i + p[i] + 1) ==
                   str.charAt(i - p[i] - 1)) {

                p[i]++;
            }

            // Step 6: Update center and right
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }

            // Step 7: Update longest palindrome
            if (p[i] > maxLength) {
                maxLength = p[i];
                centerIndex = i;
            }
        }

        // Step 8: Extract answer
        int start = (centerIndex - maxLength) / 2;

        return s.substring(start, start + maxLength);
    }
}