//Approach: Array
//Used an array of size 26 to count the frequency of characters in the string. 
//We first counted the frequency of each character in the string and then iterated through the string
//again to find the first character that has a frequency of 1, which is the first unique character.

//Time Complexity: O(n)
//Space Complexity: O(1)--> as we are only dealing with lowercase letters(26 in number).

class Solution {
    public int firstUniqChar(String s) {
        int [] count=new int[26];

        for(char ch:s.toCharArray()){
            count[ch-'a']++;
        }
        for(char ch:s.toCharArray()){
            if(count[ch-'a']==1){
                return s.indexOf(ch);
            }
        }
        return -1;
    }
}


//Approach_2: HashMap
//Used a HashMap to count the frequency of characters in the string and then iterated 
//through the string again to find the first character that has a frequency of 1, which is the first unique character.

//Time Complexity: O(n)
//Space Complexity: O(1)--> as we are only dealing with lowercase letters(26 in number).

// class Solution {
//     public int firstUniqChar(String s) {
//         int [] count=new int[26];

//         for(char ch:s.toCharArray()){
//             count[ch-'a']++;
//         }
//         for(char ch:s.toCharArray()){
//             if(count[ch-'a']==1){
//                 return s.indexOf(ch);
//             }
//         }
//         return -1;
//     }
// }