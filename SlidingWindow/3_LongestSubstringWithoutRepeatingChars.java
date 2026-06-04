//approach: Sliding Window
//We will maintain a sliding window of characters and a HashSet to keep track of the unique characters in the current window. We will use two pointers, left and right, to represent the current window.
//We will iterate through the string with the right pointer and check if the current character is already in the HashSet. 
//If it is, we will shrink the window from the left until we remove the duplicate character from the HashSet.
//We will then add the current character to the HashSet and update the maximum length of the substring without repeating characters.

//Time Complexity: O(n) where n is the length of the input string. We are iterating through the string once with the right pointer, and in the worst case, we may need to move the left pointer n times as well.
//Space Complexity: O(min(m, n)) where m is the size of the character set and n is the length of the input string. In the worst case, we may need to store all unique characters in the HashSet, which can be at most the size of the character set or the length of the string, whichever is smaller.

import java.util.*;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int left=0;
        int maxLen=0;

        for(int right = 0; right < s.length(); right++){
        
        while(set.contains(s.charAt(right))){  // when to shrink?
            set.remove(s.charAt(left));        // remove from set
            left++;                            // move left
        }
        
        set.add(s.charAt(right));              // add current char to set
        maxLen = Math.max(maxLen, right - left + 1); // update maxLen
    }
    
    return maxLen;
    }
}