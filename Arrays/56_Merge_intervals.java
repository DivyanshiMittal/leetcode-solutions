// Time Complexity

// Sorting : O(n log n)
// Traversal : O(n)
// Overall : O(n log n)

// Space Complexity
// O(n)
// for storing the merged intervals.

import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        //Sort the arrays based on the first element of each arrays
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));

        //stores the merged arrays
        List<int[]> merged=new ArrayList<>();

        for(int[]interval:intervals){
            //if the merged is empty or there is no overlapping then add to merged
            
            if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]){
                merged.add(interval);
            }
            else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],interval[1]);
            }
        }

        //convert arraylist to 2d array
        return merged.toArray(new int [merged.size()][]);
    }

}