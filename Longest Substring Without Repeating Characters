/* Given a string, find the length of the longest substring without repeating characters. */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        //Implementing sliding window logic
        int a_pointer = 0;  //Keeps the start index
        int b_pointer = 0;  //Slides or traverses the array
        int max = 0;        //Store the max length of hashset as our final result
        
        HashSet<Character> hash_set = new HashSet<>(); 
        
        while (b_pointer<s.length()) {                
            if(!hash_set.contains(s.charAt(b_pointer))) {     //if hashset does not contain current element
                hash_set.add(s.charAt(b_pointer));            //add it to hashset
                b_pointer++;                                  //increment the slider counter
                max = Math.max(hash_set.size(),max);          //update the max length
            }
            else {                                            //if hashset contains current el
                hash_set.remove(s.charAt(a_pointer));         //remove the last seen element from hashset
                a_pointer++;                                  //increment the starter index counter by 1
            }
        }
        return max;
    }
}
