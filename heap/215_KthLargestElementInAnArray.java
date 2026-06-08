//Approach: 
//We can use a min heap to keep track of the k largest elements in the array.
//We iterate through the array and add each element to the min heap.
//If the size of the min heap exceeds k, we remove the smallest element from the heap.
//After processing all elements, the root of the min heap will be the kth largest element.

//Time Complexity: O(n log k) - We iterate through all n elements and each insertion/deletion operation in the heap takes O(log k).
//Space Complexity: O(k) - The heap will contain at most k elements.


package heap;
import java.util.*;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();

        for(int num:nums){
            minHeap.offer(num);

            if(minHeap.size()>k){
                minHeap.poll();

            }
        }

        return minHeap.peek();
    }
}


//optimal approach: Quickselect algorithm
//The Quickselect algorithm is a selection algorithm to find the kth smallest element in an unordered list.
//It is related to the quicksort sorting algorithm.
//The pivot is chosen randomly, and the array is partitioned into two parts: elements less than the pivot and elements greater than the pivot.
//The algorithm then recursively calls itself on the part of the array that contains the kth largest element.

//Time Complexity: O(n) on average, O(n^2) in the worst case (when the smallest or largest element is always chosen as the pivot).
//Space Complexity: O(1) - The algorithm is in-place and does not require additional space.

// class Solution {
//     public int findKthLargest(int[] nums, int k) {
//         int target = nums.length - k;

//         int left = 0;
//         int right = nums.length - 1;

//         while (left <= right) {
//             int pivotIndex = partition(nums, left, right);

//             if (pivotIndex == target) {
//                 return nums[pivotIndex];
//             } else if (pivotIndex < target) {
//                 left = pivotIndex + 1;
//             } else {
//                 right = pivotIndex - 1;
//             }
//         }

//         return -1;
//     }

//     private int partition(int[] nums, int low, int high) {
//         int pivot = nums[high];
//         int i = low;

//         for (int j = low; j < high; j++) {
//             if (nums[j] < pivot) {
//                 swap(nums, i, j);
//                 i++;
//             }
//         }

//         swap(nums, i, high);
//         return i;
//     }

//     private void swap(int[] nums, int i, int j) {
//         int temp = nums[i];
//         nums[i] = nums[j];
//         nums[j] = temp;
//     }
// }