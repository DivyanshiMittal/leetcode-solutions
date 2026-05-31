//Approach: HashSet
//Used HashSet to store unique numbers and checked for the longest consecutive sequence by checking if the current number is the start of a sequence (i.e., num-1 is not in the set). 
//If it is the start of a sequence, we then check for the length of the sequence by continuously checking for the next number (num+length) in the set until we find a number that is not in the set.
//We keep track of the longest sequence found.

//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set=new HashSet<>();
        
        for(int i=0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int longest=0;

        for(int num:set){
            if(!set.contains(num-1)){
                int length=1;
                while(set.contains(num+length)){
                    length++;
                }
                longest=Math.max(longest,length);
            }
        }

        return longest;

    }
}