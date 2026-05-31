//Approach: HashSet
//Used HashSet to store visited numbers and checked if current number already exists in the set.

//Time Complexity: O(n)
//Space Complexity: O(n)


import java.util.*;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set=new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }

        return false;
    }
}
