//Approach:
//We iterated through the array and for each number, we calculated the sum of its digits by repeatedly taking the modulus by 10 to get the last digit and dividing by 10 to remove the last digit until the number becomes 0.
//We replaced each number in the array with the sum of its digits. 
//Finally, we iterated through the modified array to find and return the minimum value.

//Time Complexity: O(n * m) where n is the length of the array and m is the number of digits in the largest number in the array.
//Space Complexity: O(1) as we are modifying the input array in place and using


class Solution {
    public int minElement(int[] nums) {
        
        for(int i=0;i<nums.length;i++){
            int sum=0;
            while(nums[i]>0){
                sum=sum+(nums[i]%10);
                nums[i]=nums[i]/10;
            }
            nums[i]=sum;
        }
        int min=nums[0];
        for(int num:nums){
            if(num<min){
                min=num;
            }
        }

        return min;
    }
}