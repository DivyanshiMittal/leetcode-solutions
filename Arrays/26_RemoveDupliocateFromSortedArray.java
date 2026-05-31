//Approach: Two Pointer
//Used two pointers, one slow and one fast. The fast pointer iterated through the array while the slow pointer kept track of the position of the last unique element. 
//Whenever we found a new unique element (i.e., nums[slow] != nums[fast]), we moved the slow pointer forward and updated the value at the slow pointer to the new unique element found by the fast pointer.
//We also kept track of the count of unique elements (k) which is returned at the end.

//Time Complexity: O(n)
//Space Complexity: O(1)


class Solution {
    public int removeDuplicates(int[] nums) {
        
        int slow=0;
        for(int fast=1;fast<nums.length;fast++){
            if(nums[slow]!=nums[fast]){
                slow++;
                nums[slow]=nums[fast];
                
            }
        }

        return slow+1;
    }
}