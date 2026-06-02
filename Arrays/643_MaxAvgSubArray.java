//Approach: Sliding Window
//Used a sliding window of size k to calculate the sum of the first k elements and then iterated through the array, 
//adding the next element and removing the first element of the previous window to calculate the sum of the current window.
//We kept track of the maximum average found so far and returned it at the end.


//Time Complexity: O(n) where n is the length of the input array.
//Space Complexity: O(1) as we are using only a constant amount of extra space

class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double sum=0;
        for(int i=0;i<k;i++){
            sum=sum+nums[i];
        }
            double max=sum/k;
        for(int i=k;i<nums.length;i++){
            sum=sum+nums[i];
            sum=sum-nums[i-k];
            max=Math.max(max,sum/k);
        }
        
        return max;
    }
}
