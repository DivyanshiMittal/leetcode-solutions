//Approach_1: Brute Force
//Used two nested loops to check complement for each pair of numbers. The complement is calculated as nums[i])=target-nums[j]

//Time Complexity: O(n^2)
//Space Complexity: O(1)

// class Solution {
//     public int[] twoSum(int[] nums, int target) {
        

//         for(int i=0;i<nums.length;i++){
//             for(int j=i+1;j<nums.length;j++){
//                 if(nums[j]==target-nums[i]){
//                     return new int[]{i, j};
//                 }
//             }
//         }

//         return new int[]{};
//     }
// }




//Approach_2: HashMap
//Used HashMap to store visited numbers and checked if complement=target-nums[i] exists.

//Time Complexity: O(n)
//Space Complexity: O(n)


import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<nums.length;i++){
            int complement=target-nums[i];
            if(map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }

            map.put(nums[i],i);
        }
        return new int[]{};
    }
}