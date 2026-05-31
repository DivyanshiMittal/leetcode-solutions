//Approach: Bucket Sort
//Used a HashMap to count the frequency of each number in the input array. 
//Then, we created a bucket array where the index represents the frequency and each bucket contains a list of numbers that have that frequency.
//Finally, we traversed the bucket array from the end to the beginning to collect the top k frequent elements until we have collected k elements.

//Time Complexity: O(n) for counting frequencies and O(n) for traversing the bucket array, resulting in O(n) overall.
//Space Complexity: O(n) for the HashMap and O(n) for the bucket array

import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        
        //hashmap for frew --> step 1
        for(int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }

        //bucket list
        List<Integer>[] bucket=new List[nums.length+1];
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            if(bucket[entry.getValue()]==null){
                bucket[entry.getValue()] = new ArrayList<>();
            }
            bucket[entry.getValue()].add(entry.getKey());
            }
        

        //traversing the bucket from back to take the top k freq elements
        int []ans=new int[k];
        int index=0;
        for(int i=bucket.length-1;i>0 && k>0;i--){
            if(bucket[i]!=null){
                for(int num:bucket[i]){
                    ans[index++]=num;
                    k--;
                }
            }
        }
        return ans;
    }
}

//Approach_2:

//Time Complexity: O(n*k)
//Space Complexity: O(n)

// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         int []ans=new int[k];
//         HashMap<Integer,Integer> map=new HashMap<>();

//         for(int num:nums){
//             map.put(num,map.getOrDefault(num,0)+1);
//         }

//         int index=0;
//         while(k>0){
//             int result=0;
//             int max=0;
//             for(Map.Entry<Integer,Integer> entry:map.entrySet()){
//                 if(entry.getValue()>max){
//                     max=entry.getValue();
//                     result=entry.getKey();
//                 }
//             }
//             ans[index++]=result;
//             map.remove(result);
//             k--;
//         }

//         return ans;
//     }
// }