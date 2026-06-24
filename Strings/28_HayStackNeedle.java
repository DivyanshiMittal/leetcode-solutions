//approach 1: Brute Force
//Time Complexity: O(n*m) where n is the length of haystack and m is the length of needle.
//Space Complexity: O(1) as we are using only a constant amount of extra space.

class Solution {
    public int strStr(String haystack, String needle) {

        int n = haystack.length();
        int m = needle.length();

        for (int i = 0; i <= n - m; i++) {

            int j = 0;

            while (j < m && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == m) {
                return i;
            }
        }

        return -1;
    }
}