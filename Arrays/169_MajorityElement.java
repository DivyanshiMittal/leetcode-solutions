//Approach: Boyer-Moore Voting Algorithm
//Used two variables, cand and vote, to keep track of the current candidate for majority element and the number of votes it has received.
//We iterated through the array, updating the candidate and vote count based on whether the current number matches the candidate or not.

//Time Complexity: O(n)
//Space Complexity: O(1)


class Solution {
    public int majorityElement(int[] nums) {
        int cand=0;
        int vote=0;

        for(int num:nums){
            if(vote==0){
                cand=num;
                vote=1;
            }
            else if(num==cand){
                vote++;
            }
            else{
                vote--;
            }
        }
        return cand;
    }
}

//Approach_2: HashMap
//Used a HashMap to count the frequency of each element in the array and then found the element with the highest frequency.

//Time Complexity: O(n)
//Space Complexity: O(n)    


// import java.util.*;

// class Solution {
//     public int majorityElement(int[] nums) {
//         HashMap<Integer,Integer> map=new HashMap<>();
//         for(int i=0;i<nums.length;i++){
//             map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
//         }

//         int result=0;
//         int max=0;

//         for(Map.Entry<Integer,Integer> entry: map.entrySet()){
//             if(entry.getValue()>max){
//                 result=entry.getKey();
//                 max=entry.getValue();
//             }
//         }

//         return result;

        
//     }
// }