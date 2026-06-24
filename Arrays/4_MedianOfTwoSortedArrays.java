// Instead of using binary search, you first merge the two sorted arrays into a 
// new sorted array and then compute the median.

// Time	    Space	
// O(m+n)	O(m+n)

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;

        int [] merged= new int[m+n];
        int i=0;
        int j=0;
        int k=0;

        while(i<m && j<n){
            if(nums1[i]<nums2[j]){
                merged[k++]=nums1[i++];
            }
            else{
                merged[k++]=nums2[j++];
            }
        }

        while(i<m){
            merged[k++]=nums1[i++];
        }

        while(j<n){
            merged[k++]=nums2[j++];
        }

        int sum=m+n;

        if(sum%2==1){
            return merged[sum/2];
        }

        return (merged[sum/2]+merged[sum/2 -1])/2.0;
    }
}