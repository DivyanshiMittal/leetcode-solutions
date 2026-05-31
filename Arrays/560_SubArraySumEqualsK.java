//Approach: Prefix Sum + HashMap
//Used a HashMap to store the cumulative sum of elements up to the current index and their frequencies.
//We iterated through the array and for each element, we calculated the cumulative sum and checked if there is a previous cumulative sum that equals the current cumulative sum minus k.
//If such a sum exists, it means there is a subarray that sums to k, and we added the frequency of that cumulative sum to our count of subarrays.

//Time Complexity: O(n)
//Space Complexity: O(n)

import java.util.*;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);

        int sum=0;
        int ctr=0;
        for(int i=0;i<nums.length;i++){
            sum=sum+nums[i];
            if(map.containsKey(sum-k)){
                ctr=ctr+(map.get(sum-k));
            }

            map.put(sum,map.getOrDefault(sum,0)+1);

        }
        return ctr;
    }
}


//Approach_2: Brute Force
//Used two nested loops to calculate the sum of all possible subarrays and checked if the sum equals k.
//If it does, we incremented our count of subarrays.

//Time Complexity: O(n^2)
//Space Complexity: O(1)

// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         int ctr=0;
//         for(int i=0;i<nums.length;i++){
//             int sum=0;
//             for(int j=i;j<nums.length;j++){
//                 sum=sum+nums[j];
//                 if(sum==k){
//                     ctr++;
//                 }
//             }
//         }
//         return ctr;
//     }
// }