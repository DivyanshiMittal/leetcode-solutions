//Approach: Two Pointers
//Used two pointers, one starting from the beginning of the array and the other from the end.
//We moved the pointers towards each other based on the sum of the numbers at the pointers compared to the target.
//If the sum is greater than the target, we moved the right pointer left; if it's less, we moved the left pointer right.

//Time Complexity: O(n)
//Space Complexity: O(1)

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        int ptr1=0;
        int ptr2=numbers.length-1;

        while(ptr1<ptr2){
            if(numbers[ptr1]+numbers[ptr2]>target){
                ptr2--;
            }
            else if(numbers[ptr1]+numbers[ptr2]<target){
                ptr1++;
            }
            else{
                return new int[]{ptr1+1,ptr2+1};
            }
        }
        return new int[]{};
    }
}