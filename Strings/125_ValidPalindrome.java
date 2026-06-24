//Time Complexity
//toLowerCase() → O(n)
// replaceAll() → O(n) (regex processing)
// Two-pointer palindrome check → O(n)

// Overall: O(n)

// Space Complexity
// toLowerCase() creates a new string.
// replaceAll() creates another new string.

// Overall: O(n) extra space.



class Solution {
    public boolean isPalindrome(String str) {
        
        String s=str.toLowerCase().replaceAll("[^a-z0-9]","");

        int i=0;
        int j=s.length()-1;

        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}