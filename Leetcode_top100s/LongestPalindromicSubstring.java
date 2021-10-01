class Solution {
    public String longestPalindrome(String s) {
//Check whether the string is empty or len<1 --> ret empty string
        if (s==null || s.length()<1) return "";
//start and end ptrs --> 0
        int start = 0;
        int end = 0;
//Traverse the string and pass in the string and the posns into the function
//Now two conditions --> "racecar" && "abba" --> 1st case start and end with same posn..as e is the unique part in the string
//2nd case ith and i+1 th posn
        for(int i=0; i<s.length(); i++){
            int len1 = expandFromMiddle(s,i,i);
            int len2 = expandFromMiddle(s,i,i+1);
//Take the max of two length cases
            int len = Math.max(len1,len2);
//Now only if len > ending - start --> that means it always takes the max of length --> set the start of the palindromic string and the end of the same
            if (len>end-start){
                start = i-((len-1)/2);
                end = i+(len/2);
            }
        }
        return s.substring(start,end+1);
    }
//This is the function that returns the length of the palindromic string
    
    public int expandFromMiddle(String s, int left, int right){
        if (s==null || left>right) return 0;
        
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }
        return right-left-1;
    }
}
