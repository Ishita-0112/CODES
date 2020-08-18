class Solution {
    public boolean isPalindrome(int x) {
        
        StringBuilder str = new StringBuilder(); 
        str.append(Integer.toString(x));
        
        String revString = str.reverse().toString();
        String initString  = Integer.toString(x);

        if(initString.equals(revString) == true)
            return true;
        else
            return false;
           
    }
}
