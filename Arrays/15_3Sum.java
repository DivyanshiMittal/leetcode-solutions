//Appoach: Two pointer approach
//We will sort the input array and then use two pointers to find triplets that sum up to zero.
//We will iterate through the sorted array and for each element, we will use two pointers to find pairs that sum up to the negative of the current element.
//We will also skip duplicate elements to avoid duplicate triplets in the result.

//Time Complexity: O(n^2) where n is the length of the input array. Sorting the array takes O(nlogn) and the two pointer approach takes O(n) for each element, resulting in an overall time complexity of O(n^2).
//Space Complexity: O(1) as we are sorting the array in place and using only

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums.length<3){
            return new ArrayList<>();
        }
        
        List<List<Integer>> result=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            
            if (i>0 && nums[i]==nums[i-1]) continue;

            int left=i+1;
            int right=nums.length-1;
            while(left<right){
                int sum=nums[left]+nums[right];
                if((sum+nums[i])<0){
                    left++;
                }
                else if(sum+nums[i]>0){
                    right--;
                }
                else{
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    left++;
                    right--;
                    while(left<right && nums[left]==nums[left-1]) 
                    {left++ ;}
                    while(left<right && nums[right]==nums[right+1]) 
                    {right --;}
                    
                }
            }
        }
        return result;
    }
}