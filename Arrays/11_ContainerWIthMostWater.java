//Approach: Two Pointer
//Used two pointers, one starting from the beginning of the array and the other from the end. 
//We calculated the area formed by the lines at the two pointers and kept track of the maximum area found. 
//We then moved the pointer that pointed to the shorter line inward, as moving the longer line inward would not increase the area.

//Time Complexity: O(n) where n is the length of the input array.
//Space Complexity: O(1) as we are using only a constant amount of extra space


class Solution {
    public int maxArea(int[] height) {
        int left=0;
        int right=height.length-1;
        int max=0;

        while(left<right){
            int width=Math.min(height[left],height[right]);
            int length=right-left;
            int area=length*width;

            max=Math.max(area,max);

            //bring the shorter wall inwards
            if(height[left]<height[right]){
                left++;
            }
            else{
            right--;
            }
        }
        return max;
    }
}