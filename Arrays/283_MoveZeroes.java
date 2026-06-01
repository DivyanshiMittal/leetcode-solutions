//Approach: Two pointer approach
//we will maintain two pointers slow and fast, we will iterate the array using fast pointer 
//and whenever we encounter a non zero element we will put it at the index of slow pointer and increment the slow pointer, 
//after the loop ends we will fill the remaining elements with zeroes.

//Time Complexity: O(n) where n is the length of the input array.
//Space Complexity: O(1) as we are modifying the input array in place and not

class Solution {
    public void moveZeroes(int[] nums) {
        int slow=0;
        for(int fast=0;fast<nums.length;fast++){
            if(nums[fast]!=0){
                nums[slow]=nums[fast];
                slow++;
                
            }
        }
        for(int i=slow;i<nums.length;i++){
            nums[i]=0;
        }
    }
}