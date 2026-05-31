//Approach_1: HashMap
//Used HashMap to count the frequency of characters in string s and then decremented the count for characters in string t. 
//If any character count becomes negative, it means t has more occurrences of that character than s, and we can return false. 
//If we successfully process all characters in t without any negative counts, then s and t are anagrams, and we return true.

//Time Complexity: O(n)
//Space Complexity: O(n)--> array approach can be used to reduce space complexity to O(1) as we are only dealing with lowercase letters.


import java.util.*;

class Solution {
    public boolean isAnagram(String s, String t) {

        if(s.length()!= t.length()){
            return false;
        }

        
        HashMap<Character,Integer> map=new HashMap<>();

        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        for(int i=0;i<t.length();i++){
            char ch=t.charAt(i);
            map.put(ch,map.getOrDefault(ch,0)-1);
            if(map.get(ch)<0 ){
                return false;
            }
        }

        return true;

        
    }
}


//Approach_2: Array
//Used an array of size 26 to count the frequency of characters in string s and then decremented the count for characters in string t. 
//If any character count becomes negative, it means t has more occurrences of that character than s, and we can return false. 
//If we successfully process all characters in t without any negative

//Time Complexity: O(n)
//Space Complexity: O(1)--> as we are only dealing with lowercase letters(26 in number).

// class Solution {
//     public boolean isAnagram(String s, String t) {
//         int [] count=new int[26];
//         for(char ch:s.toCharArray()){
//             count[ch-'a']++;
//         }
//         for(char ch:t.toCharArray()){
//             count[ch-'a']--;
//         }
//         for(int val:count){
//             if(val != 0){
//                 return false;
//             }
//         }
//         return true;
//     }
// }

