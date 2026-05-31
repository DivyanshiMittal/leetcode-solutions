//Approach: Sort the asteroids and then check if the mass is less than the current asteroid, if it is then return false else add the mass of the current asteroid to the total mass and continue checking for the next asteroid. 
//If we are able to check all the asteroids then return true.

//Time Complexity: O(nlogn)--> for sorting the asteroids array.
//Space Complexity: O(1)--> as we are sorting the array in place and using

import java.util.*;
class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {

       long m=mass; //used long to avoid integer overflow when adding the mass of asteroids to the total mass.
       Arrays.sort(asteroids);
       for(int i=0;i<asteroids.length;i++){
        if(m<asteroids[i]){
            return false;
        }
        m=m+asteroids[i];
       }
       return true;
    }
}

//This itself is a valid solution but we can also use a priority queue but it is worse than the above solution as it has a time complexity of O(nlogn) for adding elements to the priority queue and O(nlogn) for removing elements from the priority queue, resulting in an overall time complexity of O(nlogn).
//even bucket sort can be used to sort the asteroids in O(n) time complexity but it is not a good approach as it has a space complexity of O(n) and it is not efficient for large input sizes.