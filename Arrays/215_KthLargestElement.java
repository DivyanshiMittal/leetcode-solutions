//optimal approach: Quickselect algorithm
//The Quickselect algorithm is a selection algorithm to find the kth smallest element in an unordered list.
//It is related to the quicksort sorting algorithm.
//The pivot is chosen randomly, and the array is partitioned into two parts: elements less than the pivot and elements greater than the pivot.
//The algorithm then recursively calls itself on the part of the array that contains the kth largest element.

//Time Complexity: O(n) on average, O(n^2) in the worst case (when the smallest or largest element is always chosen as the pivot).
//Space Complexity: O(1) - The algorithm is in-place and does not require additional space.

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int target = nums.length - k;

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int pivotIndex = partition(nums, left, right);

            if (pivotIndex == target) {
                return nums[pivotIndex];
            } else if (pivotIndex < target) {
                left = pivotIndex + 1;
            } else {
                right = pivotIndex - 1;
            }
        }

        return -1;
    }

    private int partition(int[] nums, int low, int high) {
        int pivot = nums[high];
        int i = low;

        for (int j = low; j < high; j++) {
            if (nums[j] < pivot) {
                swap(nums, i, j);
                i++;
            }
        }

        swap(nums, i, high);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}