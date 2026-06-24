//Approach: Sliding Window
//We will maintain a sliding window and a count array to keep track of the frequency of characters in the current window.
//We will also maintain a variable maxFreq to keep track of the maximum frequency of any character in the current window.
//At each step, we will check if the size of the current window minus the maxFreq is greater than k.
//If it is, it means we need to shrink the window from the left until the condition is satisfied. We will also update the maxFreq and the count array accordingly.
//Finally, we will keep track of the maximum length of the valid window found so far and return it at the end.

//Time Complexity: O(n) where n is the length of the input string. We are iterating through the string once with the right pointer and at most once with the left pointer.
//Space Complexity: O(1) as we are using a count array of fixed size


class Solution {
    public int characterReplacement(String s, int k) {
        int [] count=new int[26];

        int left=0;
        int maxFreq=0;
        int windowLength=0;

        for(int right=0;right<s.length();right++){
            count[s.charAt(right)-'A']++;
            maxFreq=Math.max(maxFreq,count[s.charAt(right)-'A']);

            while((right-left+1)-maxFreq>k){ //window size is right-left+1
                count[s.charAt(left)-'A']--;
                left++;
            }

            windowLength=Math.max(windowLength,right-left+1);
        }

        return windowLength;
    }
}