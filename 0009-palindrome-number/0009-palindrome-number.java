class Solution {
    public boolean isPalindrome(int x) {
        // String s = String.valueOf(x);
        // int left =0;
        // int right = s.length() -1;

        // while(left < right) {
        //     if(s.charAt(left) != s.charAt(right)) {
        //         return false;
        //     }
        //     left++;
        //     right--;
        // }
        // return true;

        //Second optimiz approach

        if(x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversed =0;
        while(x > reversed) {
            int digit = x % 10;
            reversed = reversed * 10 + digit;
            x = x / 10;
        }
        return x == reversed || x == reversed / 10;
    }
}