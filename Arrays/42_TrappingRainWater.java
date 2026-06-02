//Approach : Two Pointers
//We will maintain two pointers, one starting from the left end of the array and the other starting from the right end.
//We will also maintain two variables, leftMax and rightMax, to keep track of the maximum height of the bars seen so far from the left and right sides, respectively.
//At each step, we will compare the heights at the left and right pointers. If the height at the left pointer is less than the height at the right pointer, we will check if the height at the left pointer is greater than or equal to leftMax.
// if it is, we will update leftMax to the height at the left pointer. Otherwise, we will add the difference between leftMax and the height at the left pointer to the water variable, which keeps track of the total amount of trapped water.
//We will then move the left pointer one step to the right. If the height at the right pointer is less than or equal to the height at the left pointer, we will check if the height at the right pointer is greater than or equal to rightMax.
// If it is, we will update rightMax to the height at the right pointer. Otherwise, we will add the difference between rightMax and the height at the right pointer to the water variable.
//We will then move the right pointer one step to the left. We will continue this process until the left pointer is less than the right pointer, at which point we will have calculated the total amount of trapped water.

//Time Complexity: O(n) where n is the length of the input array. We are iterating through the array once with two pointers.
//Space Complexity: O(1) as we are using only a constant amount of extra space


class Solution {
    public int trap(int[] height) {
        
        int water=0;
        int left=0;
        int right=height.length-1;

        int leftMax=0;
        int rightMax=0;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }
                else{
                    water=water+leftMax-height[left];
                }
                left++;
            }

            else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }
                else{
                    water=water+rightMax-height[right];
                }
                right--;
            }
        }
        return water;
    }
}