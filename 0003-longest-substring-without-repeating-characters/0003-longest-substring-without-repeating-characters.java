class Solution {
    public int lengthOfLongestSubstring(String s) {
         int strLen = s.length();
         int maxLen =0;

         Map<Character, Integer> map =new HashMap<>();
         for(int rightIdx =0, leftIdx =0; rightIdx < strLen; rightIdx++) {
            if(map.containsKey(s.charAt(rightIdx))) {
                leftIdx =Math.max(map.get(s.charAt(rightIdx)), leftIdx);
            }
            maxLen =Math.max(maxLen, rightIdx - leftIdx + 1);
            map.put(s.charAt(rightIdx), rightIdx + 1);
         }
         return maxLen;
    }
}