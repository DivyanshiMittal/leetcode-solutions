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